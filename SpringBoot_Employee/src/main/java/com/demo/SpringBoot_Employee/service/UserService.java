package com.demo.SpringBoot_Employee.service;

import com.demo.SpringBoot_Employee.dto.UserRegistrationDTO;
import com.demo.SpringBoot_Employee.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO registrationDTO);


    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
