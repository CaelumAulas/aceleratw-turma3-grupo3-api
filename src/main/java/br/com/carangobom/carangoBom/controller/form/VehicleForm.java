package br.com.carangobom.carangoBom.controller.form;

import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
public class VehicleForm {
    @NotNull
    private Long brand_id;

    @NotNull @NotEmpty @Length( min=5 , max=15)
    private  String model;

    @NotNull  @Min(value = 1960)
    @Max(value = 2030 )


    private  int year;

    @NotNull   @Min(value = 0)

    private Double price;



    public VehicleForm(Long brand_id, String model, int years, Double price) {
        this.brand_id = brand_id;
        this.model = model;
        this.year = years;
        this.price = price;


    }


    public Vehicle convert(BrandRepository brandRepository) {
        Optional<Brand> brand = brandRepository.findById(brand_id);

        return new Vehicle(brand.get(), model,year,price  );


    }


}
