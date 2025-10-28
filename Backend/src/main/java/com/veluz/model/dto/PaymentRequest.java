package com.veluz.model.dto;

import com.veluz.enums.PaymentMethod;

public class PaymentRequest {
    private Integer orderId;
    private Double amount;
    private PaymentMethod method;

    // getters/setters
    public Integer getOrderId(){return orderId;}
    public void setOrderId(Integer o){this.orderId=o;}
    public Double getAmount(){return amount;}
    public void setAmount(Double a){this.amount=a;}
    public PaymentMethod getMethod(){return method;}
    public void setMethod(PaymentMethod m){this.method=m;}
}