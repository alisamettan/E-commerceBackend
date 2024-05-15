package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.AddressRequest;
import com.workintech.ecommerce.dto.Converter;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.service.AddressService;
import com.workintech.ecommerce.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public List<Address> findAllAddresses(){
        return addressService.findAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable long id){
        Validation.checkId(id);
        return addressService.findById(id);
    }


    @PostMapping
    public Address save(@Validated @RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id,@Validated @RequestBody AddressRequest addressRequest){
        Validation.checkId(id);
        Address existingAddress = addressService.findById(id);
        existingAddress= Converter.mapToAddress(addressRequest,existingAddress);
        Address updatedAddress=addressService.save(existingAddress);
        return updatedAddress;
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable Long id){
        Validation.checkId(id);
        return addressService.delete(id);
    }
}









