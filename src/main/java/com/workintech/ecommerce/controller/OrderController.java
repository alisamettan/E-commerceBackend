package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public OrderResponse save(@Validated @RequestBody OrderRequest orderRequest){
        return orderService.save(orderRequest);
    }

    @GetMapping
    public List<OrderResponse> getAll(){
        return orderService.findAllOrders();
    }
}