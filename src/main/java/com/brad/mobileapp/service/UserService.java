package com.brad.mobileapp.service;

import com.brad.mobileapp.repository.UserRepository;
import com.brad.mobileapp.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    //
    UserDto createUser(UserDto user);


}
