package com.campusguidedemo.app.campusguide;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CampusguideConfig extends WebSecurityConfigurerAdapter{
	
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.inMemoryAuthentication()
    .withUser("Saikiran").password("{noop}sai").roles("admin")
    .and()
    .withUser("kiran").password("{noop}ki").roles("user");
	}
  @Override
protected void configure(HttpSecurity http) throws Exception {
    /* http.authorizeRequests()
     .antMatchers("/admin").hasRole("ADMIN")
     .antMatchers("/student").hasRole("USER")
     .and().httpBasic();
     http.csrf().disable();*/
	  
	  http.csrf().disable().authorizeRequests().antMatchers("/admin").hasRole("admin")
	  .and().formLogin();
	  http.csrf().disable().authorizeRequests().antMatchers("/student").hasRole("user")
	  .and().formLogin();
	  
}
}
