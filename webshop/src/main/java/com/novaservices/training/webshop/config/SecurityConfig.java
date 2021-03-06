package com.novaservices.training.webshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

import com.novaservices.training.webshop.security.JWTAuthenticationFilter;
import com.novaservices.training.webshop.security.JWTAuthorizationFilter;
import com.novaservices.training.webshop.security.StatelessCsrfFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    	.passwordEncoder(encoder())	    	
	        .withUser("admin").password(encoder().encode("pass")).roles("ADMIN")
	        .and()
	        .withUser("user")
	        .password(encoder().encode("pass")).roles("USER");
	}
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	    http
	    	.httpBasic()
	    .and()
	    	.csrf().disable()
	    .authorizeRequests()
		    .antMatchers(HttpMethod.GET, "/api/products/**").permitAll()
		    .antMatchers(HttpMethod.POST, "/api/products").authenticated()
		    .antMatchers(HttpMethod.POST, "/api/categories").hasRole("ADMIN")
		    .antMatchers("/**").denyAll()
	    .and()
	    	.addFilter(new JWTAuthenticationFilter(authenticationManager()))
	    	.addFilter(new JWTAuthorizationFilter(authenticationManager()))
	    	.addFilterBefore(new StatelessCsrfFilter(), CsrfFilter.class)
	    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    ;
	}
}
