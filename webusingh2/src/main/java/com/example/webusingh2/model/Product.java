package com.example.webusingh2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Entity
public class Product {
    @Id

    private Integer productId;
    private String productName;
}
