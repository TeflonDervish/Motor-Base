package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.model.UserLogin;
import com.shesterki.Motor_Base_Server.services.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userLogin")
@AllArgsConstructor
public class UserLoginController {

    private UserLoginService userLoginService;

    @GetMapping("/getAll")
    private List<UserLogin> getAll() {
        return userLoginService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<UserLogin> getById(@PathVariable Long id){
        return userLoginService.getById(id);
    }
}
