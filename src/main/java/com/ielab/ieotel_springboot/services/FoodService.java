package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Food;

import java.util.List;

public interface FoodService {

    public List <Food> listFood();

    public Food showFood(String id);

    public Food showFoodName(String name);

    public Food saveFood(Food food);

    public Food updateFood(String id, Food food);

    public void deleteFood(String id);
}
