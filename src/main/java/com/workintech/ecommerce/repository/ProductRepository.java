package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    //Fiyata göre artan sıra
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllByPriceAsc();

    //Fiyata göre azalan
    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> findAllByPriceDesc();

    @Query("SELECT p FROM Product p ORDER BY p.rating ASC")
    List<Product> findAllByRatingAsc();

    @Query("SELECT p FROM Product p ORDER BY p.rating DESC")
    List<Product> findAllByRatingDesc();

    //BY CATEGORY ASC-DESC
    @Query("SELECT p FROM Product p WHERE p.category.id=:categoryId")
    List<Product> findAllByCategoryId(long categoryId);
    @Query("SELECT p FROM Product p WHERE p.category.id=:categoryId ORDER BY p.price ASC")
    List<Product> findAllByCategoryPriceAsc(long categoryId);
    //Fiyata göre azalan
    @Query("SELECT p FROM Product p WHERE p.category.id=:categoryId ORDER BY p.price DESC")
    List<Product> findAllByCategoryPriceDesc(long categoryId);

    @Query("SELECT p FROM Product p WHERE p.category.id=:categoryId ORDER BY p.rating ASC")
    List<Product> findAllByCategoryRatingAsc(long categoryId);

    @Query("SELECT p FROM Product p WHERE p.category.id=:categoryId ORDER BY p.rating DESC")
    List<Product> findAllByCategoryRatingDesc(long categoryId);

    //----By name asc desc
    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name%")
   List<Product> findAllByName(String name);
    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% ORDER BY p.price ASC")
    List<Product> findAllByNamePriceAsc(String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% ORDER BY p.price DESC")
    List<Product> findAllByNamePriceDesc(String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% ORDER BY p.rating ASC")
    List<Product> findAllByNameRatingAsc(String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% ORDER BY p.rating DESC")
    List<Product> findAllByNameRatingDesc(String name);

    //---By name and category

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% AND p.category.id=:categoryId")
    List<Product> findAllByCategoryAndName(long categoryId,String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% AND p.category.id=:categoryId ORDER BY p.price ASC")
    List<Product> findAllByCategoryAndNamePriceAsc(long categoryId,String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% AND p.category.id=:categoryId ORDER BY p.price DESC")
    List<Product> findAllByCategoryAndNamePriceDesc(long categoryId,String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% AND p.category.id=:categoryId ORDER BY p.rating ASC")
    List<Product> findAllByCategoryAndNameRatingAsc(long categoryId,String name);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:name% AND p.category.id=:categoryId ORDER BY p.rating DESC")
    List<Product> findAllByCategoryAndNameRatingDesc(long categoryId,String name);



}
