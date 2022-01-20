package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Table;
import com.ielab.ieotel_springboot.services.TableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Table tableTest = tableService.showTableCode(table.getCode());
        if(tableTest.getId() != null){
            return new ResponseEntity("Table non enregistrée car Tabe existe déjà pour code "+tableTest.getCode()
                    , HttpStatus.BAD_REQUEST);
        }else
        {
            tableService.saveTable(table);
            return new ResponseEntity("Table enregistrée...", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/all")
    public List<Table> getAllTables() {
        TypeToken<List<Table>> typeToken = new TypeToken<List<Table>>(Table.class){};
        List<Table> list = tableService.ListTables();
        return modelMapper.map(list, typeToken.getType());
    }


    @GetMapping(value = "/show/{id}")
    public ResponseEntity<?> showTable(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(tableService.showTable(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateTable(@PathVariable("id")String id, @RequestBody Table table ){
        tableService.updateTable(id, table);
        return new ResponseEntity("Table moodifiée...", HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id")String id){
        tableService.deleteTable(id);
        return new ResponseEntity("Table supprimée...", HttpStatus.OK);
    }

}
