package com.api.mock.service;

import com.api.mock.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductService.class)
class ProductServiceTest {

    private final Product product = new Product("1", "Product", "active", "new");

    @MockBean
    private ProductService productService;

    @Test
    void saveProduct() {
        Mockito.when(productService.saveProduct(product)).thenReturn(product);
        assertEquals(product,productService.saveProduct(product));
    }

    @Test
    void getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        Mockito.when(productService.getProducts()).thenReturn(products);
        assertEquals(products,productService.getProducts());
    }

    @Test
    void getProductById() {
        Mockito.when(productService.getProductById(Mockito.anyString())).thenReturn(java.util.Optional.of(product));
        assertEquals(product,productService.getProductById("1").get());
    }
}
