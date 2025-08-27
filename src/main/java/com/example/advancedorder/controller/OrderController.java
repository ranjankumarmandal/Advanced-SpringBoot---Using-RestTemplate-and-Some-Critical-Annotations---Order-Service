package com.example.advancedorder.controller;

import com.example.advancedorder.entity.Order;
import com.example.advancedorder.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Order API", description = "APIs for managing orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(
            @RequestParam String productId,
            @RequestParam(defaultValue = "1") int quantity) {
        return orderService.placeOrder(productId, quantity);
    }

    @GetMapping
    public Page<Order> getOrders(Pageable pageable) {
        return orderService.getAllOrders(pageable);
    }
}

