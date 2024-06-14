package com.thunder.gamehour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket Config
 */
@Configuration
public class WebSocketConfig {

	@Bean
	ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}