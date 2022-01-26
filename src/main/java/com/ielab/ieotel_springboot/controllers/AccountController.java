package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.*;
import com.ielab.ieotel_springboot.models.*;
import com.ielab.ieotel_springboot.repositories.*;
import com.ielab.ieotel_springboot.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ieotel/api/Account")
public class AccountController {
    

    @Autowired
    private AccountService acService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Account ac) {

        return new ResponseEntity(this.acService.saveAccount(ac), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public List<Account> list() {
        TypeToken<List<Account>> typeToken = new TypeToken<List<Account>>(Account.class){};
        List<Account> list = acService.listAccount();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showOne(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(acService.showAccount(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Account By ID: "+id+" Not Found!", HttpStatus.NOT_FOUND);
        }
    }
}
