package com.brad.mobileapp.controller;

import com.brad.mobileapp.service.UserService;
import com.brad.mobileapp.shared.dto.UserDto;
import com.brad.mobileapp.ui.model.request.UserDetailsRequestModel;
import com.brad.mobileapp.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        //request body is able to convert incoming json object into java object

        //this will be the user information that will be returned of type userRest
        UserRest returnValue = new UserRest();
        //creating the user transfer object the DTO populate the information i have received from the user in the RequestBody
        UserDto dto = new UserDto();
        //copies properties from source object to target object
        BeanUtils.copyProperties(userDetails, dto);
        //dto is shared across different layers which we created at ui level and passing it to service layer which will perform different business logic then add those values to the dto object. this method is for the createUser method
        UserDto creatUser = userService.createUser(dto);
        //take created user object and copy it to the return value object
        BeanUtils.copyProperties(creatUser, returnValue);
        //return the updated value
        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
