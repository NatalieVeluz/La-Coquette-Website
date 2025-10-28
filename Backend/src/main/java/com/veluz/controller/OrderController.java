package com.veluz.controller;

import com.veluz.entity.Order;
import com.veluz.entity.Payment;
import com.veluz.enums.OrderStatus;
import com.veluz.enums.PaymentStatus;
import com.veluz.service.OrderService;
import com.veluz.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    // Checkout
    @PostMapping("/checkout")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {
        try {
            Order savedOrder = orderService.placeOrder(order);
            Payment payment = paymentService.getPaymentByOrderId(savedOrder.getId());
            savedOrder.setPayment(payment);
            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("❌ Failed to place order: " + e.getMessage());
        }
    }

    // Get orders by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Integer customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        for (Order order : orders) {
            Payment payment = paymentService.getPaymentByOrderId(order.getId());
            order.setPayment(payment);
        }
        return ResponseEntity.ok(orders);
    }

    // Update order status manually (generic)
    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Integer orderId, @RequestParam String status) {
        try {
            OrderStatus orderStatus = OrderStatus.valueOf(status.toLowerCase());
            Order updatedOrder = orderService.updateOrderStatus(orderId, orderStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("❌ Invalid order status: " + status);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("❌ Failed to update status: " + e.getMessage());
        }
    }

    // Cancel order directly
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Integer orderId) {
        try {
            Order cancelledOrder = orderService.updateOrderStatus(orderId, OrderStatus.cancelled);
            return ResponseEntity.ok(cancelledOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("❌ Failed to cancel order: " + e.getMessage());
        }
    }
}
