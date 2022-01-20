package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.ConsoRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoRoomRepository extends MongoRepository<ConsoRoom,String> {
}
