package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class CarService {

    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }
}
