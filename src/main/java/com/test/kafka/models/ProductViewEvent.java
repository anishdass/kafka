package com.test.kafka.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductViewEvent {
    private Long productId;
    private String productName;

    public ProductViewEvent() {
    }

    public ProductViewEvent(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
