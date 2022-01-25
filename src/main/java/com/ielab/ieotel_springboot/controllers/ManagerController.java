package com.ielab.ieotel_springboot.controllers;

import java.util.Date;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Manager;
import com.ielab.ieotel_springboot.repositories.ManagerRepository;
import com.ielab.ieotel_springboot.services.ManagerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ieotel/api/Manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveManager(@RequestBody Manager manager){
        
        if(managerRepository.findByCode(manager.getCode()).isEmpty()){
            manager.setCreatedAt(new Date());
            managerService.saveManager(manager);
            return new ResponseEntity("Manager saved...", HttpStatus.OK);
        }else
        {

            return new ResponseEntity("Manager not saved cause manager already exist for code: "+manager.getCode()
                ,HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/all")
    public List<Manager> getAllFoodType() {
        TypeToken<List<Manager>> typeToken = new TypeToken<List<Manager>>(Manager.class){};
        List<Manager> list = managerService.listManager();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showTable(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(managerService.showManager(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateTable(@PathVariable("id")String id, @RequestBody Manager manager){

        if(managerRepository.findById(id).isEmpty()){
            return new ResponseEntity("Manager not updated cause manager not exist for id: "+manager.getId()
                    , HttpStatus.BAD_REQUEST);
        
        }else
        {
            Manager managerDel = this.managerRepository.findById(id)
            .orElseThrow(()->new NotFoundException("_"));
            managerDel.setCode(manager.getCode());
            managerDel.setFirstName(manager.getFirstName());
            managerDel.setLastName(manager.getLastName());
            managerDel.setBirthday(manager.getBirthday());
            managerDel.setTel(manager.getTel());
            managerDel.setEmail(manager.getEmail());
            managerDel.setAddress(manager.getAddress());
            managerDel.setGrade(manager.getGrade());
            managerDel.setManagerType(manager.getManagerType());
            managerDel.setActivated(manager.isActivated());
            managerDel.setUpdatedAt(new Date());
            managerRepository.save(managerDel);
            return new ResponseEntity("Manager successful updated..."
                , HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteManager(@PathVariable("id") String id){
        if(managerRepository.findById(id).isEmpty()){
            return new ResponseEntity("Manager not deleted cause manager not exist for id: "+id
                    , HttpStatus.BAD_REQUEST);
        
        }else
        {
            Manager managerDel = this.managerRepository.findById(id)
            .orElseThrow(()->new NotFoundException("_"));
            managerDel.setDeletedAt(new Date());
            managerDel.setDeleted(true);
            managerRepository.save(managerDel);
            return new ResponseEntity("Manager successful updated..."
                , HttpStatus.OK);
        }
    }
    
}
