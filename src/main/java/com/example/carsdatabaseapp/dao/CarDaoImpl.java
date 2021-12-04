package com.example.carsdatabaseapp.dao;

import com.example.carsdatabaseapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
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

//  @EventListener(ApplicationReadyEvent.class)
//    public void initDB()
//    {
//        String sql = "CREATE TABLE cars (car_id int AUTO_INCREMENT  primary key NOT NULL , brand varchar(255) NOT NULL , model varchar(255) NOT NULL , color varchar(255) NOT NULL , year int NOT NULL )";
//        getJdbcTemplate().update(sql);
//
//    }

    @Override
    public void save(long id, String brand, String model, String color, int productionYear) {

        if (productionYear > 2000) {
            String sql = "INSERT INTO cars VALUES(?,?,?,?,?)";
            jdbcTemplate.update(sql, id, brand, model, color, productionYear);
        } else {

            System.out.println("error");
        }


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


}
