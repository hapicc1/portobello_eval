package com.api.mock.service;

import com.api.mock.model.Product;
import com.api.mock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        }catch (Exception e){
            return null;
        }
    }

    public Optional<Product> getProductById(String id) {
        try {
            return productRepository.findById(id);
        }catch (Exception e){
            return null;
        }
    }

    public List<Product> getProducts() {
        try {
            return productRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    public boolean deleteProduct(String id) {
        try {
             productRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
