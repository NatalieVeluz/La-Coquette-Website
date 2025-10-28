package com.veluz.model.dto;

public class AddToCartRequest {
    private Integer customerId;
    private Integer productId;
    private int quantity;

    public AddToCartRequest() {}

    public AddToCartRequest(Integer customerId, Integer productId, int quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}