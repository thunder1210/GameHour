package com.thunder.gamehour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Springboot start Application
 */
@EnableCaching
@SpringBootApplication
public class GamehourApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamehourApplication.class, args);
	}

}
