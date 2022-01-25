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
public class Event {
    @Id
    private String id;
   // private Client client;
   // private List<Command> commands;
    private ConsoRoom consoRoom;
    private Date date;
    private boolean payed;
    private Date updateAt;
    private Date createAt;
}
