package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private UsersService usersService;

    @GetMapping("/getAll")
    private ResponseEntity<List<Users>> getAll() {
        log.info("Получена информация о пользователях");
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<Users>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(usersService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    private ResponseEntity<Users> registerUser(@RequestBody Users user) {
        user.setUser_role(Roles.USER);
        return new ResponseEntity<>(usersService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/register/admin")
    private ResponseEntity<Users> registerAdmin(@RequestBody Users user) {
        user.setUser_role(Roles.ADMIN);
        return new ResponseEntity<>(usersService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<Users> updateUser(@RequestBody Users user){
        return new ResponseEntity<>(usersService.updateUser(user), HttpStatus.OK);
    }
}
