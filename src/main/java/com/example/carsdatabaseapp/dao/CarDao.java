package com.example.carsdatabaseapp.dao;

import com.example.carsdatabaseapp.model.Car;

import java.util.List;

public interface CarDao {

    void save(long id, String brand, String model, String color, int productionYear);

    public void initDB();

    List<Car> showListOfCars();

    void deleteCar(long id);

     List<Car> getCarFromListByYear(int productionYear);

     List<Car> getCarFromListByBrand(String brand);

     List listOfProductionYears();

    public List<String> listOfBrands();

     Car newCarToAdd(Car car1);
}
