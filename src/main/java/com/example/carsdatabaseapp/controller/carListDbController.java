package com.example.carsdatabaseapp.controller;

import com.example.carsdatabaseapp.dao.CarDaoImpl;
import com.example.carsdatabaseapp.model.Car;
import com.example.carsdatabaseapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class carListDbController {

    CarDaoImpl carDaoImpl;
    CarService carService;
    int value = 0;

    Car carClass =  new Car();




    @Autowired
    public carListDbController(CarDaoImpl carDaoImpl, CarService carService) {
        this.carDaoImpl = carDaoImpl;
        this.carService = carService;

    }

    @GetMapping("/carsDb")
    public String showCarsDb(Model model)
    {
//int value = 2018;
int value;

        model.addAttribute("db",carDaoImpl.showListOfCars());
        model.addAttribute("newCar",newCarToAdd(new Car()));
        model.addAttribute("carToRemove",removeCar1(new Car()));
        model.addAttribute("listOfCarsByYear12", carDaoImpl.listOfProductionYears());
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYearFinal(productionYear));


//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));

//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(carClass));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(carClass));
        return "carsDb";
    }
//
//    @GetMapping("/carsDb")
//    public String showCarsDbYear(Model model, @PathVariable int productionYear)
//    {
//
//
//
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYearFinal(productionYear));
//
//
////        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));
//
////        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));
////        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(carClass));
////        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(carClass));
//        return "carsDb";
//    }


    @GetMapping("/carsDb/{productionYear}")
//    @GetMapping("/carsDb")
    public String showCarsDbYear1(@PathVariable int productionYear, Model model)

    {
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYearFinal(productionYear));
//        model.addAttribute("listOfCarsByYear1",carDaoImpl.getCarFromListByYearFinal(productionYear));
        model.addAttribute("listOfCarsByYear12",carDaoImpl.showListOfCars());

//        for(Car car : carDaoImpl.getCarFromListByYcear(carClass) )
//        {
//            System.out.println("from class");
//            System.out.println(car);
//        }

//
//        model.addAttribute("db",carDaoImpl.showListOfCars());
//        model.addAttribute("newCar",newCarToAdd(new Car()));
//        model.addAttribute("carToRemove",removeCar1(new Car()));
//        model.addAttribute("findByYear",getCarByTheYear(value) );
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYear(value));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarByYear(value));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));
//        model.addAttribute("listOfCarsByYear",getCarByTheYear11(new Car()));

        return "carsbyear";
    }


    @GetMapping("/carsbyear/{productionYear}")
//    @GetMapping("/carsDb")
    public String showbyYear(@PathVariable int productionYear, Model model)

    {
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYearFinal(productionYear));
        model.addAttribute("listOfCarsByYear1",carDaoImpl.getCarFromListByYearFinal(productionYear));

//        for(Car car : carDaoImpl.getCarFromListByYcear(carClass) )
//        {
//            System.out.println("from class");
//            System.out.println(car);
//        }

//
//        model.addAttribute("db",carDaoImpl.showListOfCars());
//        model.addAttribute("newCar",newCarToAdd(new Car()));
//        model.addAttribute("carToRemove",removeCar1(new Car()));
//        model.addAttribute("findByYear",getCarByTheYear(value) );
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYear(value));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarByYear(value));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(new Car()));
//        model.addAttribute("listOfCarsByYear",getCarByTheYear11(new Car()));

        return "carsbyear";
    }


    public Car newCarToAdd(Car car1)
    {
        Car carToAdd = new Car(car1.getId(), car1.getBrand(),car1.getModel(),car1.getColor(),car1.getProductionYear());

        return carToAdd;

    }


    @PostMapping("/delete")
//    public String removeCar(@PathVariable long id)
    public String removeCar1(Car car1)
    {
        carDaoImpl.deleteCar(car1.getId());
        return "redirect:/carsDb";
//        if()
//        {
//            return "redirect:/carsDb";
//        }

//        else
//            return  "redirect:/error";


    }




//    @PostMapping("/carsbyear")
//    public String getCarByTheYear11(@ModelAttribute Car car1 ) {
//
//
////        if (carById.isPresent()) {
//
//
////           carDaoImpl.getCarFromListByYear(productionYear);
//        carDaoImpl.getCarFromListByYcear(car1);
//
//        for(Car car2 :carDaoImpl.getCarFromListByYcear(car1) )
//        {
//
//            System.out.println("11");
//            System.out.println(car2);
//        }
//        return "redirect:/carsDb";
////        return  "carsbyear";
////        } else {
////            return "redirect:/error";
////        }
//    }


//    @PostMapping("/carsbyear/{productionYear}")
    @PostMapping("/carsDb/{productionYear}")
    public String getCarByTheYear11(@ModelAttribute int productionYear ) {


//        if (carById.isPresent()) {


//           carDaoImpl.getCarFromListByYear(productionYear);
//        carDaoImpl.getCarFromListByYearFinal(productionYear);
//
//        for(Car car2 :carDaoImpl.getCarFromListByYearFinal(productionYear) )
//        {
//
//            System.out.println("11");
//            System.out.println(car2);
//        }
//        return "redirect:/carsDb";
        return  "redirect:/carsbyear";
//        } else {
//            return "redirect:/error";
//        }
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void testtest()
//    {
//
//        System.out.println(carDaoImpl.getCarFromListByYearFinal(2011));
//    }


//    @PostMapping("/carsbyear")
//    public String getCarByTheYear11(@ModelAttribute int productionYear ) {
//
//
////        if (carById.isPresent()) {
//
//
////           carDaoImpl.getCarFromListByYear(productionYear);
//        carDaoImpl.getCarFromListByYearFinal(productionYear);
//
//        for(Car car2 :carDaoImpl.getCarFromListByYearFinal(productionYear) )
//        {
//
//            System.out.println("11");
//            System.out.println(car2);
//        }
//        return "redirect:/carsDb";
////        return  "carsbyear";
////        } else {
////            return "redirect:/error";
////        }
//    }




    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
//    public String addCar(@ModelAttribute long id, String brand, int productionYear, String model, String color) {

        carDaoImpl.saveCar(car.getId(),car.getBrand(),car.getModel(),car.getColor(),car.getProductionYear());



        return "redirect:/carsDb";

    }


//////    @PostMapping("/delete/{id}")
//    @PostMapping("/delete/{id}")
////    public String removeCar(@PathVariable long id)
//    public String removeCar(@PathVariable int id)
//    {
//        carDaoImpl.deleteCar(id);
//        return "redirect:/carsDb";
////        if()
////        {
////            return "redirect:/carsDb";
////        }
//
////        else
////            return  "redirect:/error";
//
//
//    }


//    @PostMapping("/carsbyear/{productionYear}")
//    public String getCarByTheYear(@ModelAttribute Car car, @PathVariable long id ) {
//
//
////        if (carById.isPresent()) {
//
//
////           carDaoImpl.getCarFromListByYear(productionYear);
//   carDaoImpl.getCarFromListByYcear(car);
//            return  "carsbyear";
////        } else {
////            return "redirect:/error";
////        }
//    }


//    @PostMapping("/carsbyear/{productionYear}")
//    public String getCarByTheYearFinal(@ModelAttribute Car car ) {
//
//
////        if (carById.isPresent()) {
//
//
////           carDaoImpl.getCarFromListByYear(productionYear);
//        carDaoImpl.getCarFromListByYcear(car);
//        return  "carsbyear";
////        } else {
////            return "redirect:/error";
////        }
//    }



//    @GetMapping("/carsbyear/{productionYear}")
////    @GetMapping("/carsbyear")
//    public String singlePathVariable(@PathVariable int productionYear, Model model) {
//
//
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYear(productionYear));
//
//        return  "redirect:/carsbyear";
//    }
//
//    @GetMapping("/carsDb/{productionYear}")???
//    public String getCarByYear(@PathVariable Car car, Model model) {
////        Optional<Car> carById = carService.getCarById(productionYear);
////
////        if (carById.isPresent()) {
////        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYear(productionYear));
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYcear(car));
////        model.addAttribute("listOfCarsByYear1",getCarByTheYear(productionYear,productionYear));
//            return  "redirect:/carsbyear/{productionYear}";
////        } else {
////            return "redirect:/error";
////        }
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void testCarBY()
//    {
//
//        for(int i : carDaoImpl.listOfProductionYears())
//        {
//            System.out.println(i);
//        }
//
//        System.out.println(carDaoImpl.showListOfCars());
//    }

//    @GetMapping("/carsbyear")
//    public String findYear(@RequestParam("people") String thePeople, Model theModel) {
//        List<Car> cars = carDaoImpl.getCarByYear1(2018);
//        theModel.addAttribute("thePeople", cars);
//        return "listAll";
//    }

}

//    @GetMapping("/carsbyear/{productionYear}")
////    @GetMapping("/carsbyear")
//    public String singlePathVariable(@PathVariable("productionYear") String productionYear, Model model) {
//
//
//        model.addAttribute("listOfCarsByYear",carDaoImpl.getCarFromListByYear(productionYear));
//
//        return  "redirect:carsbyear";
//    }}


//    @PostMapping("/find/{value}")
////    public String removeCar(@PathVariable long id)
//    public String findByYear(@RequestParam String value)
//    {
//        model.addAttribute("findByYear",carDaoImpl.getCarFromListByYear(value) );
//
//        return "redirect:/carsDb";
////        if()
////        {
////            return "redirect:/carsDb";
////        }
//
////        else
////            return  "redirect:/error";
//
//
//    }

//    @PostMapping("/find/{value}")
////    public String removeCar(@PathVariable long id)
//    public String findByYear1(@RequestParam String value, Model model)
//    {
//        model.addAttribute("findByYear",carDaoImpl.getCarFromListByYear(value) );
//
//        return "redirect:/carsDb";
////        if()
////        {
////            return "redirect:/carsDb";
////        }
//
////        else
////            return  "redirect:/error";
//
//
//    }
//    @PostMapping("/find/{year}")
////    public String removeCar(@PathVariable long id)
//    public String removeCar(@PathVariable String year)
//    {
//        carDaoImpl.getCarFromListByYear(year);
//        return "redirect:/carsDb";
////        if()
////        {
////            return "redirect:/carsDb";
////        }
//
////        else
////            return  "redirect:/error";
//
//
//    }


//    private Predicate<Car> filterEmployees(CarDaoImpl carDaoImpl) {
//        if (carDaoImpl.showListOfCars() == null ) {
//            return employee -> true;
//        }
//
//        String value =
//
//        return employee -> employee.getName()
//                .toLowerCase()
//                .contains(value)
//                || employee.getPosition()
//                .toLowerCase()
//                .contains(value)
//                || employee.getOffice()
//                .toLowerCase()
//                .contains(value);
//    }


