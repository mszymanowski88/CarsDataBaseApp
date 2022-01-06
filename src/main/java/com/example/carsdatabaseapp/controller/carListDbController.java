package com.example.carsdatabaseapp.controller;

import com.example.carsdatabaseapp.dao.CarDaoImpl;
import com.example.carsdatabaseapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class carListDbController implements WebMvcConfigurer {

    private final CarDaoImpl carDaoImpl;


    @Autowired
    public carListDbController(CarDaoImpl carDaoImpl) {
        this.carDaoImpl = carDaoImpl;


    }


    @GetMapping("/carsDb")
    public String showCarsDb(Model model) {


        model.addAttribute("db", carDaoImpl.showListOfCars());
        model.addAttribute("newCar", carDaoImpl.newCarToAdd(new Car()));
        model.addAttribute("carToRemove", removeCar(new Car()));
        model.addAttribute("listOfCarsByYear", carDaoImpl.listOfProductionYears());
        model.addAttribute("listOfCarsByBrand", carDaoImpl.listOfBrands());

        return "carsDb";
    }

    @GetMapping("/carsbyear/{productionYear}")
    public String showbyYear(@PathVariable int productionYear, Model model) {
        model.addAttribute("listOfCarsByYear", carDaoImpl.getCarFromListByYear(productionYear));


        return "carsbyear";
    }


    @GetMapping("/carsbyearrange")
    public String addCar(
            @RequestParam(value = "input", required = false) Integer input,
            @RequestParam(value = "input2", required = false) Integer input2, Model model

    ) {

        model.addAttribute("carsbyyear", carDaoImpl.getCarFromListFromYearRange(input, input2));

        return "carsbyearrange";

    }


    @GetMapping("/carsbybrand/{brand}")
    public String showbyBrand(@PathVariable String brand, Model model) {
        model.addAttribute("listOfCarsByBrand", carDaoImpl.getCarFromListByBrand(brand));


        return "carsbybrand";
    }


    @PostMapping("/delete")
    public String removeCar(Car car1) {
        carDaoImpl.deleteCar(car1.getId());
        return "redirect:/carsDb";


    }


    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {


        carDaoImpl.save(car.getId(), car.getBrand(), car.getModel(), car.getColor(), car.getProductionYear());


        return "redirect:/carsDb";

    }

    @PostMapping("/create")
    public String createNewDb() {

        carDaoImpl.initDB();

        return "redirect:/carsDb";

    }

    @PostMapping("/deletedatabase")
    public String removeDb() {
        carDaoImpl.deleteDatabase();

        return "redirect:/error";


    }


}

