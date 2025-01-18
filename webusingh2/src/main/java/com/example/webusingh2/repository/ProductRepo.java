package com.example.webusingh2.repository;

import com.example.webusingh2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
