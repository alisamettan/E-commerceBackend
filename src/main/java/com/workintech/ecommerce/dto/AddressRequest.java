package com.workintech.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    private String title;
    private String name;
    private String surname;
    private String address;
    private String neighborhood;
    private String city;
    private String district;
    private String phone;

}