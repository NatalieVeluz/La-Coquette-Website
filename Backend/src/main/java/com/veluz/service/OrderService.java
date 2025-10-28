package com.veluz.service;
import com.veluz.entity.Order;
import com.veluz.enums.OrderStatus;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(Order order);
    Optional<Order> getOrderById(Integer id);
    List<Order> getOrdersByCustomerId(Integer customerId);
    List<Order> getOrdersByStatus(com.veluz.enums.OrderStatus status);
    Order updateOrderStatus(Integer orderId, OrderStatus status);
}
