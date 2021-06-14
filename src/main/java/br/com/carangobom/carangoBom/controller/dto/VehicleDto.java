package br.com.carangobom.carangoBom.controller.dto;

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


    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand().getName();
        this.model = vehicle.getModel();
        this.year = vehicle.getYears();
    }

    public static Page<VehicleDto> converter(Page<Vehicle> vehicles) {
      return vehicles.map(VehicleDto::new);

    }

}
