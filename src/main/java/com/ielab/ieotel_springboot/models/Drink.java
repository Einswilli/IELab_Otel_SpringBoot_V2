package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Drink {
    @Id
    private String id;
    private String name;
    private String lib;
    private Long quantity;
    private Float price;
    private DrinkType drinkType;
    private Date deleteAt;
    private Date createAt;
    private Date updateAt;

}
