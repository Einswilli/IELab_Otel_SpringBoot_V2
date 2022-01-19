package com.ielab.ieotel_springboot.exceptions;

public class NotEnoughQuantityException extends RuntimeException{
    public NotEnoughQuantityException (String msg){
        super(msg);
    }
}

