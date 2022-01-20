package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class RoomType {
    @Id
    private String id;
    private String lib;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private boolean deleted;
}
