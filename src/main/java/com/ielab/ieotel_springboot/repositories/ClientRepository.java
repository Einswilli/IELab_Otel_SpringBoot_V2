package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {
    @Query(value = "firstName:'?0',lastName:'?0',email:'?0'",fields = "'id':1")
    Optional<Client> findByClient(String firstName,String lastName,String email);

    @Query("{id:?0}")
    public Client findClientById(String id);

    @Query("{code:?0}")
    public Client findClientByCode(String code);

    @Query("{code:?0}")
    public List<Client> existsByCode(String code);

    boolean existsClientByCode(String code);

    //@Override
    //boolean exists(String code) {
        //return mongoOperations.exists(getIdQuery(id), entityClass);
     // }
}
