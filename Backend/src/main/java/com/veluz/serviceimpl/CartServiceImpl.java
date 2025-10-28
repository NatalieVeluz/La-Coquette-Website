package com.veluz.serviceimpl;

import com.veluz.entity.OrderItem;
import com.veluz.repository.OrderItemRepository;
import com.veluz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getCartItemsByCustomer(Integer customerId) {
        return orderItemRepository.findByCustomerIdAndStatus(customerId, 0);
    }

    @Override
    public OrderItem addToCart(OrderItem item) {
        item.setStatus(0); // 0 = in cart
        item.setOrderId(null); // not yet ordered
        return orderItemRepository.save(item);
    }

    @Override
    public OrderItem updateQuantity(Integer id, Double quantity) {
        OrderItem item = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with ID: " + id));

        item.setQuantity(quantity);

        if (item.getProduct() != null && item.getProduct().getPrice() != null) {
            item.setPrice(item.getProduct().getPrice() * quantity);
        }

        return orderItemRepository.save(item);
    }

    @Override
    public void removeFromCart(Integer id) {
        if (!orderItemRepository.existsById(id)) {
            throw new RuntimeException("Item not found in cart with ID: " + id);
        }
        orderItemRepository.deleteById(id);
    }

    @Override
    public void clearCart(Integer customerId) {
        List<OrderItem> items = orderItemRepository.findByCustomerIdAndStatus(customerId, 0);
        if (!items.isEmpty()) {
            orderItemRepository.deleteAll(items);
        }
    }

    @Override
    public double getCartTotal(Integer customerId) {
        List<OrderItem> items = getCartItemsByCustomer(customerId);
        return items.stream().mapToDouble(OrderItem::getPrice).sum();
    }
}
