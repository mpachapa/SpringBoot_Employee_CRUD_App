package com.demo.SpringBoot_Employee.service;

import com.demo.SpringBoot_Employee.dto.UserRegistrationDTO;
import com.demo.SpringBoot_Employee.model.Role;
import com.demo.SpringBoot_Employee.model.User;
import com.demo.SpringBoot_Employee.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO){
        User user = new User(registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getEmail(), registrationDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}

