package com.thunder.gamehour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Config for Swagger
 */
@Configuration
public class SwaggerConfig {

	/**
	 * OpenAPI Settings
	 * 
	 * @return OpenAPI
	 */
	@Bean
	OpenAPI swaggerOpenApi() {
		return new OpenAPI().info(new Info().title("GameHour")
				.description("a side project of GameHour, a real-time gamer website").version("v1.0.0"));
	}
}