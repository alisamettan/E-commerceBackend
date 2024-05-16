package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findById(long id);
    Category save(Category category);
}
