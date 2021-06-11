package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.BrandDto;
import br.com.carangobom.carangoBom.dto.VehicleDto;
import br.com.carangobom.carangoBom.models.Brand;
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

import javax.transaction.Transactional;

@Data
@RestController
@RequestMapping("/brand")
public class BrandController {




    @Autowired
    BrandRepository brandRepository;

    @GetMapping
    public Page<BrandDto> listVehicles(@PageableDefault(page=0,size = 10) Pageable paginacao) {

         Page<Brand> brands = brandRepository.findAll(paginacao);
         Page<BrandDto> brandDtos = BrandDto.converter(brands);

            return brandDtos;


    }







}
