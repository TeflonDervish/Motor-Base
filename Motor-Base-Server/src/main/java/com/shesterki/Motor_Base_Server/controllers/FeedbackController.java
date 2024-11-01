package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.Feedback;
import com.shesterki.Motor_Base_Server.services.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
@AllArgsConstructor
public class FeedbackController {

    private FeedbackService feedbackService;

    @GetMapping("/getAll")
    private List<Feedback> getAll() {
        return feedbackService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<Feedback> getById(@PathVariable Long id){
        return feedbackService.getById(id);
    }
}
