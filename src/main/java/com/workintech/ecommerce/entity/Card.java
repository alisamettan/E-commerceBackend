package com.workintech.ecommerce.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "card",schema = "ecommerce")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_no")
    @Size(min = 16,max = 16,message = "card number should be 16 digit!")
    private String cardNo;

    @Column(name = "expire_month")
    @Min(value = 1,message = "expiration month should be 1 at least")
    @Max(value = 12,message = "expiration month should be 12 at most")
    private int expireMonth;

    @Column(name = "expire_year")
    @Min(2024)
    private int expireYear;

    @Column(name = "name_on_card")
    @Size(min = 3)
    private String nameOnCard;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}