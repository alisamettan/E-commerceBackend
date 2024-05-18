package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private Long addressId;
    private int expireYear;
    private int expireMonth;
    private String nameOnCard;
    private String cardNo;
    private Double price;
    private List<Product> products;
}