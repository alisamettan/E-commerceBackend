package com.workintech.ecommerce.util;

import com.workintech.ecommerce.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class Validation {
    public static void checkId(Long id){
        if(id<0 || id==null){
            throw new ApiException("id cannot be less than 0 or null: "+id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkGender(String gender){
        if(!(gender.equalsIgnoreCase("k") || gender.equalsIgnoreCase("e"))){
            throw new ApiException("gender should be k or e: "+gender,HttpStatus.BAD_REQUEST);
        }
    }
}
