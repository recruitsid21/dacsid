package com.example.EventRegistrationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "dao", "model"})
public class EventRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRegistrationSystemApplication.class, args);
	}
	

}
