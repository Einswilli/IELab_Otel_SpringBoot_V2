package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

    @Query
    Optional<Manager> findByCode(String code);
    Optional<Manager> findById(String id);
    void deleteById(String id);
}
