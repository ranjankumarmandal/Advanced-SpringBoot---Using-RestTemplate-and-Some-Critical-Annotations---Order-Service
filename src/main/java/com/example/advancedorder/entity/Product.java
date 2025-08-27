package com.example.advancedorder.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private Double price;
}

