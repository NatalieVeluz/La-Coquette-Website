package com.veluz.controller;

import com.veluz.entity.Payment;
import com.veluz.enums.PaymentStatus;
import com.veluz.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a new payment record (manual creation, mainly for testing)
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    // Get payment by Order ID
    @GetMapping("/order/{orderId}")
    public Payment getPaymentByOrderId(@PathVariable Integer orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }

    // Get all payments by status (pending, completed, etc.)
    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable PaymentStatus status) {
        return paymentService.getPaymentsByStatus(status);
    }

    // Update payment status
    @PutMapping("/{paymentId}/status")
    public Payment updatePaymentStatus(
            @PathVariable Integer paymentId,
            @RequestParam PaymentStatus status) {
        return paymentService.updatePaymentStatus(paymentId, status);
    }

    // Get all pending payments (simple check endpoint)
    @GetMapping
    public List<Payment> getAllPendingPayments() {
        return paymentService.getPaymentsByStatus(PaymentStatus.pending);
    }
}
