package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.repositories.DrinkTypeRepository;
import com.ielab.ieotel_springboot.services.DrinkTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/DrinkType")
public class DrinkTypeController {
    @Autowired
    private DrinkTypeService drinkTypeService;

    @Autowired
    private DrinkTypeRepository drinkTypeRepository;
    //private Logger logger;

     @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveDrinktype(@RequestBody DrinkType drinkType) {
        List<DrinkType> drinkTypes= drinkTypeService.showDrinkTypeByLib(drinkType.getLib());
        if(drinkTypes.isEmpty()){
            drinkTypeService.createDrinkType(drinkType);
            return new ResponseEntity("DrinkType saved successfullly", HttpStatus.OK);
        }else{
            return new ResponseEntity("Drinktype is already exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<DrinkType> getAllDrinkType() {
        TypeToken<List<DrinkType>> typeToken = new TypeToken<List<DrinkType>>(DrinkType.class){};
        List<DrinkType> list = drinkTypeService.listDrinkType();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showDrinkType(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(drinkTypeService.showDrinkType(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDrinkType(@PathVariable("id") String id, @RequestBody DrinkType drinkType) {
        if(drinkTypeRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("DrinkType Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            drinkTypeService.updateDrinkType(id,drinkType);
            return new ResponseEntity<>("Drink Type id succesfully update By id:: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
       if(drinkTypeRepository.findById(id).isEmpty()){
           return new ResponseEntity<>("DrinkType Not Found by id:: "+id, HttpStatus.NOT_FOUND);
       }else{
           drinkTypeService.deleteDrinkType(id);
           return new ResponseEntity<>("DrinkType is succesfully delete By id::"+id,HttpStatus.OK);
       }
    }
}

