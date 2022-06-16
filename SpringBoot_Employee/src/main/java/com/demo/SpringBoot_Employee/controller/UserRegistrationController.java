package com.demo.SpringBoot_Employee.controller;

import com.demo.SpringBoot_Employee.dto.UserRegistrationDTO;
import com.demo.SpringBoot_Employee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService){
        super();
        this.userService = userService;
    }

    @GetMapping
    public String showRegistataionForm(){
        return "registration";
    }
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO registrationDTO){
        userService.save(registrationDTO);
        return "redirect:/registration?success";
    }
}
