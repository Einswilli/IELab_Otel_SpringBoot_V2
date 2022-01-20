package com.ielab.ieotel_springboot.controllers;


import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Command;
import com.ielab.ieotel_springboot.repositories.CommandRepository;
import com.ielab.ieotel_springboot.repositories.EventRepository;
import com.ielab.ieotel_springboot.services.CommandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/Command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @Autowired
    private CommandRepository commandRepository;
    //private Logger logger;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCommand(@RequestBody Command command) {
        commandService.createCommand(command);
        return new ResponseEntity("Command saved successfullly", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Command> getAllCommand() {
        TypeToken<List<Command>> typeToken = new TypeToken<List<Command>>(Command.class) {
        };
        List<Command> list = commandService.listCommand();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showCommand(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(commandService.showCommand(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateCommand(@PathVariable("id") String id, @RequestBody Command command) {
        if (commandRepository.findById(id).isEmpty()) {
            return new ResponseEntity("command Not found by id:" + id, HttpStatus.NOT_FOUND);
        } else {
            commandService.updateCommand(id, command);
            return new ResponseEntity("Command succesfully update By id:: " + id, HttpStatus.OK);
        }
    }
    @DeleteMapping(value="/delete")
    public ResponseEntity<?> deleteAll(){
         commandRepository.deleteAll();
         return new ResponseEntity<>("deletedeletedelete",HttpStatus.OK);

    }
}

