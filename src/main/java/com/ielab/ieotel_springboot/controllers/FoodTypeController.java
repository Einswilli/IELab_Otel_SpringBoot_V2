package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.FoodType;
import com.ielab.ieotel_springboot.repositories.FoodTypeRepository;
import com.ielab.ieotel_springboot.services.FoodTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ieotel/api/FoodType")
public class FoodTypeController {
    @Autowired
    private FoodTypeService foodTypeService;
    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    public ModelMapper modelMapper;



    @PostMapping(value = "/save")
    public ResponseEntity<?> saveFoodType(@RequestBody FoodType foodType) {

        if(foodTypeRepository.findByLib(foodType.getLib()).isEmpty()){
            foodType.setCreatedAt(new Date());
            foodTypeService.saveFoodType(foodType);
            return new ResponseEntity("Food tye saved...", HttpStatus.OK);
        }else
        {

            return new ResponseEntity("Food Type not saved cause food type already exist for lib: "+foodType.getLib()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<FoodType> getAllFoodType() {
        TypeToken<List<FoodType>> typeToken = new TypeToken<List<FoodType>>(FoodType.class){};
        List<FoodType> list = foodTypeService.listFoodType();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showTable(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(foodTypeService.showFoodType(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateTable(@PathVariable("id")String id, @RequestBody FoodType foodType ){

        if(foodTypeRepository.findById(id).isEmpty()){
            return new ResponseEntity("Food Type not updated cause food type not exist for id: "+foodType.getId()
                    , HttpStatus.BAD_REQUEST);
        
        }else
        {
            FoodType foodTypeMod = this.foodTypeRepository.findById(id)
            .orElseThrow(()->new NotFoundException("_"));
            foodTypeMod.setLib(foodType.getLib());
            foodTypeMod.setUpdatedAt(new Date());
            foodTypeRepository.save(foodTypeMod);
            return new ResponseEntity("Food type successful updated..."
            , HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        foodTypeService.deleteFoodType(id);
        return new ResponseEntity("Food type deleted...", HttpStatus.OK);
    }

}
