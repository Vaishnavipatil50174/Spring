package com.example.webByTelusko.service;

import com.example.webByTelusko.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {
    List<Product>products= new ArrayList<>(Arrays.asList(new Product(1,"Phone"),
            new Product(2,"Laptop")));

    public List<Product>allProduct(){
        return products;
    }

    public Product getById(int productId){
        return products.stream()
                .filter(n->n.getProductID()==productId)
                .findFirst()
                .get();
    }

    public void addProduct(Product p1){
        products.add(p1);
    }



}
