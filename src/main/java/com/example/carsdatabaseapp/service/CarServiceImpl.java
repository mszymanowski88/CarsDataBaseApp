package com.example.carsdatabaseapp.service;

import com.example.carsdatabaseapp.model.Car;
import com.example.carsdatabaseapp.model.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    CarList listOfCars;

    @Autowired
    public CarServiceImpl(CarList listOfCars) {
        this.listOfCars = listOfCars;
    }

    @Override
    public List<Car> getCars() {
        return listOfCars.getCarList();
    }

    @Override
    public Optional<Car> getCarById(long id) {

        return listOfCars.getCarList().stream().filter(car -> car.getId() == id ).findFirst();


    }

    @Override
    public boolean modifyCar(Car car) {

        Optional<Car> isCarPresent = getCarById(car.getId());



        if (isCarPresent.isPresent()) {

            listOfCars.getCarList().remove(isCarPresent.get());
            Car updatedCar = new Car(car.getId(), car.getBrand(), car.getModel(), car.getColor(), car.getProductionYear());
            updatedCar.setId(isCarPresent.get().getId());

            return listOfCars.getCarList().add(car);


        } else
            return false;


    }

    @Override
    public boolean removeCar(long id) {

        Optional<Car> carToRemove = getCarById(id);

        return carToRemove.map(car -> listOfCars.getCarList().remove(car)).orElse(false);

    }

    @Override
    public boolean addCar(Car car) {


        return  listOfCars.getCarList().add(car);

    }
}
