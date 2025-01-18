package com.epam.TechSpringBoot1;

import com.epam.TechSpringBoot1.controller.ProductController;
import com.epam.TechSpringBoot1.model.Product;
import com.epam.TechSpringBoot1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
public class ProductControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void byIdTest() throws Exception {
        Product product=new Product(1,"phone");
        when(productService.usingId(1)).thenReturn(product);

        mockMvc.perform(get("/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pname").value("phone"));
    }
}
