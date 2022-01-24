package com.ielab.ieotel_springboot.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Manager {

    private String id;
    private String code;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String tel;
    private String email;
    private String address;
    private String grade;
    private ManagerType managerType;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private boolean activated;
    private boolean deleted;
}
