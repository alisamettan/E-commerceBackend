package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
    private Category category;
    private List<Product> products;
}
