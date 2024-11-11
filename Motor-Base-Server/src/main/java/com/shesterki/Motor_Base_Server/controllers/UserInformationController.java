package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.model.UserInofrmation;
import com.shesterki.Motor_Base_Server.services.UserInformationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userInformation")
@AllArgsConstructor
public class UserInformationController {

    private UserInformationService userInformationService;

    @GetMapping("/getAll")
    private List<UserInofrmation> getAll() {
        return userInformationService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<UserInofrmation> getById(@PathVariable Long id){
        return userInformationService.getById(id);
    }
}
