package pl.karnecki.carrentalapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.carrentalapp.service.CarService;
import pl.karnecki.carrentalapp.entity.Car;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/my-cars")
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;
    public static final String CARS = "cars";

    public CarController(CarService carService) {
        this.carService = carService;

    }


    @GetMapping("/welcome")
    public String myCars(Model model) {
        var allCars = carService.giveAllCars();
        model.addAttribute(CARS, allCars);
        return "offer";
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
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        log.info("Add car: [{}] to my cars", car);
        var saved = carService.saveCar(car);
        return ResponseEntity.created(URI.create("/car/" + saved.getId()))
                .body(saved);
    }

    //nadpisuje
    @PutMapping("/all")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        log.info("Update car: [{}] details", car);
        var toUpdate = carService.updateCar(car);
        return ResponseEntity.accepted().body(toUpdate);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable("id") Long id) {
        log.info("Delete car id: [{}] from my cars", id);
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }


}
