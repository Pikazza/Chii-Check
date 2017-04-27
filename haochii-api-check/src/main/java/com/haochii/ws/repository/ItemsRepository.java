package com.haochii.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.haochii.ws.model.Items;

@Repository
public interface ItemsRepository extends MongoRepository<Items, String>{
    
}
