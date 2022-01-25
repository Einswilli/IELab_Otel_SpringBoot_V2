package com.ielab.ieotel_springboot.controllers;

import java.util.List;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Occupation;
import com.ielab.ieotel_springboot.repositories.OccupationRepository;
import com.ielab.ieotel_springboot.services.OccupationService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ieotel/api/Occupation")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private OccupationRepository occupationRepository;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOccupation(@RequestBody Occupation occupation){
        occupationService.createOccupation(occupation);
        return new ResponseEntity("Occupation saved successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Occupation> getAllOccupation(){
        TypeToken<List<Occupation>> typeToken = new TypeToken<List<Occupation>>(Occupation.class){};
        List<Occupation> list = occupationService.listOccupation();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showOccupation(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(occupationService.showOccupation(id), HttpStatus.OK);
        }catch(NotFoundException e){
            return new ResponseEntity<>(occupationService.showOccupation(id), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOccupation(@PathVariable("id") String id, @RequestBody Occupation occupation) {
        if(occupationRepository.findById(id).isEmpty()){
            return  new ResponseEntity<>("Occupation not found for id:"+id, HttpStatus.NOT_FOUND);
        }else{
            occupationService.updateOccupation(id,occupation);
            return new ResponseEntity<>("Occupation succesfully updated for id: "+id, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOccupation(@PathVariable("id") String id) {
        if(occupationRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("Occupation not found for id:"+id, HttpStatus.NOT_FOUND);
        }else{
            occupationService.deleteOccupation(id);
            return new ResponseEntity<>("Occupation succesfully deleted ",HttpStatus.OK);
        }

    }
}
