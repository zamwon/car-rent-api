package pl.karnecki.carrentalapp;

import org.springframework.stereotype.Repository;
import pl.karnecki.carrentalapp.entity.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    public List<Car> myCars() {


        var myAllCars = new ArrayList<Car>();

        var corollaWagon = Car.builder()
                .id(1L)
                .manufacturer("Toyota")
                .model("Corolla")
                .body("wagon")
                .productionYear(LocalDate.of(2020, 12, 1))
                .engineCapacity("1800")
                .horsePower(122)
                .color("Black")
                .pricePerDay(110)
                .build();
        myAllCars.add(corollaWagon);

        var corollaSedan = Car.builder()
                .id(2L)
                .manufacturer("Toyota")
                .model("Corolla")
                .body("sedan")
                .productionYear(LocalDate.of(2020, 12, 1))
                .engineCapacity("1800")
                .horsePower(122)
                .color("Silver")
                .pricePerDay(120)
                .build();
        myAllCars.add(corollaSedan);

        var prius = Car.builder()
                .id(3L)
                .manufacturer("Toyota")
                .model("Prius")
                .body("sedan")
                .productionYear(LocalDate.of(2020, 12, 1))
                .engineCapacity("1800")
                .horsePower(130)
                .color("White")
                .pricePerDay(130)
                .build();
        myAllCars.add(prius);

        var teslaX = Car.builder()
                .id(4L)
                .manufacturer("Tesla")
                .model("X")
                .body("SUV")
                .productionYear(LocalDate.of(2020, 12, 1))
                .engineCapacity("Electric")
                .horsePower(575)
                .color("Silver")
                .pricePerDay(250)
                .build();
        myAllCars.add(teslaX);

        return myAllCars;
    }
}
