package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.VehicleDetailedDto;
import br.com.carangobom.carangoBom.dto.VehicleDto;
import br.com.carangobom.carangoBom.form.UpdateVehicleForm;
import br.com.carangobom.carangoBom.form.VehicleForm;
import br.com.carangobom.carangoBom.model.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    BrandRepository brandRepository;

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
         VehicleDetailedDto vehicleDetailedDto= new VehicleDetailedDto(vehicle.get());
         return ResponseEntity.ok(vehicleDetailedDto);

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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UpdateVehicleForm updateVehicleForm, UriComponentsBuilder uriComponentsBuilder){
        try{
            Vehicle vehicle = updateVehicleForm.updateVehicle(id, vehiclesRepository);

            URI uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri();
            return ResponseEntity.ok(new VehicleDto(vehicle));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registerVehicle(@RequestBody @Valid VehicleForm vehicleForm, UriComponentsBuilder uriComponentsBuilder){
        try{
            Vehicle vehicle= vehicleForm.convert(brandRepository);
            vehiclesRepository.save(vehicle);
            URI uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri();
            return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
