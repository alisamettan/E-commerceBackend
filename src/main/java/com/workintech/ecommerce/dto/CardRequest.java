package com.workintech.ecommerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {
    private String cardNo;
    private int expireMonth;
    private int expireYear;
    private String nameOnCard;
}