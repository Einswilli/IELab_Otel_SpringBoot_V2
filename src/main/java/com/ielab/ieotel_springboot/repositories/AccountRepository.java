package com.ielab.ieotel_springboot.repositories;

import com.ielab.ieotel_springboot.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}
