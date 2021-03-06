package com.ielab.ieotel_springboot.repositories;
import com.ielab.ieotel_springboot.models.DrinkType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrinkTypeRepository extends MongoRepository<DrinkType, String> {
    @Query
    List<DrinkType> findByLib(String lib);
}