package com.ielab.ieotel_springboot.implementors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ielab.ieotel_springboot.models.Table;
import com.ielab.ieotel_springboot.repositories.TableRepository;
import com.ielab.ieotel_springboot.services.TableService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TableImpl implements TableService {


    @Autowired
    private TableRepository tableRepository;


    @Override
    public List<Table> ListTables() {

        return this.tableRepository.findAll();
    }


    public Table saveTable(Table table){

        return this.tableRepository.save(table);
    }




}
