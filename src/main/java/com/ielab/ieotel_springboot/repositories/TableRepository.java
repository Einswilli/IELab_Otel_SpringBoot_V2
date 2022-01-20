package com.ielab.ieotel_springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ielab.ieotel_springboot.models.Table;

import com.ielab.ieotel_springboot.models.Table;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface TableRepository extends MongoRepository<Table, Long> {

    @Query
    Optional <Table> findByCode(String Code);
    Optional<Table> findById(String id);
    void deleteById(String id);
}
