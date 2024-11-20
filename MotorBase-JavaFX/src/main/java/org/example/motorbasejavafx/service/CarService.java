package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.Car;
import org.example.motorbasejavafx.repository.CarRepository;

import java.io.IOException;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public List<Car> getAll() throws IOException, InterruptedException {
        return carRepository.getAll();
    }

    public Car getById(Long id) throws IOException, InterruptedException {
        return carRepository.getById(id);
    }

    public Car register(Car Car) throws IOException, InterruptedException {
        return carRepository.register(Car);
    }

    public void deleteById(Long id) throws IOException, InterruptedException {
        carRepository.deleteById(id);
    }

    public Car update(Car Car) throws IOException, InterruptedException {
        return carRepository.update(Car);
    }

}
