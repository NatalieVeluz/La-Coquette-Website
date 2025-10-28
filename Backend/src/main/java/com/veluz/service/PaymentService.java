package com.veluz.service;

import com.veluz.entity.Payment;
import com.veluz.enums.PaymentStatus;
import java.util.List;

public interface PaymentService {
    // Create a new payment record
    Payment createPayment(Payment payment);

    // Retrieve payment linked to a specific order
    Payment getPaymentByOrderId(Integer orderId);

    // Retrieve all payments filtered by status
    List<Payment> getPaymentsByStatus(PaymentStatus status);

    // Update payment status (e.g., pending → completed)
    Payment updatePaymentStatus(Integer paymentId, PaymentStatus status);

    // Save payment changes (generic)
    Payment savePayment(Payment payment);
}
