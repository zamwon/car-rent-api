package pl.karnecki.carrentalapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.karnecki.carrentalapp.entity.Car;

import java.util.List;

@Slf4j
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> giveAllCars() {
        var cars = carRepository.myCars();

        log.info("All my cars: {}", cars);

        return cars;

    }
    public Car findCarById(Long id) {
        var result = giveAllCars().stream().filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);

        log.info("Found car with id: [{}]", result);
        return result;
    }
}
