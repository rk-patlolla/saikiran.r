package com.campusguidedemo.app.campusguide;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CampusguideConfig extends WebSecurityConfigurerAdapter{
	 @Autowired
	 SimpleAuthenticationSuccessHandler customSuccessHandler;
	 @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
	 @Autowired
	    DataSource dataSource;
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*auth.inMemoryAuthentication()
    .withUser("Saikiran").password("{noop}sai").roles("ADMIN")
    .and()
    .withUser("kiran").password("{noop}ki").roles("USER");*/
	   auth.jdbcAuthentication().dataSource(dataSource)
       .passwordEncoder(passwordEncoder())
              .usersByUsernameQuery("select student_name,student_password,mobile_no from student where student_name=?")
               .authoritiesByUsernameQuery("select student_name, student_role from student where student_name=?");
	}
  @Override
protected void configure(HttpSecurity http) throws Exception {
    /* http.authorizeRequests()
     .antMatchers("/admin").hasRole("ADMIN")
     .antMatchers("/student").hasRole("USER")
     .and().httpBasic();
     http.csrf().disable();*/
	  
	  http.csrf().disable().authorizeRequests()
	 
      .antMatchers("/admin","/addCourse","/editCourse","/getStudent","/aviewStudentDetails").hasRole("ADMIN")
	  .antMatchers("/studenthome").hasRole("USER")
	  .antMatchers("/userlogin").hasAnyRole("ADMIN","USER").anyRequest().authenticated()
		
	  .antMatchers("/index").hasAnyRole("ADMIN","USER").anyRequest().permitAll()
	  
	
	  .and().formLogin().failureForwardUrl("/login")
	  .and().logout().logoutSuccessUrl("/index")
	  .invalidateHttpSession(true)
	  .and().exceptionHandling().accessDeniedPage("/accesDenied");
	 
	 
	  
}
}
