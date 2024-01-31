package com.Springbootecommerce.service;

import com.Springbootecommerce.dto.Purchase;
import com.Springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}