package com.brad.mobileapp.service.impl;

import com.brad.mobileapp.entity.UserEntity;
import com.brad.mobileapp.repository.UserRepository;
import com.brad.mobileapp.service.UserService;
import com.brad.mobileapp.shared.Utils;
import com.brad.mobileapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        //this will make sure that user email can't be sent in twice, but it just returns message
        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        //to make use of userEntity
        UserEntity userEntity = new UserEntity();
        //bean utils to copy from user dto class to userEntity
        BeanUtils.copyProperties(user, userEntity);

        //using the method to iterate 30 times
        String publicUserId = utils.generateUserId(30); //now something like mobile can use the public user id to get the details of a record

        //required fields that come from entity that we dont get from json payload //this will get the password from the user
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //this record will be used to identify and find records in database
        userEntity.setUserId(publicUserId);
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
