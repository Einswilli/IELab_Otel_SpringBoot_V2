package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Room;
import com.ielab.ieotel_springboot.repositories.RoomRepository;
import com.ielab.ieotel_springboot.services.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/Room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value="/all")
    public List<Room> listRoom() {
        TypeToken<List<Room>> typeToken = new TypeToken<List<Room>>(Room.class) {
        };
        List<Room> list = roomService.listRoom();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showRoom(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(roomService.showRoom(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/save")
    public ResponseEntity<?> createRoom(@RequestBody Room room) {
        List<Room> rooms= roomService.ShowRoombyCode(room.getCode());
        if(rooms.isEmpty()){
            roomService.createRoom(room);
            return new ResponseEntity("Room saved successfullly", HttpStatus.OK);
        }else{
            return new ResponseEntity("Room is already exist", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable("id") String id, @RequestBody Room room) {
        if(roomRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("Room Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            roomService.updateRoom(id,room);
            return new ResponseEntity<>("Room succesfully update By id:: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") String id) {
        if(roomRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("Room Not Found by id:: "+id, HttpStatus.NOT_FOUND);
        }else{
            roomService.deleteRoom(id);
            return new ResponseEntity<>("Room is succesfully delete By id::"+id,HttpStatus.OK);
        }

    }
}