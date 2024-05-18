package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CategoryRequest;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.service.CategoryService;
import com.workintech.ecommerce.util.Validation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:5175")
public class CategoryController {
    private CategoryService categoryService;


    @GetMapping
    public List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Validation.checkId(id);
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@Validated @RequestBody CategoryRequest categoryRequest){
        List<Product> products=categoryRequest.getProducts();
        Category category=categoryRequest.getCategory();
        Validation.checkGender(String.valueOf(category.getGender()));


        for(Product product:products){
            category.addProduct(product);
            product.setCategory(category);
        }
        return categoryService.save(category);
    }
}
