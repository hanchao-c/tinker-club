package org.tinker.order.server.redis;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.tinker.order.server.ApplicationTestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringDataRedisIntegrationTest extends ApplicationTestContext{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	private final String TEST_KEY = "ABCDEFG";
	
	@Test
	public void testIntegration() {
		log.info(StringUtils.wrap("Spring-data-redis integration test", " ===================== "));
		redisTemplate.opsForValue().set(TEST_KEY, TEST_KEY, Duration.ofSeconds(20));
		redisTemplate.delete(TEST_KEY);
		Assert.assertNull(redisTemplate.opsForValue().get(TEST_KEY));
	}
}
