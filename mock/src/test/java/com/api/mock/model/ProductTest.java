package com.api.mock.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private final Product product = new Product("1","Product","active","new");

    @Test
    void getId() {
        assertEquals("1",product.getId());
    }

    @Test
    void setId() {
        product.setId("2");
        assertEquals("2",product.getId());
    }

    @Test
    void getName() {
        assertEquals("Product",product.getName());
    }

    @Test
    void setName() {
        product.setName("Other Product");
        assertEquals("Other Product",product.getName());
    }

    @Test
    void getStatus() {
        assertEquals("active",product.getStatus());
    }

    @Test
    void setStatus() {
        product.setStatus("inactive");
        assertEquals("inactive",product.getStatus());
    }

    @Test
    void getCondition() {
        assertEquals("new",product.getCondition());
    }

    @Test
    void setCondition() {
        product.setCondition("used");
        assertEquals("used",product.getCondition());
    }
}
