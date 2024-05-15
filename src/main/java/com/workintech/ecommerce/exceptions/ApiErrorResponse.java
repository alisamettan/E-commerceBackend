package com.workintech.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;


@AllArgsConstructor
@Setter
@Getter
public class ApiErrorResponse {
    private String message;
    private HttpStatus httpStatus;
    private Instant timeStamp;
}
