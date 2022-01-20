package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ConsoRoom {
    @Id
    private String id;
    private String code;
    private Room room;
    private List<Drink> drinks;
    private Float cust;
    private Date date;
    private Date createAt;
    private Date UpdateAt;
}
