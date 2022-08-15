package com.example.usertestproject.repository;


import com.example.usertestproject.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
