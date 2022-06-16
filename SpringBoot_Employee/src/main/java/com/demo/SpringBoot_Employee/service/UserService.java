package com.demo.SpringBoot_Employee.service;

import com.demo.SpringBoot_Employee.dto.UserRegistrationDTO;
import com.demo.SpringBoot_Employee.model.User;

public interface UserService {
    User save(UserRegistrationDTO registrationDTO);


}
