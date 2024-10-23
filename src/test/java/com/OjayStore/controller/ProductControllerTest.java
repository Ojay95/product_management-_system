package com.OjayStore.controller;

import com.OjayStore.entity.Product;
import com.OjayStore.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Sample Product");
        product.setPrice(99.99);
        product.setDescription("Sample Description");
    }

    @Test
    void testCreateProduct() {
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.createProduct(product);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Sample Product", response.getBody().getName());
    }

    @Test
    void testGetProductById() {
        when(productService.getProductById(1L)).thenReturn(product);

        ResponseEntity<Product> response = productController.getProductById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetProductByName() {
        when(productService.getProductByName("Sample Product")).thenReturn(product);

        ResponseEntity<Product> response = productController.getProductByName("Sample Product");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Sample Product", response.getBody().getName());
    }

    @Test
    void testUpdateProductById() {
        Product updatedProduct = new Product();
        updatedProduct.setId(1L);
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(120.00);
        updatedProduct.setDescription("Updated Description");

        when(productService.updateProductById(eq(1L), any(Product.class))).thenReturn(updatedProduct);

        ResponseEntity<Product> response = productController.updateProductById(1L, updatedProduct);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void testUpdateProductByName() {
        Product updatedProduct = new Product();
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(120.00);
        updatedProduct.setDescription("Updated Description");

        when(productService.updateProductByName(eq("Sample Product"), any(Product.class))).thenReturn(updatedProduct);

        ResponseEntity<Product> response = productController.updateProductByName("Sample Product", updatedProduct);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void testDeleteProductById() {
        doNothing().when(productService).deleteProductById(1L);

        ResponseEntity<Void> response = productController.deleteProductById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteProductByName() {
        doNothing().when(productService).deleteProductByName("Sample Product");

        ResponseEntity<Void> response = productController.deleteProductByName("Sample Product");

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
