package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Product;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(LocalDate orderDate, Double price, List<Product> products) {
}