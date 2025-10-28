package com.veluz.serviceimpl;

import com.veluz.entity.Product;
import com.veluz.repository.ProductRepository;
import com.veluz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        // 🛠 Default category
        if (product.getCategoryName() == null || product.getCategoryName().trim().isEmpty()) {
            product.setCategoryName("Uncategorized");
        }

        // 🛠 Default image
        if (product.getImageFile() == null || product.getImageFile().trim().isEmpty()) {
            product.setImageFile("default"); // this will load assets/products/default.jpg
        }

        if (product.getCreatedAt() == null) {
            product.setCreatedAt(Instant.now());
        }
        product.setLastUpdated(Instant.now());

        if (product.getQuantity() == null) {
            product.setQuantity(1.0);
        }

        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();

        // 🛠 Fallback logic for old data (fixes nulls already in DB)
        for (Product p : products) {
            if (p.getCategoryName() == null || p.getCategoryName().trim().isEmpty()) {
                p.setCategoryName("Uncategorized");
            }
            if (p.getImageFile() == null || p.getImageFile().trim().isEmpty()) {
                p.setImageFile("default");
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryNameIgnoreCase(category);
    }

    @Override
    public Product updateProduct(Product product) {
        if (product.getCategoryName() == null || product.getCategoryName().trim().isEmpty()) {
            product.setCategoryName("Uncategorized");
        }

        if (product.getImageFile() == null || product.getImageFile().trim().isEmpty()) {
            product.setImageFile("default");
        }

        product.setLastUpdated(Instant.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
