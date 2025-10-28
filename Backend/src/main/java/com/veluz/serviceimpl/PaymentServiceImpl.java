package com.veluz.serviceimpl;

import com.veluz.entity.Payment;
import com.veluz.enums.PaymentStatus;
import com.veluz.repository.PaymentRepository;
import com.veluz.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrderId(Integer orderId) {
        List<Payment> payments = paymentRepository.findByOrderId(orderId);
        return payments.isEmpty() ? null : payments.get(0);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @Override
    public Payment updatePaymentStatus(Integer paymentId, PaymentStatus status) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setPaymentStatus(status);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
