package com.thunder.gamehour.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.cache.interceptor.KeyGenerator;

import com.thunder.gamehour.systemconst.SystemConst;

/**
 * 設置Springboot Redis緩存機制
 */
@Configuration
@EnableCaching
@Component("myKeyGenerator")
public class RedisCacheConfig implements KeyGenerator {

	/**
	 * 緩存管理設置
	 * 
	 * @param redisConnectionFactory
	 * @return RedisCacheManager
	 */
	@Bean
	CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(java.time.Duration.ofMinutes(SystemConst.CACHE_TTL_TIME))
				.computePrefixWith(cacheName -> SystemConst.EMPTY_STRING + cacheName)
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();
	}

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return SystemConst.EMPTY_STRING;
	}

}
