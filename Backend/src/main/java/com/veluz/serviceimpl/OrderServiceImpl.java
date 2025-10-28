package com.veluz.serviceimpl;

import com.veluz.entity.Order;
import com.veluz.entity.OrderItem;
import com.veluz.entity.Payment;
import com.veluz.enums.OrderStatus;
import com.veluz.enums.PaymentMethod;
import com.veluz.enums.PaymentStatus;
import com.veluz.repository.OrderRepository;
import com.veluz.repository.OrderItemRepository;
import com.veluz.repository.PaymentRepository;
import com.veluz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Order placeOrder(Order order) {
        // Save main order
        order.setOrderDate(Instant.now());
        order.setStatus(OrderStatus.pending);
        Order savedOrder = orderRepository.save(order);

        // Save items linked to order
        if (order.getItems() != null && !order.getItems().isEmpty()) {
            for (OrderItem item : order.getItems()) {
                item.setOrderId(savedOrder.getId());
                item.setStatus(1); // ordered
                orderItemRepository.save(item);
            }
        }

        // Create Payment record
        Payment payment = new Payment();
        payment.setOrderId(savedOrder.getId());
        payment.setPaymentAmount(savedOrder.getTotalPrice());
        payment.setPaymentDate(Instant.now());
        payment.setPaymentStatus(PaymentStatus.pending);

        String method = (savedOrder.getPaymentMethod() != null)
                ? savedOrder.getPaymentMethod().trim().toLowerCase()
                : "cod";

        switch (method) {
            case "gcash":
            case "qr":
                payment.setPaymentMethod(PaymentMethod.gcash);
                break;
            case "paypal":
                payment.setPaymentMethod(PaymentMethod.paypal);
                break;
            case "credit_card":
                payment.setPaymentMethod(PaymentMethod.credit_card);
                break;
            case "bank_transfer":
                payment.setPaymentMethod(PaymentMethod.bank_transfer);
                break;
            default:
                payment.setPaymentMethod(PaymentMethod.cod);
                break;
        }

        paymentRepository.save(payment);
        savedOrder.setPayment(payment);

        return savedOrder;
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        orderOpt.ifPresent(order -> {
            List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
            order.setItems(items);
        });
        return orderOpt;
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        for (Order order : orders) {
            List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
            order.setItems(items);
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.findByStatus(status);
        for (Order order : orders) {
            List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
            order.setItems(items);
        }
        return orders;
    }

    @Override
    @Transactional
    public Order updateOrderStatus(Integer orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("❌ Order not found with ID: " + orderId));

        order.setStatus(status);
        order.setOrderDate(Instant.now());

        // Update related payments safely
        List<Payment> payments = paymentRepository.findByOrderId(orderId);
        for (Payment payment : payments) {
            if (status == OrderStatus.completed) {
                payment.setPaymentStatus(PaymentStatus.completed);
            } else if (status == OrderStatus.cancelled) {
                payment.setPaymentStatus(PaymentStatus.cancelled);
            } else {
                payment.setPaymentStatus(PaymentStatus.pending);
            }
            paymentRepository.save(payment);
        }

        // Update items
        List<OrderItem> items = orderItemRepository.findByOrderId(orderId);
        for (OrderItem item : items) {
            if (status == OrderStatus.cancelled) {
                item.setStatus(2); // cancelled
            } else if (status == OrderStatus.completed) {
                item.setStatus(3); // completed
            } else {
                item.setStatus(1); // pending
            }
            orderItemRepository.save(item);
        }

        return orderRepository.save(order);
    }
}
