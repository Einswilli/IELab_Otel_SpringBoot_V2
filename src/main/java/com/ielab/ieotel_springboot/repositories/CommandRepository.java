package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Command;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends MongoRepository<Command, String> {

}
