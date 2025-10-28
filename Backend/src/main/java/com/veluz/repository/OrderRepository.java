package com.veluz.repository;
import com.veluz.entity.Order;
import com.veluz.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(Integer customerId);
    List<Order> findByStatus(OrderStatus status);
}
