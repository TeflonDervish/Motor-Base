package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.services.AnnouncementService;
import com.shesterki.Motor_Base_Server.services.CarService;
import com.shesterki.Motor_Base_Server.services.UserFeedbackService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private UsersService usersService;
    private CarService carService;
    private UserFeedbackService feedbackService;
    private AnnouncementService announcementService;

    @GetMapping({"", "/"})
    public String admin(){
        return "redirect:/admin/main";
    }

    @GetMapping("/main")
    public String main(Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);

        List<Announcement> announcements = announcementService.getAll();
        model.addAttribute("announcements", announcements);
        return "admin_main_announcement";
    }

    @GetMapping("/users")
    public String users(Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);

        List<Users> users = usersService.getAll();
        model.addAttribute("users", users);

        return "admin_main_users";
    }

    @GetMapping("/main/search")
    public String search(@RequestParam("query") String query,
                         Model model,
                         @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

        List<Announcement> announcements = announcementService.getBySearch(query);

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);
        model.addAttribute("announcements", announcements);
        model.addAttribute("searchInput", query);

        return "admin_main_announcement";
    }

     @GetMapping("/main/searchByFilters")
    public String searchByParam(
            Model modelPage,
            @RequestParam(value = "mark", required = false) String mark,
            @RequestParam(value = "model" ,required = false) String model,
            @RequestParam(value = "yearMake",required = false) Integer yearMake,
            @RequestParam(value = "priceMin",required = false) Integer priceMin, @RequestParam(value = "priceMax", required = false) Integer priceMax,
            @RequestParam(value = "runMin", required = false) Integer runMin, @RequestParam(value = "runMax", required = false) Integer runMax,
            @RequestParam(value = "engineVolume", required = false) Double engineVolume,
            @RequestParam(value = "enginePowers", required = false) Double enginePowers,
            @RequestParam(value = "gearbox", required = false) String gearbox,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "color",required = false) String color
    ) {

        log.info(model);
        Set<Announcement> announcements = announcementService.getByFilter(
                mark,
                model,
                yearMake,
                priceMin, priceMin,
                runMin, runMax,
                engineVolume,
                enginePowers,
                null,
                gearbox,
                type,
                color
        );

        modelPage.addAttribute("announcements", announcements);

        return "admin_main_announcement";
    }



}
