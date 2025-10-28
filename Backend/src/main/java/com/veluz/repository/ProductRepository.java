package com.veluz.repository;

import com.veluz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Allows category-based filtering
    List<Product> findByCategoryNameIgnoreCase(String categoryName);
}
