package com.springpractise.managementinformationsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends Exception {


    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable err){
        super(message,err);
    }

    public BadRequestException(String message, int Id){

    }

}
