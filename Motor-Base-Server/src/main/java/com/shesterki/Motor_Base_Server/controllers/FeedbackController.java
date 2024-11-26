package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.UserFeedback;
import com.shesterki.Motor_Base_Server.services.UserFeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
@AllArgsConstructor
public class FeedbackController {

    private UserFeedbackService feedbackService;

    @GetMapping("/getAll")
    private ResponseEntity<List<UserFeedback>> getAll() {
        return new ResponseEntity<>(feedbackService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<UserFeedback>> getById(@PathVariable Long id){
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    private ResponseEntity<UserFeedback> postFeedback(@RequestBody UserFeedback feedback) {
        return new ResponseEntity<>(feedbackService.postFeedback(feedback), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<UserFeedback> updateFeedback(@RequestBody UserFeedback feedback){
        return new ResponseEntity<>(feedbackService.updateFeedback(feedback), HttpStatus.OK);
    }
}
