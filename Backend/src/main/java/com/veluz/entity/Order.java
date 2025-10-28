package com.veluz.entity;

import com.veluz.enums.OrderStatus;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant orderDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.pending;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "shipping_address", columnDefinition = "TEXT")
    private String shippingAddress;

    // 🛍️ All order items linked to this order
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> items;

    // 💳 Temporary field for returning payment details (not saved to DB)
    @Transient
    private Payment payment;

    // ==========================
    // Constructors
    // ==========================
    public Order() {}

    public Order(Integer customerId, Double totalPrice, String paymentMethod, String shippingAddress) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.status = OrderStatus.pending;
        this.orderDate = Instant.now();
    }

    // ==========================
    // Getters and Setters
    // ==========================

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Instant getOrderDate() { return orderDate; }
    public void setOrderDate(Instant orderDate) { this.orderDate = orderDate; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}
