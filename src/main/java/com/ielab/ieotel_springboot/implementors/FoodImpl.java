package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Food;
import com.ielab.ieotel_springboot.repositories.FoodRepository;
import com.ielab.ieotel_springboot.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> listFood() {
        return this.foodRepository.findAll();
    }

    @Override
    public Food showFood(String id) {
        return this.foodRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Food not found for id: "+id));
    }

    @Override
    public Food showFoodName(String name) {
        return this.foodRepository.findByName(name)
                .orElseThrow(()->new NotFoundException("Food not found for name: "+name));
    }

    @Override
    public Food saveFood(Food food) {
        return this.foodRepository.save(food);
    }

    @Override
    public Food updateFood(String id, Food food) {
        Food foodMod = this.foodRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Food not found for id: "+id));
        foodMod.setName(food.getName());
        foodMod.setLib(food.getLib());
        foodMod.setUpdatedAt(food.getUpdatedAt());
        return this.foodRepository.save(foodMod);
    }

    @Override
    public void deleteFood(String id) {
        Food foodDel = this.foodRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Food not found for id: "+id));
        this.foodRepository.deleteById(id);
    }
}
