package com.epam.TechSpringBoot1.controller;

import com.epam.TechSpringBoot1.model.Product;
import com.epam.TechSpringBoot1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/greet")
    public String greet(){
        return "WelcomeToEPAM";
    }

    @GetMapping("/product")
    public List<Product> display(){
        return productService.showAll();
    }
    @PostMapping("/add")
    public void adding(@RequestBody Product product){
        productService.addnew(product);
    }
    @PutMapping("/upadte/{id}")
    public void update(@PathVariable Integer id,@RequestBody Product product){
        productService.update(id,product);
    }
    @GetMapping("{id}")
    public Product byId(@PathVariable Integer id){
        return productService.usingId(id);
    }
    @DeleteMapping("/del/{id}")
    public void del(@PathVariable Integer id){
        productService.deleteById(id);
    }

}
