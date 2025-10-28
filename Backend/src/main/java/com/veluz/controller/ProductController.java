package com.veluz.controller;

import com.veluz.entity.Product;
import com.veluz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Allows frontend to access the backend
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get products by category
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // Add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id); // Make sure the ID is set
        return productService.updateProduct(product);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
} // <-- Make sure this closing brace exists