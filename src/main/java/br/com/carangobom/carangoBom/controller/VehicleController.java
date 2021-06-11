package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.VehicleForm;
import br.com.carangobom.carangoBom.dto.VehicleDto;
import br.com.carangobom.carangoBom.models.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;

import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Data
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        vehiclesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }





}
