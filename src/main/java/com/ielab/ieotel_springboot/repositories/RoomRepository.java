package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {
    @Query
    List<Room> findByCode(String code);

    @Query
    List<Room> findByRoomType(String roomType);
}
