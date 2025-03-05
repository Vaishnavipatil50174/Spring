package com.techie.product_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.product_service.dto.ProductRequest;
import com.techie.product_service.dto.ProductResponse;
import com.techie.product_service.model.Product;
import com.techie.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public void createProduct(Product productRequest) {
        // Map ProductRequest to Product using ObjectMapper
        //Product product = this.objectMapper.convertValue(productRequest, Product.class);
        productRepository.save(productRequest);
    }

    public List<Product> all() {
        // Map List<Product> to List<ProductResponse>
        return productRepository.findAll();
    }
    public Product searchById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProductPartially(Integer id, Map<String,Object> updates){
        Product product=productRepository.findById(id).orElse(null);

        updates.forEach((k,v)->{
            switch (k){
                case "name" -> product.setName((String) v);
                case "description" -> product.setDescription((String) v);
                case "price" -> product.setPrice(BigDecimal.valueOf(Long.parseLong(v.toString())));
                default -> throw new IllegalArgumentException("Invalid field" + k);
            }
        });
        return productRepository.save(product);
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
