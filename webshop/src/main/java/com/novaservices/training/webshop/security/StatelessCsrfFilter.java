package com.novaservices.training.webshop.security;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class StatelessCsrfFilter extends OncePerRequestFilter {

	private static final String CSRF_COOKIE = "CSRF-TOKEN";
	private static final String CSRF_HEADER = "X-CSRF-TOKEN";
	
	private final Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if(requiresCsrfProtection(request)) {
			String csrfHeaderValue = request.getHeader(CSRF_HEADER);
			
			String csrfCookieValue = null;
//			Cookie[] cookies = request.getCookies();
//			if(cookies != null) {
//				Cookie csrfCookie = Stream.of(cookies)
//				.filter(c -> c.getName().equals(CSRF_COOKIE))
//				.findFirst()
//				.orElseThrow(() -> createCsrfException());
//				csrfCookieValue = csrfCookie.getValue();
//			}
			Cookie csrfCookie = WebUtils.getCookie(request, CSRF_COOKIE);
			if(csrfCookie != null)
				csrfCookieValue = csrfCookie.getValue();
			
			if(csrfCookieValue == null || !csrfCookieValue.equals(csrfHeaderValue)) {
				throw createCsrfException();
			}
		}
		
		filterChain.doFilter(request, response);
	}



	private AccessDeniedException createCsrfException() {
		return new AccessDeniedException("CSRF token not found in cookie");
	}



	private boolean requiresCsrfProtection(HttpServletRequest request) {
		return !allowedMethods.matcher(request.getMethod()).matches();
	}

}
