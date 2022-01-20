package com.ielab.ieotel_springboot.implementors;


import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ielab.ieotel_springboot.models.Table;
import com.ielab.ieotel_springboot.repositories.TableRepository;
import com.ielab.ieotel_springboot.services.TableService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TableImpl implements TableService {


    @Autowired
    private TableRepository tableRepository;


    @Override
    public List<Table> ListTables() {
        // returns a list of Tables
        // log the action
        //Logger.ListReadLogging("Tables","will get the connected user's name");
        return this.tableRepository.findAll();
    }

    @Override
    public Table saveTable(Table table){
        return this.tableRepository.save(table);
    }

    @Override
    public Table updateTable(String id, Table table){
        Table tablemod = this.tableRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Table not found for id: "+id));
        tablemod.setNombrePlace(table.getNombrePlace());
        tablemod.setCode(table.getCode());
        tablemod.setOccupy(table.isOccupy());
        tablemod.setUpdatedAt(LocalDateTime.now());

        return this.tableRepository.save(tablemod);
    }
    @Override
    public void deleteTable(String id){
        Table tableDel = this.tableRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Table not found for id: "+id));
        this.tableRepository.deleteById(id);
    }

    @Override
    public Table showTable(String id){
        return this.tableRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Table not found for id: "+id));
    }

    public Table showTableCode(String code){
        return this.tableRepository.findByCode(code)
                .orElseThrow(()->new NotFoundException("Table not found for code: "+code));
    }
}
