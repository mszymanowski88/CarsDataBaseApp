package com.example.carsdatabaseapp.dao;

import com.example.carsdatabaseapp.model.Car;

import java.util.List;

public interface CarDao {

    void save(long id, String brand, String model, String color, int productionYear);

    List<Car> showListOfCars();

    void deleteCar(long id);

    public List<Car> getCarFromListByYear(int productionYear);

    public List<Car> getCarFromListByBrand(String brand);

    public List listOfProductionYears();
}
