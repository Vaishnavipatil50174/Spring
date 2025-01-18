package com.techie.product_service.controller;

import com.techie.product_service.dto.ProductRequest;
import com.techie.product_service.dto.ProductResponse;
import com.techie.product_service.model.Product;
import com.techie.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
//
//    @Autowired
//    ProductService productService;
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void postproduct(@RequestBody ProductRequest productRequest){
//        productService.createProduct(productRequest);
//
//
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> allproduct(){
//        return productService.all();
//
//    }

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postproduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> allproduct() {
        return productService.all();
    }

}
