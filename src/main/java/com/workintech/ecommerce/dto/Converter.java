package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.entity.Card;

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

    public static Card mapToCard(CardRequest cardRequest,Card card){
        card.setNameOnCard(cardRequest.getNameOnCard());
        card.setCardNo(cardRequest.getCardNo());
        card.setExpireYear(cardRequest.getExpireYear());
        card.setExpireMonth(cardRequest.getExpireMonth());
        return card;
    }
}
