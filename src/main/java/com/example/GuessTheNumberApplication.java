package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuessTheNumberApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(GuessTheNumberApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GuessTheNumberApplication.class, args);
		logger.info("Running Guess The Number Game 2");
	}

}
