package com.example.carsdatabaseapp.model;

public class Car {

    String brand;
    int productionYear;
    String model;
   String color;
    long id;

    public Car() {
    }

    public Car(long id, String brand, String model, String color, int productionYear) {
        this.id = id;
        this.brand = brand;

        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", id=" + id +
                '}';
    }
}
