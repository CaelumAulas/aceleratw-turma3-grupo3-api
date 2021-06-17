package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Getter
@Setter

public class VehicleDetailedDto {

    @Autowired
    BrandRepository brandRepository;
    private Long id;
    private Brand brand;
    private String model;
    private int year;
    private double price;


    public VehicleDetailedDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.year = vehicle.getYears();
        this.price = vehicle.getPrice();
    }


    

}
