package com.example.carsdatabaseapp.dao;

import com.example.carsdatabaseapp.model.Car;
import com.example.carsdatabaseapp.model.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;
    CarList carList;
    DataSource dataSource;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate, CarList carList, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.carList = carList;
        this.dataSource = dataSource;


    }

    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(dataSource);

    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void initDB()
//    {
//        String sql = "CREATE TABLE cars (car_id int, brand varchar(255), model varchar(255), color varchar(255) , year int) ";
//        getJdbcTemplate().update(sql);
//
//    }




    @Override
//    @EventListener(ApplicationReadyEvent.class)
    public void save(long id, String brand, String model, String color, int productionYear) {

     String sql = "INSERT INTO cars VALUES(?,?,?,?,?)";
     for(Car car : carList.getCarList())

     {
         jdbcTemplate.update(sql,car.getId(),car.getBrand(), car.getModel(), car.getColor(), car.getProductionYear());


     }


//    @EventListener(ApplicationReadyEvent.class)




    }
//    @Query(value = "select * from Car  ", nativeQuery = true)
//    List<Car> findByKeyword(@Param("keyword") String keyword);

public void saveCar(long id, String brand, String model, String color, int productionYear) {

    String sql = "INSERT INTO cars VALUES(?,?,?,?,?)";

    jdbcTemplate.update(sql, id, brand, model, color, productionYear);

}

    void test (long id)
    {

        String sql = "SELECT *  FROM cars";

        jdbcTemplate.update(sql, id);
    }


    public List<Car> showListOfCars()
    {
        List<Car> dbCarList = new ArrayList<>();
        String sql = "SELECT *  FROM cars";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> dbCarList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("brand")),

                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))


        )));

        return  dbCarList;
    }

    public  List<Car>  getCarFromListByYcear(Car car)
    {


        int topass = car.getProductionYear();

        List<Car> dbCarList = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE year="+topass;
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> dbCarList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("brand")),

                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))


        )));

        return  dbCarList;
    }

    public  List<Car>  getCarFromListByYearFinal(int productionYear)
    {


        int topass = productionYear;

        List<Car> dbCarList = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE year="+topass;
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> dbCarList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("brand")),

                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))


        )));

        return  dbCarList;
    }


//    public  Car searchTheYear (Car car)
//    {
//
//
//        int topass = car.getProductionYear();
//
//        List<Car> dbCarList = new ArrayList<>();
//        String sql = "SELECT * FROM cars WHERE year="+topass;
//        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.stream().forEach(element -> dbCarList.add(new Car(
//                Long.parseLong(String.valueOf(element.get("car_id"))),
//                String.valueOf(element.get("brand")),
//
//                String.valueOf(element.get("model")),
//                String.valueOf(element.get("color")),
//                Integer.parseInt(String.valueOf(element.get("year")))
//
//
//        )));
//
//        return  dbCarList;
//    }


//    public  List<Car>  getCarFromListByYcear1()
//    {
//
//
//
//
//        List<Car> dbCarList = new ArrayList<>();
//        String sql = "SELECT * FROM cars WHERE year="+2011;
//        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.stream().forEach(element -> dbCarList.add(new Car(
//                Long.parseLong(String.valueOf(element.get("car_id"))),
//                String.valueOf(element.get("brand")),
//
//                String.valueOf(element.get("model")),
//                String.valueOf(element.get("color")),
//                Integer.parseInt(String.valueOf(element.get("year")))
//
//
//        )));
//
//        return  dbCarList;
//    }

//    public  List<Car>  getCarFromListByYcear(Car car)
//    {
//
//
//        int topass = car.getProductionYear();
//
//        List<Car> dbCarList = new ArrayList<>();
//        String sql = "SELECT * FROM cars WHERE year="+topass;
//        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.stream().forEach(element -> dbCarList.add(new Car(
//                Long.parseLong(String.valueOf(element.get("car_id"))),
//                String.valueOf(element.get("brand")),
//
//                String.valueOf(element.get("model")),
//                String.valueOf(element.get("color")),
//                Integer.parseInt(String.valueOf(element.get("year")))
//
//
//        )));
//
//        return  dbCarList;
//    }




//    public  List<Car>  getCarFromList( )
//    {
//        List<Car> dbCarList = new ArrayList<>();
//        String sql = "SELECT * FROM cars WHERE   ";
//        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.stream().forEach(element -> dbCarList.add(new Car(
//                Long.parseLong(String.valueOf(element.get("car_id"))),
//                String.valueOf(element.get("brand")),
//
//                String.valueOf(element.get("model")),
//                String.valueOf(element.get("color")),
//                Integer.parseInt(String.valueOf(element.get("year")))
//
//
//        )));
//
//        return  dbCarList;
//    }


//    String sql = "INSERT INTO cars VALUES(?,?,?,?,?)";
//
//    jdbcTemplate.update(sql, id, brand, model, color, productionYear);
//    public  List<Car>  getCarFromListByYcear(int year)
//    {
//
//
//       int topass = year;
//
//        List<Car> dbCarList = new ArrayList<>();
//        String sql = "SELECT * FROM cars WHERE year="+topass;
//        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.stream().forEach(element -> dbCarList.add(new Car(
//                Long.parseLong(String.valueOf(element.get("car_id"))),
//                String.valueOf(element.get("brand")),
//
//                String.valueOf(element.get("model")),
//                String.valueOf(element.get("color")),
//                Integer.parseInt(String.valueOf(element.get("year")))
//
//
//        )));
//
//        return  dbCarList;
//    }




//@EventListener(ApplicationReadyEvent.class)
//    public void showCars()
//    {
//        for(Car car : getCarFromListByYear())
//        {
//
//            System.out.println(car);
//        }
//
//    }

    @Override
//    @RequestMapping(value="/carsDb")
    public void deleteCar(long id) {

        String sql ="DELETE FROM cars WHERE car_id=?";
                jdbcTemplate.update(sql, id);
        System.out.println("usuniete");

    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void deleteCar1(long id) {
//
//        id = 1;
//
//        String sql ="DELETE FROM cars WHERE car_id=?" ;
//        jdbcTemplate.update(sql, id);
//
//    }




    public Optional<Car> getCarByYear(int year) {

        System.out.println("Year :"+ year);
        return carList.getCarList()
                .stream()
                .filter(car -> car.getProductionYear() == year)
                .findAny();
    }

    public Car getCarByYear1(int year) {

        System.out.println("Year :"+ year);
        return carList.getCarList()
                .stream()
                .filter(car -> car.getProductionYear() == year)
                .findFirst().get();
    }





}
