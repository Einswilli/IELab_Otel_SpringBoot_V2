package com.ielab.ieotel_springboot.controllers;


import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.implementors.ClientImpl;
import com.ielab.ieotel_springboot.models.*;
import com.ielab.ieotel_springboot.repositories.*;
import com.ielab.ieotel_springboot.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
@RestController
@RequestMapping("/ieotel/api/Transfert")
public class TransfertController {
    
    @Autowired
    private TransfertService tfservice;

    @GetMapping(value="/all")
    public List<Transfert> list(){
        return this.tfservice.listTransfert();
    }

    @GetMapping(value = "/show/{ref}")
    public Transfert showOne(@PathVariable(value = "ref") String ref){
        return this.tfservice.showTransfert(ref);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTransfert(@RequestBody Transfert tf){
        this.tfservice.saveTransfert(tf);
        return new ResponseEntity("transfert éffectué", HttpStatus.OK);
    }
}
