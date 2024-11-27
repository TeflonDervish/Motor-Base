package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.services.AnnouncementService;
import com.shesterki.Motor_Base_Server.services.CarService;
import com.shesterki.Motor_Base_Server.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@Controller
@AllArgsConstructor
public class CarController {

    private AnnouncementService announcementService;
    private CarService carService;
    private UsersService usersService;

    @GetMapping("/car/{id}")
    public String car(@PathVariable Long id,
                      Model model,
                      @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);

        Announcement announcement = announcementService.getById(id).orElseThrow();
        Car car = announcement.getCar();
        Users users = announcement.getUser();

        model.addAttribute("user_id", users.getId());

        model.addAttribute("announcement_id", announcement.getId());

        model.addAttribute("run", car.getRun());
        model.addAttribute("yearMake", car.getYearMake());
        model.addAttribute("mark", car.getMark());
        model.addAttribute("model", car.getModel());
        model.addAttribute("enginePowers", car.getEnginePowers());
        model.addAttribute("engineVolume", car.getEngineVolume());
        model.addAttribute("color", car.getColor());
        model.addAttribute("gearbox", car.getGearbox());
        model.addAttribute("type", car.getType());
        model.addAttribute("typeBody", car.getTypeBody());

        model.addAttribute("info_car", car.getModel() + " " +
                car.getMark() + " " +
                car.getYearMake());
        model.addAttribute("price", announcement.getPrice());
        model.addAttribute("phoneNumber", users.getPhoneNumber());
        model.addAttribute("name", users.getName());
        model.addAttribute("description", announcement.getDescription());

        if (userDetailsAdapter.getUser().getId() == users.getId()) {
            return "my_announcement";
        } else {
            return "announcement";

        }

    }

    @GetMapping("/create_announcement")
    public String createAnnouncement(Model model,
                                     @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        model.addAttribute("car", new Car());
        return "create_announcement";
    }

    @PostMapping("/create_announcement")
    public String createAnnouncement(Model model,
                                     @ModelAttribute Car car,
                                     @RequestParam("name") String name,
                                     @RequestParam("price") Double price,
                                     @RequestParam("description") String description,
                                     @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        Car newCar = carService.saveCar(car);
        Announcement announcement = new Announcement();
        announcement.setCar(newCar);
        announcement.setPrice(price);
        announcement.setDate(LocalDate.now());
        announcement.setDescription(description);
        announcement.setUser(userDetailsAdapter.getUser());
        announcementService.postAnnouncement(announcement);

        log.info(String.valueOf(car));
        return "redirect:/car/" + announcement.getId();
    }

    @PostMapping("/delete_announcement/{id}")
    public String deleteAnnouncement(@PathVariable Long id,
                                     Model model,
                                     @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {

        model.addAttribute("isAuthenticated", userDetailsAdapter == null);

        Announcement announcement = announcementService.getById(id).orElseThrow();
        announcementService.deleteById(id);
        carService.deleteById(announcement.getCar().getId());
        return "redirect:/main";
    }

    @PostMapping("/add_to_favorite/{announcement_id}")
    public String addToFavorite(@PathVariable Long announcement_id,
                                Model model,
                                @AuthenticationPrincipal UserDetailsAdapter userDetailsAdapter) {
        model.addAttribute("isAuthenticated", userDetailsAdapter == null);
        usersService.AddFavoriteAnnouncement(userDetailsAdapter.getUser().getId(), announcement_id);
        return "redirect:/car/" + announcement_id;
    }

    @PostMapping("/car/delete/{id}")
    public String deleteAnnouncementById(@PathVariable Long id){
        Announcement announcement = announcementService.getById(id).orElseThrow();
        carService.deleteById(announcement.getCar().getId());
        return "redirect:/main";
    }

}
