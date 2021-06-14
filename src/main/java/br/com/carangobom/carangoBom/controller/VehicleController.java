package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.VehicleDto;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Optional;


@Data
@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor

public class VehicleController {


    @Autowired
    VehiclesRepository vehiclesRepository;


    @GetMapping
    public Page<VehicleDto> listVehicles(@PageableDefault(page=0,size = 10) Pageable paginacao) {

         Page<Vehicle> vehicles = vehiclesRepository.findAll(paginacao);
         Page<VehicleDto> vehicleDtos = VehicleDto.converter(vehicles);
         return vehicleDtos;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id) {


        Optional<Vehicle> vehicle = vehiclesRepository.findById(id);
        if(vehicle.isPresent()){
         VehicleDto vehicleDto= new VehicleDto(vehicle.get());
         return ResponseEntity.ok(vehicleDto);

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Vehicle> vehicle = vehiclesRepository.findById(id);
        if (vehicle.isPresent()) {
            vehiclesRepository.deleteById(id);
            return (ResponseEntity.ok().build());
        }
        return ResponseEntity.notFound().build();

    }

      




}
