package com.example.carsdatabaseapp.dao;

import com.example.carsdatabaseapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class CarDaoImpl implements CarDao {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;


    }

    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);

    }

    @Override
    public Car newCarToAdd(Car car1) {
        Car carToAdd = new Car(car1.getId(), car1.getBrand(), car1.getModel(), car1.getColor(), car1.getProductionYear());

        return carToAdd;

    }

    @Override
    public void initDB() {
        String sql = "CREATE TABLE cars (car_id int AUTO_INCREMENT  primary key NOT NULL , brand varchar(255) NOT NULL , model varchar(255) NOT NULL , color varchar(255) NOT NULL , year int NOT NULL )";
        getJdbcTemplate().update(sql);

    }

    @Override
    public void save(long id, String brand, String model, String color, int productionYear) {


        String sql = "INSERT INTO cars VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, id, brand, model, color, productionYear);


    }

    @Override
    public List listOfProductionYears() {
        Set<Integer> list = new HashSet<>();


        for (Car car : showListOfCars()) {

            list.add(car.getProductionYear());
        }

        List<Integer> sortdedList = new ArrayList<>(list);
        Collections.sort(sortdedList);


        return sortdedList;
    }

    @Override
    public List<String> listOfBrands() {
        Set<String> list = new HashSet<>();


        for (Car car : showListOfCars()) {

            list.add(car.getBrand());
        }
        List<String> sortdedList = new ArrayList<>(list);
        Collections.sort(sortdedList);


        return sortdedList;
    }


    @Override
    public void deleteCar(long id) {

        String sql = "DELETE FROM cars WHERE car_id=?";
        jdbcTemplate.update(sql, id);

    }

    private List<Car> maps(String sql) {


        List<Car> dbCarList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> dbCarList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("brand")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))
        )));

        return dbCarList;


    }

    @Override
    public List<Car> getCarFromListFromYearRange(int year1, int year2) {


        String sql = "SELECT * FROM cars WHERE year BETWEEN " + year1 + " AND " + year2;

        return maps(sql);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        System.out.println(getCarFromListFromYearRange(2019, 2022));

    }


    @Override
    public List<Car> getCarFromListByYear(int productionYear) {

        String sql = "SELECT * FROM cars WHERE year=" + productionYear;

        return maps(sql);
    }


    @Override
    public List<Car> showListOfCars() {

        String sql = "SELECT *  FROM cars ORDER BY car_id";

        return maps(sql);
    }

    @Override
    public List<Car> getCarFromListByBrand(String brand) {

        String sql = "SELECT * FROM cars WHERE brand='" + brand + "'";

        return maps(sql);
    }

    @Override
    public void deleteDatabase() {


        String sql = "DROP TABLE IF EXISTS cars";

        jdbcTemplate.update(sql);
    }


}
