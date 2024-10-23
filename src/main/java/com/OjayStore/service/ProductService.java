package com.OjayStore.service;

import com.OjayStore.entity.Product;
import com.OjayStore.exception.ResourceNotFoundException;
import com.OjayStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct (Product product){
            return productRepository.save(product);
    }


    public Product getProductById(Long Id){
        return (productRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id)));
    }

    public Product getProductByName(String name){
        return (productRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with name: " + name)));
    }

    public Product updateProductById(Long id, Product productDetails) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setDescription(productDetails.getDescription());
        return productRepository.save(existingProduct);
    }

    public Product updateProductByName(String oldName, Product productDetails){
        Product existingProduct = getProductByName(oldName);
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setDescription(productDetails.getDescription());
        return productRepository.save(existingProduct);

    }

    public void deleteProductById(Long Id){
        Product product = getProductById(Id);
        productRepository.delete(product);
    }

    public void deleteProductByName (String name){
        Product product = getProductByName(name);
        productRepository.delete(product);
    }
}
