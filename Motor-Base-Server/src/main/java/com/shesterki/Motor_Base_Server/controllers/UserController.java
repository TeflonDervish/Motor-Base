package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.UserFeedback;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.model.dto.LoginForm;
import com.shesterki.Motor_Base_Server.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {

    private UsersService usersService;
    private UserFeedbackService feedbackService;
    private AnnouncementService announcementService;

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        if (userDetailsAdapter != null) {
            return "redirect:/user/" + userDetailsAdapter.getUser().getId();
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id,
                       Model model,
                       @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);

        Users users = usersService.getById(id).orElseThrow();
        log.info(String.valueOf(users));

        List<Announcement> announcements = announcementService.getByUserId(users.getId());
        model.addAttribute("announcements", announcements);

        Set<Announcement> favorite_announcement = usersService.getFavoriteAnnouncement(userDetailsAdapter.getUser().getId());
        model.addAttribute("favorite_announcement", favorite_announcement);

        model.addAttribute("user", users);

        model.addAttribute("user_id", users.getId());

        List<UserFeedback> userFeedbacks = feedbackService.getByUserToId(users.getId());
        model.addAttribute("feedback", userFeedbacks);

        if (userDetailsAdapter.getUser().getId() == id) {
            return "my_account";
        } else {

            return "user_account";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users user) {
        user.setUserRole(Roles.USER);
        usersService.saveUser(user);
        log.info(String.valueOf(user));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginForm loginForm,
                            Model model,
                            @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        log.info(String.valueOf(loginForm));
        return "redirect:/main";
    }

    @PostMapping("/change_user")
    public String changeUser(@ModelAttribute Users user,
                             Model model,
                             @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        log.info(String.valueOf(user));
        usersService.updateUser(user);
        return "redirect:/user/" + user.getId();
    }
}
