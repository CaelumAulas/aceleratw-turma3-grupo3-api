package br.com.carangobom.carangoBom.form;

import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class UpdateVehicleForm {



    @NotNull @NotEmpty
    @Length( min=5 , max=15)
    private  String model;

    @NotNull  @Min(value = 1960)
    @Max(value = 2030 )


    private  int year;

    @NotNull   @Min(value = 0)

    private Double price;

    @NotNull
    private Long brandId;

    public UpdateVehicleForm(Long brand_id,String model, int year, Double price) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.brandId=brand_id;
    }


    public Vehicle updateVehicle(Long id, VehiclesRepository vehiclesRepository, BrandRepository brandRepository){
        Optional<Vehicle> vehicle = vehiclesRepository.findById(id);
        Optional<Brand> brand=  brandRepository.findById(brandId);

        vehicle.get().setModel(this.model);
        vehicle.get().setYears(this.year);
        vehicle.get().setPrice(this.price);
        vehicle.get().setBrand(brand.get());


        return vehicle.get();
    }



}
