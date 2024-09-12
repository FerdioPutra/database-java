package com.javatpoint.UASpraktikum;

import com.javatpoint.UASpraktikum.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServices {

    @Autowired
    private productRepository productRepository;

    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public product createProduct(product product) {
        return productRepository.save(product);
    }

    public product updateProduct(Long id, product productDetails) {
        product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Map productDetails to product entity manually
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}