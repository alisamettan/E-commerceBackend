package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp(){
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test
    @DisplayName("Find all products by ascending price")
    void findAllByPriceAsc() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("asafasfasfasfasf");
        product1.setPrice(10.0);
        product1.setRating(4.5);
        product1.setSellCount(15);
        product1.setStock(100);
        product1.setImage("asfasfasfasfafafasf");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(5.0);
        product2.setDescription("asafasfasfasfasf");
        product2.setRating(4.5);
        product2.setSellCount(15);
        product2.setStock(100);
        product2.setImage("asfasfasfasfafafasf");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setPrice(20.0);
        product3.setDescription("asafasfasfasfasf");
        product3.setRating(4.5);
        product3.setSellCount(15);
        product3.setStock(100);
        product3.setImage("asfasfasfasfafafasf");
        productRepository.save(product3);

        List<Product> products = productRepository.findAllByPriceAsc();

        //assertEquals(3,products.size());
        assertEquals(5.0,products.get(0).getPrice());
        assertEquals(10.0,products.get(1).getPrice());
        assertEquals(20.0,products.get(2).getPrice());
    }


    @Test
    @DisplayName("Find products by category id")
    void findAllByCategoryId() {
        Category category1 = new Category();
        category1.setTitle("Category 1");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setTitle("Category 2");
        categoryRepository.save(category2);

        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(10.0);
        product1.setCategory(category1);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(20.0);
        product2.setCategory(category1);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setPrice(30.0);
        product3.setCategory(category2);
        productRepository.save(product3);

        List<Product> productsCategory1 = productRepository.findAllByCategoryId(category1.getId());
        List<Product> productsCategory2 = productRepository.findAllByCategoryId(category2.getId());


        assertEquals(2, productsCategory1.size());
        assertEquals("Product 1", productsCategory1.get(0).getName());
        assertEquals("Product 2", productsCategory1.get(1).getName());

        assertEquals(1, productsCategory2.size());
        assertEquals("Product 3", productsCategory2.get(0).getName());

    }


}