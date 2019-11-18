package com.prashant.employee.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
	@Value("${ignore.security.endpoints}")
	String ignoredEndpoints;

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().mvcMatchers(ignoredEndpoints.split(";"));
    
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().httpBasic().disable();
  }
  
 
}
