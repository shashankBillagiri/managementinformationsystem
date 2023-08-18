package com.springpractise.managementinformationsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonExceptionHandler extends Exception {
    private String message = "Hello";

}
