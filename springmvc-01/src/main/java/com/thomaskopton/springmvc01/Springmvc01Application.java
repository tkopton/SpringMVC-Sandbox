package com.thomaskopton.springmvc01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.thomaskopton.springmvc01config", "com.thomaskopton.springmvc01controller", 
	"com.thomaskopton.springmvc01exceptions", "com.thomaskopton.springmvc01domain.service",
	"com.thomaskopton.springmvc01domain.repository"})
@EntityScan({"com.thomaskopton.springmvc01domain", "com.thomaskopton.springmvc01domain.repository"})
@EnableJpaRepositories("com.thomaskopton.springmvc01domain.repository")
@SpringBootApplication
public class Springmvc01Application {

	public static void main(String[] args) {
		SpringApplication.run(Springmvc01Application.class, args);
	}
}
