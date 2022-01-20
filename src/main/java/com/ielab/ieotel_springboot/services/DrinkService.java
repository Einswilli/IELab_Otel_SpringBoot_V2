package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Drink;
import com.ielab.ieotel_springboot.models.DrinkType;

import java.util.List;

public interface DrinkService {
    public Drink createDrink(Drink drink);

    public Drink updateDrink(String id, Drink drink);

    public boolean deleteDrink(String id);

    public List<Drink> listDrinkType();

    public Drink showDrink(String id);

    public List<Drink> showDrinkbyNamePriceAnddrinkType(String name,Float price,DrinkType drinkType);
}
