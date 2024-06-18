package com.thunder.gamehour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.thunder.gamehour.systemconst.SystemConst;

/**
 * WebSocket Config
 */
@Configuration
public class WebSocketConfig {

	/**
	 * The component of Websocket to scan and management
	 * 
	 * @return ServerEndpointExporter
	 */
	@Bean
	ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}