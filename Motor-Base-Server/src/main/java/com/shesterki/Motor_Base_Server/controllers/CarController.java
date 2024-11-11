package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.services.CarService;
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
public class CarController {

    private CarService carService;

    @GetMapping("/getAll")
    private List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<Car> getById(@PathVariable Long id){
        return carService.getById(id);
    }
}

