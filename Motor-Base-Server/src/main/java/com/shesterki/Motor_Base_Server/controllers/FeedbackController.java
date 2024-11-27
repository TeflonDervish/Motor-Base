package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.UserFeedback;
import com.shesterki.Motor_Base_Server.services.UserFeedbackService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
public class FeedbackController {

    private UserFeedbackService userFeedbackService;
    private UsersService usersService;

    @PostMapping("/feedback/{id}")
    public String createFeedback(Model model,
                                 @PathVariable Long id,
                                 @RequestParam("description") String description,
                                 @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter){

        model.addAttribute("isAuthenticated", userDetailsAdapter==null);

        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setUserTo(usersService.getById(id).orElseThrow());
        userFeedback.setUserFrom(userDetailsAdapter.getUser());
        userFeedback.setComment(description);
        userFeedbackService.postFeedback(userFeedback);
        return "redirect:/user/" + id;

    }
}
