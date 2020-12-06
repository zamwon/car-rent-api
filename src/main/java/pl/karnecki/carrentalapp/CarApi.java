package pl.karnecki.carrentalapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.carrentalapp.entity.Car;

import java.util.Optional;

@RestController
@RequestMapping("/api/my-cars")
public class CarApi {

    private static final Logger log = LoggerFactory.getLogger(CarApi.class);

    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/all")
    public Iterable<Car> getAllCars() {
        var allMyCars = carService.giveAllCars();
        log.info("Returned list of all my cars");
        return allMyCars;
    }

    @GetMapping("/car/{id}")

    public Optional<Car> getCarById(@PathVariable("id") Long id) {

        log.info("Found car by id: [{}]", id);
        return carService.findCarById(id);
    }

    //dodaje
    @PostMapping("/all")
    public Car addCar(@RequestBody Car car) {
        log.info("Add car: [{}] to my cars", car);
        return carService.saveCar(car);
    }

    //nadpisuje
    @PutMapping("/all")
    public Car updateCar(@RequestBody Car car) {
        log.info("Update car: [{}] details", car);
        return carService.updateCar(car);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCarById(@PathVariable("id") Long id) {
        log.info("Delete car id: [{}] from my cars", id);
        carService.deleteCar(id);
    }

}
