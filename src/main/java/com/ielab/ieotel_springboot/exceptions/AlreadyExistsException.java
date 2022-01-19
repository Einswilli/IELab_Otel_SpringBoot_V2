package com.ielab.ieotel_springboot.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException (String msg){
        super(msg);
    }
}
