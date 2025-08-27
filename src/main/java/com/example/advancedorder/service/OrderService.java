package com.example.advancedorder.service;

import com.example.advancedorder.entity.Order;
import com.example.advancedorder.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Order placeOrder(String productId, int quantity);
    Page<Order> getAllOrders(Pageable pageable);
    Product getProductById(String productId);
}

