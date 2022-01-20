package com.ielab.ieotel_springboot.implementors;


import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.FoodType;
import com.ielab.ieotel_springboot.repositories.FoodTypeRepository;
import com.ielab.ieotel_springboot.services.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FoodTypeImpl implements FoodTypeService {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Override
    public List<FoodType> listFoodType() {
        return this.foodTypeRepository.findAll();
    }

    @Override
    public FoodType saveFoodType(FoodType foodType) {
        return this.foodTypeRepository.save(foodType);
    }

    @Override
    public FoodType updateFoodType(String id, FoodType foodType) {
        FoodType foodTypeMod = this.foodTypeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food type not found for id: "+id));
        foodTypeMod.setLib(foodType.getLib());
        foodTypeMod.setUpdatedAt(new Date());
        return this.foodTypeRepository.save(foodTypeMod);
    }

    @Override
    public void deleteFoodType(String id) {
        FoodType foodTypeDel = this.foodTypeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Food Type not found for id: "+id));
        this.foodTypeRepository.deleteById(id);
    }

    @Override
    public FoodType showFoodType(String id) {
        return this.foodTypeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food type not found for id: "+id));
    }

    @Override
    public FoodType showFoodTypeLib(String lib) {
        return this.foodTypeRepository.findByLib(lib)
                .orElseThrow(()->new NotFoundException("Food type not found for lib: "+lib));
    }
}
