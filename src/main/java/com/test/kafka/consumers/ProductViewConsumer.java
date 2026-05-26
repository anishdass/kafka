package com.test.kafka.consumers;

import com.test.kafka.models.ProductViewEvent;
import com.test.kafka.services.ProductViewRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductViewConsumer {
    private final ProductViewRedisService redisService;

    @KafkaListener(topics = "product-view-events", groupId = "product-group")
    public void consume(ProductViewEvent event){
        System.out.println("Consumed: " + event.getProductName());
        redisService.incrementView(event.getProductId());
    }
}
