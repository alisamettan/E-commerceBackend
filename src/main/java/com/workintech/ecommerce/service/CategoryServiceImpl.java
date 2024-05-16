package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(()->{
            throw new ApiException("Category with given id cannot be found: "+id, HttpStatus.NOT_FOUND);
        });
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
