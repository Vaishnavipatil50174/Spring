package org.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class ProductService {

    List<Product>pr1= Arrays.asList(new Product(1,"phone"),
            new Product(2,"laptop"));

    public List<Product> get(){
        return pr1;
    }
    public void display(){
        System.out.println("running succesfully");
    }
}
