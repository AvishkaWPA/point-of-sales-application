package com.example.point_of_sale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class Exception extends RuntimeException{

    public Exception(String message){
        super(message);
    }
}
