package com.brad.mobileapp.service;

import com.brad.mobileapp.shared.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //
    UserDto createUser(UserDto user);
}
