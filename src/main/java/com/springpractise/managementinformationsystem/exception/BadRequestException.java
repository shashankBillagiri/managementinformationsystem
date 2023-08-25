package com.springpractise.managementinformationsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends Exception {


    public BadRequestException(String message){
        super(message);
    }
    
}
