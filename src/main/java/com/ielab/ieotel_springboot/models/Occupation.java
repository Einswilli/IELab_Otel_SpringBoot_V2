package com.ielab.ieotel_springboot.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Occupation {

    @Id
	private String id;
	private String lib;
	private Date dated;
	private Date datef;
	private Client client;
	private Room room;
	private Date createdAt;
	private Date updatedAt;
}
