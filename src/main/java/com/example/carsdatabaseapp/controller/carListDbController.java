package com.example.carsdatabaseapp.controller;

import com.example.carsdatabaseapp.dao.CarDaoImpl;
import com.example.carsdatabaseapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class carListDbController {

    private CarDaoImpl carDaoImpl;


    @Autowired
    public carListDbController(CarDaoImpl carDaoImpl) {
        this.carDaoImpl = carDaoImpl;


    }

    @GetMapping("/carsDb")
    public String showCarsDb(Model model) {


        model.addAttribute("db", carDaoImpl.showListOfCars());
        model.addAttribute("newCar", newCarToAdd(new Car()));
        model.addAttribute("carToRemove", removeCar1(new Car()));
        model.addAttribute("listOfCarsByYear", carDaoImpl.listOfProductionYears());
        model.addAttribute("listOfCarsByBrand", carDaoImpl.listOfBrands());

        return "carsDb";
    }

    @GetMapping("/carsbyear/{productionYear}")
    public String showbyYear(@PathVariable int productionYear, Model model) {
        model.addAttribute("listOfCarsByYear1", carDaoImpl.getCarFromListByYear(productionYear));


        return "carsbyear";
    }

    @GetMapping("/carsbybrand/{brand}")
    public String showbyBrand(@PathVariable String  brand, Model model) {
        model.addAttribute("listOfCarsByBrand", carDaoImpl.getCarFromListByBrand(brand));


        return "carsbybrand";
    }


    public Car newCarToAdd(Car car1) {
        Car carToAdd = new Car(car1.getId(), car1.getBrand(), car1.getModel(), car1.getColor(), car1.getProductionYear());

        return carToAdd;

    }


    @PostMapping("/delete")
    public String removeCar1(Car car1) {
        carDaoImpl.deleteCar(car1.getId());
        return "redirect:/carsDb";


    }

//
//    @PostMapping("/carsDb/{productionYear}")
//    public String getCarByTheYear11(@ModelAttribute int productionYear) {
//
//
//        return "redirect:/carsbyear";
//
//    }


    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {

        carDaoImpl.save(car.getId(), car.getBrand(), car.getModel(), car.getColor(), car.getProductionYear());


        return "redirect:/carsDb";

    }
}

