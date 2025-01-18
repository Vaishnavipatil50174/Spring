package com.epam.TechSpringBoot1.service;

import com.epam.TechSpringBoot1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    Product product1=new Product(1,"Phone");
    Product product2=new Product(2,"Laptop");
    Product product3=new Product(3,"Mac");
    Product product4=new Product(4,"Telephone");
    List<Product>productList=new ArrayList<>(Arrays.asList(product1,product2,product3,product4));



    public List<Product> showAll(){
        return productList;
    }

    public Product usingId(Integer id){
        return productList.stream().filter(n->n.getPid()==id).findFirst().get();
    }
    public void update(Integer id,Product product){
        Product po=productList.stream().filter(n->n.getPid()==id).findFirst().get();
        po.setPid(product.getPid());
        po.setPname(product.getPname());

    }
    public void deleteById(Integer id){
        Product product=productList.stream().filter(n->n.getPid()==id).findFirst().get();
        productList.remove(product);
    }
    public void addnew(Product product){
        productList.add(product);
    }

}
