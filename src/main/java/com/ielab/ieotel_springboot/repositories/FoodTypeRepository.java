package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.FoodType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodTypeRepository extends MongoRepository<FoodType, String> {
    
    @Query("{lib:?0}")
    Optional <FoodType> findByLib(String lib);
    Optional <FoodType> findById(String id);
    void deleteById(String id);
}
