package com.prashanth.flight.repository;

import com.prashanth.flight.model.LoginCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<LoginCredentials,String> {
}
