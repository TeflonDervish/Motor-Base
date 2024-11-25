package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @GetMapping("/getAll")
    private ResponseEntity<List<Car>> getAll() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<Car>> getById(@PathVariable Long id){
        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    private ResponseEntity<Car> postCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.saveCar(car), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.updateCar(car), HttpStatus.OK);
    }
}

