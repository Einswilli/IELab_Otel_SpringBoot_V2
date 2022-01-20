package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Drink;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.repositories.DrinkRepository;
import com.ielab.ieotel_springboot.services.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/Drink")
public class DrinkController {


    @Autowired
    private DrinkService drinkService;

    @Autowired
    private DrinkRepository drinkRepository;
    //private Logger logger;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveDrink(@RequestBody Drink drink) {
        List<Drink> drinks= drinkService.showDrinkbyNamePriceAnddrinkType(drink.getName(),drink.getPrice(),drink.getDrinkType());
        if(drinks.isEmpty()){
            drinkService.createDrink(drink);
            return new ResponseEntity("Drink saved successfullly", HttpStatus.OK);
        }else{
            return new ResponseEntity("Drink is already exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<DrinkType> getAllDrink() {
        TypeToken<List<Drink>> typeToken = new TypeToken<List<Drink>>(Drink.class){};
        List<Drink> list = drinkService.listDrinkType();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showDrinkType(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(drinkService.showDrink(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDrinkType(@PathVariable("id") String id, @RequestBody Drink drink) {
        if(drinkRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("Drink Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            drinkService.updateDrink(id,drink);
            return new ResponseEntity<>("Drink succesfully update By id:: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        if(drinkRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("Drink Not Found by id:: "+id, HttpStatus.NOT_FOUND);
        }else{
            drinkService.deleteDrink(id);
            return new ResponseEntity<>("Drink is succesfully delete By id::"+id,HttpStatus.OK);
        }
    }
}
