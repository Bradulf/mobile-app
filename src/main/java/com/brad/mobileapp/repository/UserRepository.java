package com.brad.mobileapp.repository;

import com.brad.mobileapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> { //this is the class that we use to query the database table
    //the class of the object that needs to be persisted userEntity, 2nd is return type of the id, which is Long
    //this way we can use method findUserByEmail to persist email data
    UserEntity findByEmail(String email); //if we want to query the database by user email, and it's defined in the user entity

}
