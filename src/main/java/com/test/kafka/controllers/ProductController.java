package com.test.kafka.controllers;

import com.test.kafka.models.ProductViewEvent;
import com.test.kafka.services.ProductEventProducer;
import com.test.kafka.services.ProductViewRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductEventProducer producer;
    private final ProductViewRedisService redisService;

    @PostMapping("/view")
    public String view(@RequestBody ProductViewEvent event){
        producer.send(event);
        return "Event sent to kafka";
    }

    @GetMapping("/count/{productId}")
    public String getCount(@PathVariable Long productId){
        return redisService.getViews(productId);
    }
}
