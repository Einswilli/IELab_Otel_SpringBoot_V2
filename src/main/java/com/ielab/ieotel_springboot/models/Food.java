package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Food {

    @Id
    private String id;
    private String lib;
    private String name;
    private Float price;
    //private FoodType foodType;
    private Date createdAt;
    private Date updatedAt;
}
