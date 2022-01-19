package com.ielab.ieotel_springboot.services;
import com.ielab.ieotel_springboot.models.Table;

import java.util.List;

public interface TableService {


    public List <Table> ListTables();
    public Table saveTable(Table table);

}
