package com.techie.product_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.product_service.dto.ProductRequest;
import com.techie.product_service.dto.ProductResponse;
import com.techie.product_service.model.Product;
import com.techie.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
//    @Autowired
//    ProductRepository productRepository;
//   @Autowired
//   ObjectMapper objectMapper;
//
//    public void createProduct(ProductRequest productRequest){
////        Product product=Product.builder()
////                        .name(productRequest.getName())
////                                .description(productRequest.getDescription())
////                                        .price(productRequest.getPrice())
////                                                .build();
//        Product product=this.objectMapper.convertValue(productRequest,Product.class);
//        productRepository.save(product);
//        //log.info("product {} is saved",product.getId());
//    }
//
//    public List<Product> all(){
//        return productRepository.findAll();
//
//    }

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ObjectMapper objectMapper;

    public void createProduct(ProductRequest productRequest) {
        // Map ProductRequest to Product using ObjectMapper
        Product product = this.objectMapper.convertValue(productRequest, Product.class);
        productRepository.save(product);
    }

    public List<ProductResponse> all() {
        // Map List<Product> to List<ProductResponse>
        return productRepository.findAll().stream()
                .map(product -> objectMapper.convertValue(product, ProductResponse.class))
                .toList();
    }

//    private ProductResponse mapToProductResponse(Product product) {
//        return  ProductResponse.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
//    }
}
