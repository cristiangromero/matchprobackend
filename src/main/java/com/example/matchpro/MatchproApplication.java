package com.example.matchpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class MatchproApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchproApplication.class, args);
	}

}
