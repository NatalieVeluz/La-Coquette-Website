package com.veluz.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Must map to category_name (actual DB column)
    @Column(name = "category_name")
    private String categoryName;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Must map to image_file (actual DB column)
    @Column(name = "image_file")
    private String imageFile;

    private Double price;

    @Column(length = 50)
    private String size;

    private Double quantity;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private Integer status;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdAt;

    @Column(name = "last_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Instant lastUpdated;

    // Default constructor
    public Product() {}

    // Full constructor
    public Product(Integer id, String name, String description, String categoryName,
                   String size, String imageFile, Double price, Integer stockQuantity,
                   Integer status, Instant createdAt, Instant lastUpdated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
        this.size = size;
        this.imageFile = imageFile;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
        this.quantity = 1.0;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageFile() { return imageFile; }
    public void setImageFile(String imageFile) { this.imageFile = imageFile; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
}
