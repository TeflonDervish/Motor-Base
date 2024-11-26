package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.services.AnnouncementService;
import com.shesterki.Motor_Base_Server.services.CarService;
import com.shesterki.Motor_Base_Server.services.FeedbackService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminPageController {

    private UsersService usersService;
    private CarService carService;
    private FeedbackService feedbackService;
    private AnnouncementService announcementService;

    @GetMapping({"", "/"})
    public String admin(){
        return "redirect:/admin/main";
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Announcement> announcements = announcementService.getAll();
        model.addAttribute("announcements", announcements);
        return "admin_obyavlation";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<Users> users = usersService.getAll();
        model.addAttribute("users", users);

        return "admin_users";
    }




}
