package com.ielab.ieotel_springboot.repositories;

import java.util.List;
import java.util.Optional;

import com.ielab.ieotel_springboot.models.Occupation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OccupationRepository extends MongoRepository<Occupation, String>{
    @Query
    Optional <Occupation> findById(String id);
    @Query
    Optional <Occupation> findByLib(String lib);
    void deleteById(String id);

    
}
