package com.novaservices.training.webshop.security;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final String BEARER = "Bearer ";
	public static final String AUTHORIZATION = "Authorization";
	public static final String JWT_SECRET = "mysecret";
	public static final String AUTHORITIES = "authorities";
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pass));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String jwt = JWT.create()
			.withSubject(((UserDetails)authResult.getPrincipal()).getUsername())
			.withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)))
			.withArrayClaim(AUTHORITIES, 
					authResult.getAuthorities()
					.stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList()).toArray(new String[0]))
			.sign(Algorithm.HMAC512(JWT_SECRET));
		
		response.addHeader(AUTHORIZATION, BEARER + jwt);
	}
	
	

}
