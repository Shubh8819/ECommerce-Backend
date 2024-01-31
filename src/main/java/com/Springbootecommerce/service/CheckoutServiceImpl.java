package com.Springbootecommerce.service;


import com.Springbootecommerce.Entity.Customer;
import com.Springbootecommerce.Entity.Order;
import com.Springbootecommerce.Entity.OrderItem;

import com.Springbootecommerce.Repos.CustomerRepository;
import com.Springbootecommerce.dto.Purchase;
import com.Springbootecommerce.dto.PurchaseResponse;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());



        // populate customer with order
        Customer customer = purchase.getCustomer();
        //check the Exixting customer
        String theEmail=customer.getEmail();
        Customer customerFromDb=customerRepository.findByEmail(theEmail);
        if(customerFromDb!=null){
            customer=customerFromDb;
        }
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}