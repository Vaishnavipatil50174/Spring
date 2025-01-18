package com.techie.product_service.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
