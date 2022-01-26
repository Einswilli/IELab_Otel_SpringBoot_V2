package com.ielab.ieotel_springboot.repositories;


import com.ielab.ieotel_springboot.models.ManagerType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerTypeRepository extends MongoRepository<ManagerType, String> {

    @Query
    Optional<ManagerType> findByLib(String lib);
    Optional<ManagerType> findById(String id);
    void deleteById(String id);
}
