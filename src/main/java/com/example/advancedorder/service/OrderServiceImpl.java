package com.example.advancedorder.service;

import com.example.advancedorder.entity.Order;
import com.example.advancedorder.entity.Product;
import com.example.advancedorder.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Qualifier("productServiceRestTemplate")
    private final RestTemplate restTemplate;

    private final String PRODUCT_API_URL = "https://fakestoreapi.com/products/{id}";

    @Override
    public Order placeOrder(String productId, int quantity) {
        // Validate product exists
        Product product = getProductById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        Order order = Order.builder()
                .productId(productId)
                .quantity(quantity)
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(String productId) {
        try {
            return restTemplate.getForObject(PRODUCT_API_URL, Product.class, productId);
        } catch (Exception e) {
            return null;
        }
    }
}
