package com.ielab.ieotel_springboot.repositories;
import com.ielab.ieotel_springboot.models.DrinkType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DrinkTypeRepository extends MongoRepository<DrinkType, String> {
    @Query(value = "lib:'?0'",fields = "'id':1")
    Optional<DrinkType> FindByDrinktype(String lib);
}