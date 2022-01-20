package com.ielab.ieotel_springboot.models;

import com.ielab.ieotel_springboot.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Document(collection = "Transfert")
@Data @AllArgsConstructor @NoArgsConstructor
public class Transfert{

    @Id @BsonProperty("id")
    private Long id;
    private String Reference;
    private Client Author;
    private float Amount;
    private Date CreatedAt;
    private boolean State;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public Client getAuthor() {
        return Author;
    }

    public void setAuthor(Client author) {
        Author = author;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        State = state;
    }
}
