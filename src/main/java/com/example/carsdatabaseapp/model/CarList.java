package com.example.carsdatabaseapp.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarList {

    private List<Car> carList;



    public CarList() {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "VW","GOlF", "BLACK",2019));
        carList.add(new Car(2L, "VW","Arteon", "YELLOW",2018));
        carList.add(new Car(3L, "Nissan","Almera", "WHITE",2020));
        carList.add(new Car(4L,"BMW","1", "YELLOW",2021));
        carList.add(new Car(5L,"Toyota","Corolla", "BLACK",2019));
        carList.add(new Car(6L,"Toyota","Avensis", "WHITE",2017));

    }


    public List<Car> getCarList()
    {
        return carList;
    }


}
