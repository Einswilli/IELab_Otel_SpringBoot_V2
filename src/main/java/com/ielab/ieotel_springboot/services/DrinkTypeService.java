package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.DrinkType;

import java.util.List;

public interface DrinkTypeService {

    public DrinkType createDrinkType(DrinkType drinkType);

    public DrinkType updateDrinkType(Long id, DrinkType drinkType);

    public boolean deleteDrinkType(Long id);

    public List<DrinkType> listDrinkType();

    public DrinkType showDrinkType(Long id);
}
