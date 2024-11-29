package com.shesterki.Motor_Base_Server.controllers;


import com.shesterki.Motor_Base_Server.enums.Roles;
import com.shesterki.Motor_Base_Server.model.*;
import com.shesterki.Motor_Base_Server.model.dto.LoginForm;
import com.shesterki.Motor_Base_Server.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
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
                             @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter,
                             MultipartFile file) throws IOException {
        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageData(file.getBytes());
        user.setImage(imageEntity);
        usersService.updateUser(user);
        return "redirect:/user/" + user.getId();
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable Long id,
                                 @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        if (id != userDetailsAdapter.getUser().getId()) usersService.deleteById(id);
        return "redirect:/admin/users";
    }


    @GetMapping("/user/change/{id}")
    public String changeUser(@PathVariable Long id,
                             Model model,
                             @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        Users user = usersService.getById(id).orElseThrow();
        model.addAttribute("user", user);

        return "admin_edit_users";
    }

    @PostMapping("/user/change/{id}")
    public String changeUser(@PathVariable Long id,
                             @ModelAttribute Users user) {
        System.out.println(user);
        usersService.updateUser(user);
        return "redirect:/admin/main";
    }

    @GetMapping("/admin/user/search")
    public String searchUser(
        Model model,
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "surname", required = false) String surname,
        @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "email", required = false) String email,
        @RequestParam(value = "city", required = false) String city,
        @RequestParam(value = "birthday", required = false) LocalDate birthday
    ){

        Set<Users> users = usersService.getByFilter(
                name,
                surname,
                phone,
                email,
                city,
                birthday
        );
        model.addAttribute("users", users);

        return "admin_main_users";
    }
}
