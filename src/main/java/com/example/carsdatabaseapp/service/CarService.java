package com.example.carsdatabaseapp.service;

import com.example.carsdatabaseapp.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById (long id);

    boolean modifyCar(Car car);

    boolean removeCar(long id);

    boolean addCar(Car car);

}
