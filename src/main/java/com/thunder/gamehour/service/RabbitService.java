package com.thunder.gamehour.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.Queue;
import java.nio.charset.StandardCharsets;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.systemconst.SystemConst;
import lombok.RequiredArgsConstructor;

/**
 * 處理RabbitMQ相關事務邏輯
 */
@Service
@RequiredArgsConstructor
public class RabbitService {

	private final RabbitAdmin rabbitAdmin;

	private final ObjectMapper objectMapper;

	private final RabbitTemplate rabbitTemplate;

	/**
	 * 創建Exchange交換機
	 */
	public void createExchange(String exchangeName, String exchangeType) {

		switch (exchangeType) {
		case SystemConst.EXCHANGE_TYPE_DIRECT: {
			rabbitAdmin.declareExchange(new DirectExchange(exchangeName));
			break;
		}
		case SystemConst.EXCHANGE_TYPE_FANOUT: {
			rabbitAdmin.declareExchange(new FanoutExchange(exchangeName));
			break;
		}
		case SystemConst.EXCHANGE_TYPE_TOPIC: {
			rabbitAdmin.declareExchange(new TopicExchange(exchangeName));
			break;
		}
		default:
			throw new IllegalArgumentException("Unsuppoerted exchangeType：".concat(exchangeType));
		}

	}

	/**
	 * 創建Rabbit Queue
	 * 
	 * @param queueName 隊列名稱
	 */
	public void createRabbitQueue(String queueName) {

		Binding binding;
		Queue queue = new Queue(queueName, true);
		DirectExchange exchange = new DirectExchange(SystemConst.GAME_ROOM_EXCHANGE);
		rabbitAdmin.declareExchange(exchange);

		switch (queueName) {
		case "tempGameRoomQueue": {
			queue.addArgument("x-message-ttl", SystemConst.GAME_ROOM_EFFECTIVE_TIME);
			queue.addArgument("x-dead-letter-exchange", SystemConst.GAME_ROOM_EXCHANGE);
			queue.addArgument("x-dead-letter-routing-key", SystemConst.DEAD_LETTER_ROUTING_KEY);
			binding = BindingBuilder.bind(queue).to(exchange).with(SystemConst.GAME_ROOM_EXCHANGE_ROUTING_KEY);
			break;
		}
		case "deadLetterGameRoomQueue": {
			binding = BindingBuilder.bind(queue).to(exchange).with(SystemConst.DEAD_LETTER_ROUTING_KEY);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected QueueName：".concat(queueName));
		}
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareBinding(binding);
	}

	/**
	 * 發送遊戲房資訊到Queue
	 * 
	 * @param exchangeName 交換機名稱
	 * @param routingKey   RoutingKey名稱
	 * @param gameRoom     遊戲房名稱
	 * @throws JsonProcessingException Json處理例外拋出
	 */
	public void sendOutGameRoomMessage(String exchangeName, String routingKey, GameRoom gameRoom)
			throws JsonProcessingException {
		Message rabbitMessage = MessageBuilder.withBody(objectMapper.writeValueAsString(gameRoom).getBytes())
				.setContentType("application/json").setContentEncoding(StandardCharsets.UTF_8.toString()).build();
		rabbitTemplate.convertAndSend(exchangeName, routingKey, rabbitMessage);
	}

}
