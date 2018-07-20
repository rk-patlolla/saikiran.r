package com.campusguidedemo.app.campusguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.campusguidedemo.app")
@EnableJpaRepositories(basePackages = "com.campusguidedemo.app")
@ComponentScan("com.campusguidedemo.app")
@PropertySource("classpath:message.properties")
public class CampusguideApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CampusguideApplication.class, args);
	}
}
