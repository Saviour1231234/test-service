package com.example.usertestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTestProjectApplication.class, args);
	}

}
