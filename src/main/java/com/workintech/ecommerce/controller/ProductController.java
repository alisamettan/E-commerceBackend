package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.ProductService;
import com.workintech.ecommerce.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:5175")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productService.save(products);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        Validation.checkId(id);
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) Long categoryId,
                                     @RequestParam(required = false) String filter,
                                     @RequestParam(required = false) String sort) {
        if (categoryId != null) {
            return getProductsByCategoryAndSort(categoryId, filter, sort);
        } else if (filter != null) {
            return getProductsByFilter(filter, sort);
        } else {
            return getProductsBySort(sort);
        }
    }

    private List<Product> getProductsByFilter(String filter, String sort) {
        if (sort != null) {
            switch (sort) {
                case "price:asc":
                    return productService.findAllByNamePriceAsc(filter);
                case "price:desc":
                    return productService.findAllByNamePriceDesc(filter);
                case "rating:asc":
                    return productService.findAllByNameRatingAsc(filter);
                case "rating:desc":
                    return productService.findAllByNameRatingDesc(filter);
                default:
                    return productService.findAllByName(filter);
            }
        } else {
            return productService.findAllByName(filter);
        }
    }

    private List<Product> getProductsBySort(String sort) {
        if (sort != null) {
            switch (sort) {
                case "price:asc":
                    return productService.findAllByPriceAsc();
                case "price:desc":
                    return productService.findAllByPriceDesc();
                case "rating:asc":
                    return productService.findAllByRatingAsc();
                case "rating:desc":
                    return productService.findAllByRatingDesc();
                default:
                    return productService.findAllProducts();
            }
        } else {
            return productService.findAllProducts();
        }
    }

    private List<Product> getProductsByCategoryAndSort(Long categoryId, String filter, String sort) {
        if (filter != null) {
            switch (sort) {
                case "price:asc":
                    return productService.findAllByCategoryAndNamePriceAsc(categoryId, filter);
                case "price:desc":
                    return productService.findAllByCategoryAndNamePriceDesc(categoryId, filter);
                case "rating:asc":
                    return productService.findAllByCategoryAndNameRatingAsc(categoryId, filter);
                case "rating:desc":
                    return productService.findAllByCategoryAndNameRatingDesc(categoryId, filter);
                default:
                    return productService.findAllByCategoryAndName(categoryId, filter);
            }
        } else {
            switch (sort) {
                case "price:asc":
                    return productService.findAllByCategoryPriceAsc(categoryId);
                case "price:desc":
                    return productService.findAllByCategoryPriceDesc(categoryId);
                case "rating:asc":
                    return productService.findAllByCategoryRatingAsc(categoryId);
                case "rating:desc":
                    return productService.findAllByCategoryRatingDesc(categoryId);
                default:
                    return productService.findAllByCategoryId(categoryId);
            }
        }
    }
}



