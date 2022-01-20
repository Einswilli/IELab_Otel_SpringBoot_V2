package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.ConsoRoom;
import com.ielab.ieotel_springboot.repositories.ConsoRoomRepository;
import com.ielab.ieotel_springboot.services.ConsoRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/ConsoRoom")
public class ConsoRoomController {

    @Autowired
    private ConsoRoomService consoRoomService;

    @Autowired
    private ConsoRoomRepository consoRoomRepository;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping(value = "/all")
    public List<ConsoRoom> listConsoRoom() {
        TypeToken<List<ConsoRoom>> typeToken = new TypeToken<List<ConsoRoom>>(ConsoRoom.class) {
        };
        List<ConsoRoom> list = consoRoomService.listConsoRoom();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showConsoRoom(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(consoRoomService.showConsoRoom(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> createConsoroom(@RequestBody ConsoRoom consoRoom) {
        consoRoomService.crateConsoRoom(consoRoom);
        return new ResponseEntity("consoRoom is successfully saved", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateConsoRoom(@PathVariable("id") String id, @RequestBody ConsoRoom consoRoom) {
        if (consoRoomRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>("Conso Room Not Found by id:" + id, HttpStatus.NOT_FOUND);
        } else {
            consoRoomService.updateConsoRoom(id, consoRoom);
            return new ResponseEntity<>("Updated ConsoRoom with id " + id + "", HttpStatus.OK);
        }
    }
}
