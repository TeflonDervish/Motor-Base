package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.Feedback;
import com.shesterki.Motor_Base_Server.services.FeedbackService;
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

    private FeedbackService feedbackService;

    @GetMapping("/getAll")
    private ResponseEntity<List<Feedback>> getAll() {
        return new ResponseEntity<>(feedbackService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<Feedback>> getById(@PathVariable Long id){
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    private ResponseEntity<Feedback> postFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity<>(feedbackService.postFeedback(feedback), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback){
        return new ResponseEntity<>(feedbackService.updateFeedback(feedback), HttpStatus.OK);
    }
}
