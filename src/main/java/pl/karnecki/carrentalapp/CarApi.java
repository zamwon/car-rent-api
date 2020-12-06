package pl.karnecki.carrentalapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.carrentalapp.entity.Car;

import java.util.List;

@RestController
@RequestMapping("/api/my-cars")
public class CarApi {

    private static final Logger log = LoggerFactory.getLogger(CarApi.class);

    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        var allMyCars = carService.giveAllCars();
        log.info("Returned list of all my cars");
        return allMyCars;
    }

    @GetMapping("/car/{id}")

    public Car getCarById(@PathVariable("id") Long id) {

        log.info("Found car by id: [{}]", id);
        return carService.findCarById(id);
    }

    //dodaje
    @PostMapping("/all")
    public boolean addCar(@RequestBody Car car) {
        log.info("Add car: [{}] to my cars", car);
        return carService.addCar(car);
    }

    //nadpisuje
    @PutMapping("/all")
    public boolean updateCar(@RequestBody Car car) {
        log.info("Update car: [{}] details", car);
        return carService.addCar(car);
    }

    @DeleteMapping("/car/{id}")
    public boolean deleteCar(@PathVariable("id") Long id) {
        log.info("Delete car id: [{}] from my cars", id);
        return getAllCars().removeIf(car -> car.getId() == id);
    }

}
