package com.example.webByTelusko.controller;

import com.example.webByTelusko.model.Product;
import com.example.webByTelusko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/product")
    List<Product> show(){
        return productService.allProduct();
    }
    @RequestMapping("/product/{productId}")
    Product showById( @PathVariable int productId){
        return productService.getById(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody  Product p){
        productService.addProduct(p);
    }
}
