package com.ec.demo.exception;

import org.springframework.core.Ordered;

public class OrderException extends Exception {
    public OrderException(String message){
        super(message);
    }
}
