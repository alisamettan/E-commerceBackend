package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> save(List<Product> products);
    List<Product> findAllProducts();
    Product findProductById(long productId);
    List<Product> findAllByPriceAsc();
    List<Product> findAllByPriceDesc();
    List<Product> findAllByRatingAsc();
    List<Product> findAllByRatingDesc();
    List<Product> findAllByCategoryId(long categoryId);
    List<Product> findAllByCategoryPriceAsc(long categoryId);
    List<Product> findAllByCategoryPriceDesc(long categoryId);
    List<Product> findAllByCategoryRatingAsc(long categoryId);
    List<Product> findAllByCategoryRatingDesc(long categoryId);
    List<Product> findAllByName(String name);
    List<Product> findAllByNamePriceAsc(String name);
    List<Product> findAllByNamePriceDesc(String name);
    List<Product> findAllByNameRatingAsc(String name);
    List<Product> findAllByNameRatingDesc(String name);
    List<Product> findAllByCategoryAndName(long categoryId,String name);
    List<Product> findAllByCategoryAndNamePriceAsc(long categoryId,String name);
    List<Product> findAllByCategoryAndNamePriceDesc(long categoryId,String name);
    List<Product> findAllByCategoryAndNameRatingAsc(long categoryId,String name);
    List<Product> findAllByCategoryAndNameRatingDesc(long categoryId,String name);

}
