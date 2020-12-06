package pl.karnecki.carrentalapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    private Long id;
    private String manufacturer;
    private String model;
    private String body;
    private LocalDate productionYear;
    private int horsePower;
    private int engineCapacity;
    private String color;
    private int pricePerDay;

}
