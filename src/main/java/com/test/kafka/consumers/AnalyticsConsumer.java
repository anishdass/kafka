package com.test.kafka.consumers;

import com.test.kafka.models.ProductViewEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsConsumer {
    @KafkaListener(topics = "product-view-events", groupId = "product-group")
    public void consume(ProductViewEvent event){
        System.out.println("Analytics updated for -> "+ event.getProductName());
    }
}
