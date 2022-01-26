package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.models.RoomReservation;
import com.ielab.ieotel_springboot.repositories.RoomReservationRepository;
import com.ielab.ieotel_springboot.services.RoomReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/RoomReservation")
public class RoomReservationController {
    @Autowired
    private RoomReservationService roomReservationService;

    @Autowired
    private RoomReservationRepository roomReservationRepository;
    //private Logger logger;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveRoomReservation(@RequestBody RoomReservation roomReservation) {
        List<RoomReservation> roomReservations = roomReservationService.showRoomReservationCode(roomReservation.getCode());
        if(roomReservations.isEmpty()){
            roomReservationService.createRoomReservation(roomReservation);
            return new ResponseEntity("RoomReservation saved successfullly", HttpStatus.OK);
        }else{
            return new ResponseEntity("RoomReservation is already exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public List<DrinkType> getAllRoomReservation() {
        TypeToken<List<RoomReservation>> typeToken = new TypeToken<List<RoomReservation>>(RoomReservation.class){};
        List<RoomReservation> list = roomReservationService.listRoomReservation();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showRoomReservation(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(roomReservationService.showRoomReservation(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateRoomReservation(@PathVariable("id") String id, @RequestBody RoomReservation roomReservation) {
        if(roomReservationRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("RoomReservation Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            roomReservationService.updateRoomReservation(id,roomReservation);
            return new ResponseEntity<>("Roomtype succesfully update By id:: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        if(roomReservationRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("RoomReservation Not Found by id:: "+id, HttpStatus.NOT_FOUND);
        }else{
            roomReservationService.deleteRoomReservation(id);
            return new ResponseEntity<>("RoomReservation is succesfully delete By id::"+id,HttpStatus.OK);
        }
    }
}
