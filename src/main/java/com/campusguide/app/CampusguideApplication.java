package com.campusguide.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScan("com.campusguide")*/
@EntityScan(basePackages="com.campusguide.app")
@EnableJpaRepositories(basePackages="com.campusguide.app")
public class CampusguideApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CampusguideApplication.class, args);
		
		
	}
}
