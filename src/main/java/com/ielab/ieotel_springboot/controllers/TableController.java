package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.models.Table;
import com.ielab.ieotel_springboot.repositories.TableRepository;
import com.ielab.ieotel_springboot.services.TableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ieotel/api/Table")
public class TableController {
    @Autowired
    private TableService tableService;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTable(@RequestBody Table table) {
        tableService.saveTable(table);
        return new ResponseEntity("Table enregistrée...", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Table> getAllTables() {
        TypeToken<List<Table>> typeToken = new TypeToken<List<Table>>(Table.class){};
        List<Table> list = tableService.ListTables();
        return modelMapper.map(list, typeToken.getType());
    }

    //@GetMapping(value = "/show/{code}")
    //public Table getTableByCode(@PathVariable (value = "code") String code){
        //return tableService.findTableByCode(code);
    //}

}
