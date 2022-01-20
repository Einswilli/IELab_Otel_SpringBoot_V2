package com.ielab.ieotel_springboot.models;

import java.time.LocalDateTime;


import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Table {
	@Id 
	private String id;
	private String code;
	private int nombrePlace;
	private boolean deleted;
	private boolean occupy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
}
