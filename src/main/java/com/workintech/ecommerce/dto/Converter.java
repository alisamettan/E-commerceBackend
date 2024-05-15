package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Address;

public class Converter {
    public static Address mapToAddress(AddressRequest addressRequest, Address address){
        address.setTitle(addressRequest.getTitle());
        address.setName(addressRequest.getName());
        address.setSurname(addressRequest.getSurname());
        address.setAddress(addressRequest.getAddress());
        address.setNeighborhood(addressRequest.getNeighborhood());
        address.setCity(addressRequest.getCity());
        address.setDistrict(addressRequest.getDistrict());
        address.setPhone(addressRequest.getPhone());
        return address;
    }
}
