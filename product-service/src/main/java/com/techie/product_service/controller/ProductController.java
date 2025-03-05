package com.techie.product_service.controller;
import com.techie.product_service.model.Product;
import com.techie.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postproduct(@RequestBody Product productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> allproduct() {
        return productService.all();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> serach(@PathVariable Integer id){
        return new ResponseEntity<>(productService.searchById(id),HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> partial(@PathVariable Integer id, @RequestBody Map<String,Object>updates){
        return new ResponseEntity<>(productService.updateProductPartially(id,updates),HttpStatus.OK);
    }

}
