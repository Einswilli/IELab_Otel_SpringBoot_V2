package com.ielab.ieotel_springboot.repositories;

import java.util.List;

import com.ielab.ieotel_springboot.models.RoomReservation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationRepository extends MongoRepository<RoomReservation, String> {

    @Query
    List<RoomReservation> findByCode(String code);
}
