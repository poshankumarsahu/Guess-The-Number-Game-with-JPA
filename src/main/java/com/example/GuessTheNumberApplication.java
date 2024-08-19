package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
public class GuessTheNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessTheNumberApplication.class, args);
		System.out.println("Running Guess the number Game");
	}

}
