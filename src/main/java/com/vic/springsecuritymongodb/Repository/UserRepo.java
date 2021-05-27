package com.vic.springsecuritymongodb.Repository;

import com.vic.springsecuritymongodb.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findUsersByName(String name);
}
