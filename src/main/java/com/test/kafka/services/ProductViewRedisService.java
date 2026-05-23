package com.test.kafka.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductViewRedisService {
    private final StringRedisTemplate redisTemplate;

    public void incrementView(Long productId) {
        String key = "product:view" + productId;
        redisTemplate.opsForValue().increment(key);
    }

    public String getViews(Long productId) {
        String key = "product:view" + productId;
        return redisTemplate.opsForValue().get(key);
    }
}
