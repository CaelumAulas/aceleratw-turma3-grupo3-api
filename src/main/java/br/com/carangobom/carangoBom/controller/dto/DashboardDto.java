package br.com.carangobom.carangoBom.controller.dto;

import br.com.carangobom.carangoBom.model.TotalByBrand;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.util.Formatter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DashboardDto {
    private HashMap<String, Double> totalByBrands;

    public DashboardDto(List<Vehicle> vehicles) {
       this.totalByBrands =  new HashMap<String, Double>();

       for(Vehicle vehicle: vehicles){
           String brandName = vehicle.getBrand().getName();
           double price = vehicle.getPrice();

           if(!this.totalByBrands.containsKey(brandName)){
               this.totalByBrands.put(brandName, price);
           }else {
               this.totalByBrands.put(brandName, this.totalByBrands.get(brandName) + price);
           }
       }
    }

    public List<TotalByBrand> getTotalByBrands() {
        ArrayList<TotalByBrand> brands = new ArrayList<TotalByBrand>();

        for(String brandName : this.totalByBrands.keySet()){
            brands.add(new TotalByBrand(brandName, Formatter.roundAvoid(this.totalByBrands.get(brandName), 2)));
        }

        return brands;
    }
}
