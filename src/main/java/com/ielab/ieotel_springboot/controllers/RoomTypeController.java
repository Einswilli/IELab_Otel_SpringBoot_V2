package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.models.RoomType;
import com.ielab.ieotel_springboot.repositories.RoomTypeRepository;
import com.ielab.ieotel_springboot.services.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/RoomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomTypeRepository roomTypeRepository;
    //private Logger logger;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveRoomType(@RequestBody RoomType roomType) {
        List<RoomType> roomTypes= roomTypeService.showRoomByLib(roomType.getLib());
        if(roomTypes.isEmpty()){
            roomTypeService.createRoomType(roomType);
            return new ResponseEntity("RoomType saved successfullly", HttpStatus.OK);
        }else{
            return new ResponseEntity("RoomType is already exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<DrinkType> getAllRoomType() {
        TypeToken<List<RoomType>> typeToken = new TypeToken<List<RoomType>>(RoomType.class){};
        List<RoomType> list = roomTypeService.listRoomType();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/Show/{id}")
    public ResponseEntity<?> showDrinkType(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(roomTypeService.showRoomType(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<?> updateDrinkType(@PathVariable("id") String id, @RequestBody RoomType roomType) {
        if(roomTypeRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("RoomType Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            roomTypeService.updateRoomType(id,roomType);
            return new ResponseEntity<>("Roomtype succesfully update By id:: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        if(roomTypeRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("RoomType Not Found by id:: "+id, HttpStatus.NOT_FOUND);
        }else{
            roomTypeService.deleteRoomType(id);
            return new ResponseEntity<>("RoomType is succesfully delete By id::"+id,HttpStatus.OK);
        }
    }
}
