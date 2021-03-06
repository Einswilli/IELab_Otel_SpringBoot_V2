package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {

    @Query
    Optional <Food> findByName(String name);
    Optional<Food> findById(String id);
    void deleteById(String id);
}
