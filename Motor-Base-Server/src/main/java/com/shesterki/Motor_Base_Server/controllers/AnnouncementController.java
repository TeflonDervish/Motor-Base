package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcement")
@AllArgsConstructor
public class AnnouncementController{

    private AnnouncementService announcementService;

    @GetMapping("/getAll")
    private ResponseEntity<List<Announcement>> getAll() {
        return new ResponseEntity<>(announcementService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<Announcement>> getById(@PathVariable Long id){
        return new ResponseEntity<>(announcementService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    private ResponseEntity<Announcement> saveAnnouncement(@RequestBody Announcement announcement) {
        return new ResponseEntity<>(announcementService.postAnnouncement(announcement), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        announcementService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<Announcement> updateAnnouncement(Announcement announcement) {
        return new ResponseEntity<>(announcementService.updateAnnouncement(announcement), HttpStatus.OK);
    }
}
