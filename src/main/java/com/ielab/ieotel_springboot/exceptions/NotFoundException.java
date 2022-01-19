package com.ielab.ieotel_springboot.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException (String msg){
        super(msg);
    }
}
