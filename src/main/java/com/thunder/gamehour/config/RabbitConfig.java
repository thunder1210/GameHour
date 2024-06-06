package com.thunder.gamehour.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ Config
 */
@Configuration
public class RabbitConfig {

	@Value("${spring.rabbitmq.host}")
	private String host;

	@Value("${spring.rabbitmq.port}")
	private int port;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	private static final String VIRTUAL_HOST = "/";

	/**
	 * Connection Factory for Rabbit MQ
	 * 
	 * @return connectionFactory
	 */
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(VIRTUAL_HOST);
		return connectionFactory;
	}

	/**
	 * RabbitAdmin Config
	 * 
	 * @param connectionFactory
	 * @return Connected RabbitAdmin
	 */
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

}
