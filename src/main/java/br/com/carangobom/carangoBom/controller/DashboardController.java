package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.DashboardDto;
import br.com.carangobom.carangoBom.model.TotalByBrand;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    VehiclesRepository vehiclesRepository;

    @GetMapping
    public ResponseEntity<?> listTotalPriceOfBrands() {
        List<Vehicle> vehicles = vehiclesRepository.findAll();
        DashboardDto dashboardDto = new DashboardDto(vehicles);
        List<TotalByBrand> result = dashboardDto.getTotalByBrands();

        for(TotalByBrand i : result) {
            System.out.println(i);
        }

        return new ResponseEntity(dashboardDto.getTotalByBrands(), HttpStatus.OK);
    }
}
