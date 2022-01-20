package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.FoodType;

import java.util.List;

public interface FoodTypeService {

    public List<FoodType> listFoodType();
    public FoodType showFoodType(String id);
    public FoodType showFoodTypeLib(String lib);
    public FoodType saveFoodType(FoodType foodType);
    public FoodType updateFoodType(String id, FoodType foodType) ;
    public void deleteFoodType(String id);
}
