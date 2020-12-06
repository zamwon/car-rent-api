package pl.karnecki.carrentalapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.karnecki.carrentalapp.entity.Car;

import java.util.Optional;

@Slf4j
@Service
public class CarService {

    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Iterable<Car> giveAllCars() {
        var cars = carRepository.findAll();
        log.info("All my cars: {}", cars);
        return cars;

    }
    public Optional<Car> findCarById(Long id) {
        var result = carRepository.findById(id);

        log.info("Found car with id: [{}]", result);
        return result;
    }
    public Car saveCar(@RequestBody Car car){

        log.info("Adding new car: [{}] to my cars", car);
        return carRepository.save(car);
    }
    public Car updateCar(@RequestBody Car car){
        log.info("Update car: [{}]", car);
        return carRepository.save(car);
    }
    public void deleteCar(Long id){
        log.info("Delete car by id: [{}]", id);
        carRepository.deleteById(id);
    }
}
