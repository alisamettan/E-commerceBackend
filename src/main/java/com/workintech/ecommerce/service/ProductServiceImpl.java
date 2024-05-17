package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.repository.CategoryRepository;
import com.workintech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductId(long productId) {
        Optional<Product> productOptional=productRepository.findById(productId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new ApiException("Product by given id cannot be found id: "+productId, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByPriceAsc() {
        return productRepository.findAllByPriceAsc();
    }

    @Override
    public List<Product> findAllByPriceDesc() {
        return productRepository.findAllByPriceDesc();
    }

    @Override
    public List<Product> findAllByRatingAsc() {
        return productRepository.findAllByRatingAsc();
    }

    @Override
    public List<Product> findAllByRatingDesc() {
        return productRepository.findAllByRatingDesc();
    }

    @Override
    public List<Product> findAllByCategoryId(long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            return productRepository.findAllByCategoryId(categoryId);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryPriceAsc(long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            return productRepository.findAllByCategoryPriceAsc(categoryId);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryPriceDesc(long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            return productRepository.findAllByCategoryPriceDesc(categoryId);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryRatingAsc(long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            return productRepository.findAllByCategoryRatingAsc(categoryId);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryRatingDesc(long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            return productRepository.findAllByCategoryRatingDesc(categoryId);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public List<Product> findAllByNamePriceAsc(String name) {
        return productRepository.findAllByNamePriceAsc(name);
    }

    @Override
    public List<Product> findAllByNamePriceDesc(String name) {
        return productRepository.findAllByNamePriceDesc(name);
    }

    @Override
    public List<Product> findAllByNameRatingAsc(String name) {
        return productRepository.findAllByNameRatingAsc(name);
    }

    @Override
    public List<Product> findAllByNameRatingDesc(String name) {
        return productRepository.findAllByNameRatingDesc(name);
    }

    @Override
    public List<Product> findAllByCategoryAndName(long categoryId, String name) {
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            return productRepository.findAllByCategoryAndName(categoryId,name);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryAndNamePriceAsc(long categoryId, String name) {
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            return productRepository.findAllByCategoryAndNamePriceAsc(categoryId,name);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryAndNamePriceDesc(long categoryId, String name) {
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            return productRepository.findAllByCategoryAndNamePriceDesc(categoryId,name);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryAndNameRatingAsc(long categoryId, String name) {
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            return productRepository.findAllByCategoryAndNameRatingAsc(categoryId,name);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> findAllByCategoryAndNameRatingDesc(long categoryId, String name) {
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            return productRepository.findAllByCategoryAndNameRatingDesc(categoryId,name);
        }
        throw new ApiException("Products by given category id cannot be found id: "+categoryId,HttpStatus.NOT_FOUND);
    }
}
