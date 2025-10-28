package com.veluz.repository;

import com.veluz.entity.OrderItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    /**
     * Fetch all items in the customer's cart (status = 0).
     * Uses @EntityGraph to eagerly load product and customer data,
     * so your API responses include full details instead of null values.
     */
    @EntityGraph(attributePaths = {"product", "customer"})
    List<OrderItem> findByCustomerIdAndStatus(Integer customerId, Integer status);

    /**
     * Fetch all items for a specific order (used during checkout or order review)
     */
    @EntityGraph(attributePaths = {"product", "customer"})
    List<OrderItem> findByOrderId(Integer orderId);

    /**
     * Fetch all items for a specific customer (any status)
     */
    @EntityGraph(attributePaths = {"product", "customer"})
    List<OrderItem> findByCustomerId(Integer customerId);
}
