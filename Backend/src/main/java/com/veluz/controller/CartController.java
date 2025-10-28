package com.veluz.controller;

import com.veluz.entity.OrderItem;
import com.veluz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get all items for a specific customer (status = 0 = still in cart)
    @GetMapping("/{customerId}")
    public List<OrderItem> getCartItems(@PathVariable Integer customerId) {
        return cartService.getCartItemsByCustomer(customerId);
    }

    // Add an item to the cart
    @PostMapping
    public OrderItem addToCart(@RequestBody OrderItem item) {
        return cartService.addToCart(item);
    }

    // Update quantity of an existing cart item
    @PutMapping("/{id}")
    public OrderItem updateQuantity(
            @PathVariable Integer id,
            @RequestParam Double quantity
    ) {
        return cartService.updateQuantity(id, quantity);
    }

    // Remove a single item from the cart
    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Integer id) {
        cartService.removeFromCart(id);
    }

    // Clear all items for a specific customer
    @DeleteMapping("/clear/{customerId}")
    public void clearCart(@PathVariable Integer customerId) {
        cartService.clearCart(customerId);
    }
}
