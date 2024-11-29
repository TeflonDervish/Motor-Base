package com.shesterki.Motor_Base_Server.controllers;


import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.*;
import com.shesterki.Motor_Base_Server.services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@Controller
@AllArgsConstructor
public class MainController {

    private AnnouncementService announcementService;

    @GetMapping("/main")
    public String main(Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        List<Announcement> announcements = announcementService.getAll();

        if (userDetailsAdapter != null &&
                userDetailsAdapter.getUser().getUserRole() == Roles.ADMIN) return "redirect:/admin/main";

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);
        model.addAttribute("announcements", announcements);

        return "main";
    }

    @GetMapping("/main/search")
    public String search(@RequestParam("query") String query,
                         Model model,
                         @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

        List<Announcement> announcements = announcementService.getBySearch(query);

        if (userDetailsAdapter.getUser().getUserRole() == Roles.ADMIN) return "redirect:/admin/main";

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);
        model.addAttribute("announcements", announcements);
        model.addAttribute("searchInput", query);

        return "main";
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

        return "main";
    }





}
