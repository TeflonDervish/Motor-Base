package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.config.SecurityConfig;
import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.model.dto.LoginForm;
import com.shesterki.Motor_Base_Server.services.CarService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        if (userDetailsAdapter != null) {
            return "redirect:/user/" + userDetailsAdapter.getUser().getId();
        }else {
            return "redirect:/login";
        }
    }

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

    @GetMapping("/car/{id}")
    public String car(@PathVariable Long id, Model model) {
        Car car = carService.getById(id).orElseThrow();
        model.addAttribute("run", car.getRun());
        model.addAttribute("year", car.getYearMake());
        model.addAttribute("mark", car.getMark());
        model.addAttribute("model", car.getModel());
        model.addAttribute("engine_powers", car.getEnginePowers());
        model.addAttribute("engine_volume", car.getEngineVolume());
        model.addAttribute("color", car.getColor());
        model.addAttribute("gearbox", car.getGearbox());
        model.addAttribute("type", car.getType());
        model.addAttribute("type_body", car.getTypeBody());

        return "obyavlation";
    }

    @GetMapping("/create-obyavlation")
    public String createObyavliation(Model model) {
        model.addAttribute("car", new Car());
        return "create_obyavlation";
    }

    @PostMapping("/create-obyavlation")
    public String createObyavliation(@ModelAttribute Car car){
        Long id = carService.saveCar(car).getId();
        log.info(String.valueOf(car));
        return "redirect:/car/" + id;
    }




}
