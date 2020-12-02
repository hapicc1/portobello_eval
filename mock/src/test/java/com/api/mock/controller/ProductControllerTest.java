package com.api.mock.controller;

import com.api.mock.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    private final Product product = new Product("1", "Product", "active", "new");
    @MockBean
    ProductController productController;

    @Test
    void saveProduct() {
        Mockito.when(productController.saveProduct(product)).thenReturn(new ResponseEntity<>(product, HttpStatus.OK));
        assertEquals(product, productController.saveProduct(product).getBody());
    }

    @Test
    void getProducts() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productController.getProducts()).thenReturn(new ResponseEntity<>(products, HttpStatus.OK));
        assertEquals(products, productController.getProducts().getBody());
    }

    @Test
    void getProductById() {
        Mockito.when(productController.getProductById(Mockito.anyString())).thenReturn(new ResponseEntity<>(product, HttpStatus.OK));
        assertEquals(product, productController.getProductById("1").getBody());
    }

    @Test
    void deleteProductById() {
        Mockito.when(productController.deleteProductById(Mockito.anyString())).thenReturn(new ResponseEntity<>(true, HttpStatus.OK));
        assertEquals(true, productController.deleteProductById("1").getBody());
    }
}
