package com.test.kafka.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductViewEvent {
    private Long productId;
    private String productName;
}
