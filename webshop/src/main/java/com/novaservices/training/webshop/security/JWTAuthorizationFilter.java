package com.novaservices.training.webshop.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authHeaderValue = request.getHeader(JWTAuthenticationFilter.AUTHORIZATION);
		
		if(authHeaderValue == null || ! authHeaderValue.startsWith(JWTAuthenticationFilter.BEARER)) {
			chain.doFilter(request, response);
			return;
		}
		
		String jwtString = authHeaderValue.substring(JWTAuthenticationFilter.BEARER.length());
		DecodedJWT verifiedJwt = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.JWT_SECRET))
			.build()
			.verify(jwtString);
		
		String username = verifiedJwt.getSubject();
		
		List<SimpleGrantedAuthority> authList = verifiedJwt
			.getClaim(JWTAuthenticationFilter.AUTHORITIES)
			.asList(String.class).stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
		
		UsernamePasswordAuthenticationToken authentication 
			= new UsernamePasswordAuthenticationToken(username, null, authList);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		chain.doFilter(request, response);	
	}

	
	
}
