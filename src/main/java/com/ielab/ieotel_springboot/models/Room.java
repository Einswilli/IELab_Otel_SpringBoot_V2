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
public class Room {
    @Id
    private String id;
    private String code;
    private Boolean statut;
    private Boolean state;
    private RoomType roomType;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private List<Drink> drinks;
}
