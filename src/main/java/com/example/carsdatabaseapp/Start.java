package com.example.carsdatabaseapp;

import com.example.carsdatabaseapp.dao.CarDaoImpl;
import org.springframework.stereotype.Component;

@Component
public class Start {

    CarDaoImpl carDaoImpl;


    public Start(CarDaoImpl carDaoImpl) {
        this.carDaoImpl = carDaoImpl;

    }
}
