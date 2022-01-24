package com.ielab.ieotel_springboot.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ManagerType {

    @Id
    private String id;
    private String lib;
    private Date createdAt;
    private Date updatedAt;
}
