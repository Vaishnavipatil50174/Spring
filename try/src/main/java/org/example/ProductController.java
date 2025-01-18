package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductController {
    @Autowired
    public ProductService productService;
// because we used field injection
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    public List<Product>getAll(){
        productService.display();
        return productService.get();
    }
}
