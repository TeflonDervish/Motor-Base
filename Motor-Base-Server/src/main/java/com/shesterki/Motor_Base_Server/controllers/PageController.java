package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.*;
import com.shesterki.Motor_Base_Server.model.dto.LoginForm;
import com.shesterki.Motor_Base_Server.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class PageController {

    private UsersService usersService;
    private CarService carService;
    private UserFeedbackService feedbackService;
    private AnnouncementService announcementService;
    private UsersDetailsService usersDetailsService;
    private AuthenticationManager authenticationManager;

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        if (userDetailsAdapter != null) {
            return "redirect:/user/" + userDetailsAdapter.getUser().getId();
        }else {
            return "redirect:/login";
        }
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id,
                       Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        Users users = usersService.getById(id).orElseThrow();
        log.info(String.valueOf(users));
        model.addAttribute("name", users.getName());
        model.addAttribute("surname", users.getSurname());
        model.addAttribute("number", users.getPhoneNumber());
        model.addAttribute("email", users.getEmail());
        model.addAttribute("city", users.getCity());
        model.addAttribute("db", users.getBirthday());

        List<Announcement> announcements = announcementService.getByUserId(users.getId());
        model.addAttribute("announcements", announcements);

        feedbackService.getById(users.getId());

        if (userDetailsAdapter.getUser().getId() == id) {
            return "my_account";
        }else {

            return "user_account";
        }
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Announcement> announcements = announcementService.getAll();

        model.addAttribute("announcements", announcements);
        return "main_page";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users user){
        user.setUser_role(Roles.USER);
        usersService.saveUser(user);
        log.info(String.valueOf(user));
        return "redirect:/login";
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
    public String car(@PathVariable Long id,
                      Model model,
                      @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        Announcement announcement = announcementService.getById(id).orElseThrow();
        Car car = announcement.getCar();
        Users users = announcement.getUser();

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

        model.addAttribute("info_car", car.getModel() + " " +
                car.getMark() + " " +
                car.getYearMake());
        model.addAttribute("price", announcement.getPrice());
        model.addAttribute("phoneNumber", users.getPhoneNumber());
        model.addAttribute("name", users.getName());
        model.addAttribute("description", announcement.getDescription());

        if (userDetailsAdapter.getUser().getId() == users.getId()) {
            return "my_obyavlation";
        }else {
            return "obyavlation";

        }

    }

    @GetMapping("/create-obyavlation")
    public String createObyavliation(Model model) {
        model.addAttribute("car", new Car());
        return "create_obyavlation";
    }

    @PostMapping("/create-obyavlation")
    public String createObyavliation(@ModelAttribute Car car,
                                     @RequestParam("name") String name,
                                     @RequestParam("price") Double price,
                                     @RequestParam("description") String description,
                                     @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

        Car newCar = carService.saveCar(car);
        Announcement announcement = new Announcement();
        announcement.setCar(newCar);
        announcement.setPrice(price);
        announcement.setDate(LocalDate.now());
        announcement.setDescription(description);
        announcement.setUser(userDetailsAdapter.getUser());
        announcementService.postAnnouncement(announcement);

        log.info(String.valueOf(car));
        return "redirect:/car/" + car.getId();
    }

    @PostMapping("/create-feedback/{id}")
    public void createFeedback(@PathVariable Long id,
                                 @RequestParam("otziv") String text,
                                 @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

    }




}
