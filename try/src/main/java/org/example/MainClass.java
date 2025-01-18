package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MainClass.class);
        ProductController productController=context.getBean(ProductController.class);
        productController.getAll().forEach(pro-> System.out.println(pro.getProductId()+ ":"+pro.getProductName()));

//        ProductService productService=new ProductService();
//        ProductController productController=new ProductController(productService);
//        productController.getAll().forEach(pro-> System.out.println(pro.getProductId()+ ":"+pro.getProductName()));
    }


}
