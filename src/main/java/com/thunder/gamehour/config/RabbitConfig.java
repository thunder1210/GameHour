package com.thunder.gamehour.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.ConfirmType;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thunder.gamehour.systemconst.SystemConst;

import lombok.extern.slf4j.Slf4j;

/**
 * RabbitMQ Config
 */
@Slf4j
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
	 * RabbitMQ 連線池設置
	 * 
	 * @return connectionFactory
	 */
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(VIRTUAL_HOST);
		connectionFactory.setPublisherConfirmType(ConfirmType.CORRELATED);
		return connectionFactory;
	}

	/**
	 * RabbitAdmin Config
	 * 
	 * @param connectionFactory connection Item
	 * @return Connected RabbitAdmin
	 */
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	/**
	 * RabbitTemplate 顯示發送訊息是否成功
	 * 
	 * @param connectionFactory connection Item
	 * @return RabbitTemplate
	 */
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SystemConst.TIME_FORMAT);
		// Set ConfirmCallback
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				log.info("RabbitMQ訊息發送成功", now.format(formatter));
			} else {
				log.info("RabbitMQ訊息發送失敗", now.format(formatter));
			}
		});
		return rabbitTemplate;
	}

}
