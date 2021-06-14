package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.BrandDto;
import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Long id) {


        Optional<Brand> brand = brandRepository.findById(id);
        if(brand.isPresent()){
            BrandDto brandDto = new BrandDto(brand.get());
            return ResponseEntity.ok(brandDto);

        }


        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {

        Optional<Brand> brand = brandRepository.findById(id);

        if(brand.isPresent()){
            brandRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }







}
