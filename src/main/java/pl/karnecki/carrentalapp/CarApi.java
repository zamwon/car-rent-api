package pl.karnecki.carrentalapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

        log.info("Returned list of all my cars");
        return carService.giveAllCars();
    }

    @GetMapping("/car/{id}")

    public Car getCarById(@PathVariable("id") Long id) {

        log.info("Found car by id: [{}]", id);
        return carService.findCarById(id);
    }

}
