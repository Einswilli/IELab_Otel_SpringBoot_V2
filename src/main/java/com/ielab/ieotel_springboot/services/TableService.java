package com.ielab.ieotel_springboot.services;
import com.ielab.ieotel_springboot.models.Table;

import java.util.List;

public interface TableService {


    public List <Table> ListTables();
    public Table saveTable(Table table);

    public Table updateTable(String id, Table table);
    public void deleteTable(String id);
    public Table showTable(String id);
    public Table showTableCode(String code);

}
