package com.shesterki.Motor_Base_Server.controllers;


import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import com.shesterki.Motor_Base_Server.model.*;
import com.shesterki.Motor_Base_Server.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class MainController {

    private AnnouncementService announcementService;

    @GetMapping("/main")
    public String main(Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        List<Announcement> announcements = announcementService.getAll();

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);
        model.addAttribute("announcements", announcements);

        return "main";
    }




}
