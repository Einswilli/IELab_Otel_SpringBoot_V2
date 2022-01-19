package com.ielab.ieotel_springboot.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Drink {
    @Id
    private Long id;
    private String name;
    private String lib;
    private Long quantity;
    private Float price;
    private DrinkType drinkType;
}
