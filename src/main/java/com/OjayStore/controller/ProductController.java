package com.OjayStore.controller;


import com.OjayStore.entity.Product;
import com.OjayStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create a new product
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Retrieve product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // Retrieve product by name
    @GetMapping("/name")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    // Update product by id
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProductById(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    // Update product by name
    @PutMapping("/name")
    public ResponseEntity<Product> updateProductByName(@RequestParam String name, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProductByName(name, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete product by name
    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteProductByName(@RequestParam String name) {
        productService.deleteProductByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
