package com.haochii.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.haochii.ws.model.WorkingDays;

@Repository
public interface WorkingDaysRepository extends MongoRepository<WorkingDays, String>{
    
}
