package cn.yhd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Redis 连接配置
 */
@Configuration
public class RedisConfig {




//	@Bean(name = "redisTemplate")
//	public RedisTemplate<String, String> redisTemplate() {
//		RedisTemplate redisTemplate = new RedisTemplate();
//		RedisSerializer stringSerializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(stringSerializer);
//		redisTemplate.setValueSerializer(stringSerializer);
//		redisTemplate.setHashKeySerializer(stringSerializer);
//		redisTemplate.setHashValueSerializer(stringSerializer);
//		return redisTemplate;
//	}
}
