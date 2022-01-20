package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Command {
    @Id
    private String id;
    private Date date;
    private Float cust;
    private String destination;
    private boolean delivred;
    private boolean validated;
    private boolean payed;
    private List<Drink> drink;
    //private List<Food> food;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private boolean deleted;

}
