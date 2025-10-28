package com.veluz.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_item_data") // maps entity to the correct database table
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private Double price;

    @Column(length = 50)
    private String size;

    @Column(nullable = false)
    private Integer status = 0; // 0 = in cart, 1 = ordered

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant created = Instant.now();

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Instant lastUpdated = Instant.now();

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Instant getCreated() { return created; }
    public void setCreated(Instant created) { this.created = created; }

    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
}
