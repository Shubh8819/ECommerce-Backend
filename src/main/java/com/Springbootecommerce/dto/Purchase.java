package com.Springbootecommerce.dto;

import com.Springbootecommerce.Entity.Address;
import com.Springbootecommerce.Entity.Customer;
import com.Springbootecommerce.Entity.Order;
import com.Springbootecommerce.Entity.OrderItem;

import lombok.Data;

import java.util.Set;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}