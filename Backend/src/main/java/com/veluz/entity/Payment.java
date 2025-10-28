package com.veluz.entity;

import com.veluz.enums.PaymentMethod;
import com.veluz.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "payment_amount", nullable = false)
    private Double paymentAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", columnDefinition = "ENUM('pending','completed') DEFAULT 'pending'")
    private PaymentStatus paymentStatus = PaymentStatus.pending;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "ENUM('credit_card','paypal','gcash','bank_transfer','cod') DEFAULT 'bank_transfer'")
    private PaymentMethod paymentMethod = PaymentMethod.bank_transfer;

    @Column(name = "payment_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant paymentDate = Instant.now();

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Double getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public Instant getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Instant paymentDate) { this.paymentDate = paymentDate; }
}