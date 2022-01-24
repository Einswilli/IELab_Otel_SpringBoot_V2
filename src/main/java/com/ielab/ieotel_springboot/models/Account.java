package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Account")
public class Account {
    @Id
    private Long id;
    private List<Event> events;
    private Client client;
    private Date date;
    private Float cost;
    private Float remise;
    private String path;
    private LocalDate updateAt;

    
}

