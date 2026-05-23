package com.test.kafka.services;

import com.test.kafka.models.ProductViewEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductEventProducer {
    private final KafkaTemplate<String, ProductViewEvent> kafkaTemplate;

    public void send(ProductViewEvent event) {
        kafkaTemplate.send("product-view-events", event);
        System.out.println("Sent: " + event.getProductName());
    }
}
