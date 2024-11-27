package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.services.UserFeedbackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
public class FeedbackController {

    private UserFeedbackService userFeedbackService;

    @PostMapping("/create-feedback/{id}")
    public void createFeedback(@PathVariable Long id,
                                 @RequestParam("otziv") String text,
                                 @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

    }
}
