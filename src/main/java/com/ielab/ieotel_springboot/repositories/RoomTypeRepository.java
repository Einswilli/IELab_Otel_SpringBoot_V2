package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.RoomType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends MongoRepository<RoomType, String> {

    @Query
    List<RoomType> findByLib(String Lib);

}
