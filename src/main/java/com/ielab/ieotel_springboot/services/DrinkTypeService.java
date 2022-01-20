package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.DrinkType;

import java.util.List;

public interface DrinkTypeService {

    public DrinkType createDrinkType(DrinkType drinkType);

    public DrinkType updateDrinkType(String id, DrinkType drinkType);

    public boolean deleteDrinkType(String id);

    public List<DrinkType> listDrinkType();

    public DrinkType showDrinkType(String id);

    public List<DrinkType> showDrinkTypeByLib(String lib);
}
