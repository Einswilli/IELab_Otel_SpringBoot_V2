package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Drink;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.models.Event;
import com.ielab.ieotel_springboot.repositories.DrinkRepository;
import com.ielab.ieotel_springboot.repositories.EventRepository;
import com.ielab.ieotel_springboot.services.DrinkService;
import com.ielab.ieotel_springboot.services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/Event")
public class EventController {


    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;
    //private Logger logger;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveEvent(@RequestBody Event event) {
            eventService.createEvent(event);
            return new ResponseEntity("Event saved successfullly", HttpStatus.OK);

    }

    @GetMapping(value = "/all")
    public List<DrinkType> getAllEvent() {
        TypeToken<List<Event>> typeToken = new TypeToken<List<Event>>(Event.class){};
        List<Event> list = eventService.listEvent();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showEvent(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(eventService.showEvent(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDrinkType(@PathVariable("id") String id, @RequestBody Event event) {
        if(eventRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("Event Not found by id:"+id, HttpStatus.NOT_FOUND);
        }else{
            eventService.updateEvent(id,event);
            return new ResponseEntity<>("Event succesfully update By id:: "+id, HttpStatus.OK);
        }
    }
    
}
