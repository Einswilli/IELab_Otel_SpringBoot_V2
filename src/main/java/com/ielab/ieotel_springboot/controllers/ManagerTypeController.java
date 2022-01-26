package com.ielab.ieotel_springboot.controllers;


import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.ManagerType;
import com.ielab.ieotel_springboot.repositories.ManagerTypeRepository;
import com.ielab.ieotel_springboot.services.ManagerTypeService;
import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ieotel/api/ManagerType")
public class ManagerTypeController {

    @Autowired
    private ManagerTypeService managerTypeService;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private ManagerTypeRepository managerTypeRepository;

    @GetMapping(value = "/all")
    public List<ManagerType> listManagerType(){
        TypeToken<List<ManagerType>> typeToken = new TypeToken<List<ManagerType>>(ManagerType.class){
        };
        List<ManagerType> list = managerTypeService.listManagerType();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping("/show/{id}")
     public ResponseEntity<?> showManagerType(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(managerTypeService.showManagerType(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveManagerType(@RequestBody ManagerType managerType) {
        if(managerTypeRepository.findByLib(managerType.getLib()).isEmpty()){
            managerTypeService.saveManagerType(managerType);
            return new ResponseEntity("Manager type saved...", HttpStatus.OK);
        }else
        {
            return new ResponseEntity("Manager Type not saved cause food type already exist for lib: "+managerType.getLib()
                    , HttpStatus.BAD_REQUEST);
                    
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateManager(@PathVariable("id")String id, @RequestBody ManagerType managerType){

        if(managerTypeRepository.findById(id).isEmpty()){
            managerType.setUpdatedAt(new Date());
            managerTypeService.saveManagerType(managerType);
            
            return new ResponseEntity("Manager Type not updated cause food type not exist for id: "+managerType.getId()
                , HttpStatus.BAD_REQUEST);
        }else
        {
            ManagerType managerTypeMod = this.managerTypeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("_"));
                managerTypeMod.setUpdatedAt(new Date());
                managerTypeMod.setLib(managerType.getLib());
                managerTypeService.saveManagerType(managerTypeMod);

            return new ResponseEntity("Manager type successful updated..."
                , HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        managerTypeService.deleteManagerType(id);
        return new ResponseEntity("Manager type deleted...", HttpStatus.OK);
    }

}
