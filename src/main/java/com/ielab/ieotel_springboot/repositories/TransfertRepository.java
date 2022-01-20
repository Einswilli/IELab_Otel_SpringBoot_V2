package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Transfert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends MongoRepository <Transfert, Long> {

    @Query("{reference:?0}")
    public Transfert findByReference(String ref);
}