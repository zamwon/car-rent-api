package pl.karnecki.carrentalapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.karnecki.carrentalapp.entity.Car;
import pl.karnecki.carrentalapp.repository.CarRepository;

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
    public Car saveCar(@RequestBody Car car){

        log.info("Adding new car: [{}] to my cars", car);

        return car;
    }
    public Car updateCar(@RequestBody Car car){
        log.info("Update car: [{}]", car);
        return car;
    }
    public boolean deleteCar(Long id){
        log.info("Delete car by id: [{}]", id);
        return carRepository.myCars().remove(findCarById(id));
    }
}
