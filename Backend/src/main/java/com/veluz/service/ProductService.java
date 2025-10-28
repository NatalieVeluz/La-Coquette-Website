package com.veluz.service;
import com.veluz.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    Optional<Product> getProductById(Integer id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product updateProduct(Product product);
    void deleteProduct(Integer id);
}
