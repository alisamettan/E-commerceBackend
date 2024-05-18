package com.workintech.ecommerce.service;


import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponse save(OrderRequest orderRequest);
    List<OrderResponse> findAllOrders();
}