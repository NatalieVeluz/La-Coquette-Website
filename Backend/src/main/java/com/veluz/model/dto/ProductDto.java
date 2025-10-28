package com.veluz.model.dto;

public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imageFile;
    private Integer stockQuantity;
    private String size; // added size field

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImageFile() { return imageFile; }
    public void setImageFile(String imageFile) { this.imageFile = imageFile; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}