package com.veluz.repository;

import com.veluz.entity.Payment;
import com.veluz.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByOrderId(Integer orderId);
    List<Payment> findByPaymentStatus(PaymentStatus status);
}
