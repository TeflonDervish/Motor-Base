package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.config.SecurityConfig;
import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.model.dto.LoginForm;
import com.shesterki.Motor_Base_Server.services.CarService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class PageController {

    private UsersService usersService;
    private CarService carService;

//    @GetMapping("/user")
//    public String user() {
//        Authentication user = SecurityContextHolder.getContext().getAuthentication();
//        user.get
//    }


    @GetMapping("/user/{id}")
    public String login(@PathVariable Long id, Model model) {
        Users users = usersService.getById(id).orElseThrow();
        log.info(String.valueOf(users));
        model.addAttribute("name", users.getName());
        model.addAttribute("surname", users.getSurname());
        model.addAttribute("number", users.getPhoneNumber());
        model.addAttribute("email", users.getEmail());
        model.addAttribute("city", users.getCity());
        model.addAttribute("db", users.getBirthday());
        return "my_account";
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Car> cars = carService.getAll();
        model.addAttribute("cars", cars);
        return "main_page";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute Users user){
        user.setUser_role(Roles.USER);
        usersService.saveUser(user);
        log.info(String.valueOf(user));
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginForm loginForm){
        log.info(String.valueOf(loginForm));
        return "redirect:/main";
    }



}
