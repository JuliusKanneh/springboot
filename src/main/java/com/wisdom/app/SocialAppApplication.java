package com.wisdom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "user")
@ComponentScan(basePackages = "location")
@ComponentScan(basePackages = "post")

public class SocialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAppApplication.class, args);
	}

}
