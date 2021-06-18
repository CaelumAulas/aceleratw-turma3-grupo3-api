package br.com.carangobom.carangoBom.dto;

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
    private HashMap<Long, TotalByBrand> totalByBrands = new HashMap<Long, TotalByBrand>();

    public DashboardDto(List<Vehicle> vehicles) {
       for(Vehicle vehicle: vehicles){
           Long brandId = vehicle.getBrand().getId();
           String brandName = vehicle.getBrand().getName();
           double price = vehicle.getPrice();

           if(!this.totalByBrands.containsKey(brandId)){
               this.totalByBrands.put(brandId, new TotalByBrand(brandName, 1, price));
           }else {
               TotalByBrand currentValue = this.totalByBrands.get(brandId);
               currentValue.setAmount(Formatter.roundAvoid(currentValue.getAmount() + price, 2));
               currentValue.setTotalVehicles(currentValue.getTotalVehicles() + 1);
               this.totalByBrands.put(brandId,currentValue);
           }
       }
    }

    public List<TotalByBrand> getTotalByBrands() {
        ArrayList<TotalByBrand> brands = new ArrayList<TotalByBrand>();

        for(Long brandId : this.totalByBrands.keySet()){
            brands.add(this.totalByBrands.get(brandId));
        }

        return brands;
    }
}
