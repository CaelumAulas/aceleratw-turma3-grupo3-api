package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.BrandDto;
import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.models.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/brand")
public class BrandController {


    BrandRepository brandRepository;
    VehiclesRepository vehiclesRepository;
    @GetMapping
    public Page<BrandDto> listBrands(@PageableDefault(page=0,size = 10) Pageable paginacao) {

         Page<Brand> brands = brandRepository.findAll(paginacao);
         Page<BrandDto> brandDtos = BrandDto.converter(brands);

            return brandDtos;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){

      List<Vehicle> vehicleList =   vehiclesRepository.findByBrand_Id(id);
      if(vehicleList.size()>0){
         return ResponseEntity.badRequest().build();
      }
        brandRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }






}
