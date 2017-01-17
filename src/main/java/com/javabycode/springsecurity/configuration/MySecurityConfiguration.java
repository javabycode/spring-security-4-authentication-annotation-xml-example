package com.javabycode.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("javabycode").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("root").password("root123").roles("ADMIN","ROOT");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
	  	.antMatchers("/").permitAll() 
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/root/**").access("hasRole('ADMIN') and hasRole('ROOT')")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/error");
 
	}
}
