package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.model.Vehicle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;


    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand().getName();
        this.model = vehicle.getModel();
        this.year = vehicle.getYears();
        this.price = vehicle.getPrice();
    }

    public static Page<VehicleDto> converter(Page<Vehicle> vehicles) {
      return vehicles.map(VehicleDto::new);

    }

}
