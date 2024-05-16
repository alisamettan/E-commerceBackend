package com.workintech.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category",schema = "ecommerce")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    @Pattern(regexp = "^\\w+:\\w+$", message = "Code must follow the format 'prefix:suffix'")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> productList;

    public void addProduct(Product product){
        if(productList==null){
            productList=new ArrayList<>();

        }
        productList.add(product);
    }
}