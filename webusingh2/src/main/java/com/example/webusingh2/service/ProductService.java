package com.example.webusingh2.service;

import com.example.webusingh2.model.Product;
import com.example.webusingh2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product>show(){
        return repo.findAll();
    }

//    public List<Product> getAllProducts() {
//        Iterable<Product> iterable = repo.findAll();  // Find all returns Iterable
//        return StreamSupport.stream(iterable.spliterator(), false)  // Convert to Stream
//                .collect(Collectors.toList());  // Collect to List
//    }
    public void addProduct(Product p1){
        repo.save(p1);
    }



}
