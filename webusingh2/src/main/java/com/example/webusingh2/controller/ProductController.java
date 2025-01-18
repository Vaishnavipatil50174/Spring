package com.example.webusingh2.controller;

import com.example.webusingh2.model.Product;
import com.example.webusingh2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product>showProduct(){
        return productService.show();

    }

    @PostMapping("/addproducts")
    public void add(@RequestBody Product product){
        productService.addProduct(product);
    }
}
