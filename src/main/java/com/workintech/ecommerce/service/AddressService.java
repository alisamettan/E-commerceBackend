package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllAddresses();
    Address findById(long id);
    Address save(Address address);
    Address delete(long id);
}