package com.veluz.service;

import com.veluz.entity.OrderItem;
import java.util.List;

public interface CartService {

    List<OrderItem> getCartItemsByCustomer(Integer customerId);
    OrderItem addToCart(OrderItem item);
    OrderItem updateQuantity(Integer id, Double quantity);
    void removeFromCart(Integer id);
    void clearCart(Integer customerId);
    double getCartTotal(Integer customerId);
}
