package com.ielab.ieotel_springboot.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class RoomReservation {

    private String id;
	private String code;
	private String lib;
	private Date date_Res;
	private Date date_Deb;
	private Date date_Fin;
	private Float cost;
    private List<Room> rooms;
    private Client client;
	private Date deletedAt;
    private Date updatedAt;
	private Date createdAt;
	private boolean Annul;
	private boolean validate;
    
}
