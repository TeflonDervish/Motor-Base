package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.services.AnnouncementService;
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
public class AnnouncementController{

    private AnnouncementService announcementService;

    @GetMapping("/getAll")
    private List<Announcement> getAll() {
        return announcementService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<Announcement> getById(@PathVariable Long id){
        return announcementService.getById(id);
    }
}
