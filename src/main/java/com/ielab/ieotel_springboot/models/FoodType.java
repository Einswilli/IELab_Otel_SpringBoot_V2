package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodType {
    @Id
    private String id;
    private String lib;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private boolean deleted;

}
