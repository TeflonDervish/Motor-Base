package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<Car> carList;


    public CarService () {
        carList = new ArrayList<>() {{
            add( new Car() );
            add( new Car() );
            add( new Car() );
        }};
    }

    public Car getCarById(Integer id) {
        return carList.get(id);
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void deleteCar(Integer id) {
        carList.remove(id);
    }



}
