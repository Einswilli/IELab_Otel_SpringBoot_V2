package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,String> {
}
