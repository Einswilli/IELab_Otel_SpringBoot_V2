package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Food;
import com.ielab.ieotel_springboot.repositories.FoodRepository;
import com.ielab.ieotel_springboot.services.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ieotel/api/Food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTable(@RequestBody Food food) {
        if(foodRepository.findByName(food.getName()).isEmpty()){
            food.setCreatedAt(new Date());
            foodService.saveFood(food);
            return new ResponseEntity("Food saved ..."
                    , HttpStatus.OK);
        }else
        {
            return new ResponseEntity("Food not saved caus food already exist for name..."+food.getName()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<Food> getAllFood(){
        TypeToken<List<Food>> typeToken = new TypeToken<List<Food>>(Food.class){};
        List<Food> list = foodService.listFood();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showFood(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(foodService.showFood(id), HttpStatus.OK);
        }
        catch(NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateFood(@PathVariable("id")String id, @RequestBody Food food ){
        foodService.updateFood(id, food);
        return new ResponseEntity("Food successful updated...", HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable("id")String id){
        foodService.deleteFood(id);
        return new ResponseEntity("Table supprimée...", HttpStatus.OK);
    }


}
