package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Drink;
import com.ielab.ieotel_springboot.models.DrinkType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository  extends MongoRepository<Drink, String> {
    @Query
    List<Drink> findByNameAndPriceAndDrinkType(String name, Float price, DrinkType drinkType);
    //@Query
    //List<Drink> findByDrink(String Name);
}
