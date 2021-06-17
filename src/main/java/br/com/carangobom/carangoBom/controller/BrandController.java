package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.dto.BrandDto;
import br.com.carangobom.carangoBom.form.BrandForm;
import br.com.carangobom.carangoBom.form.UpdateBrandForm;
import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import org.springframework.data.domain.*;
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
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UpdateBrandForm updateBrandForm, UriComponentsBuilder uriComponentsBuilder){
        try{
            Brand brand = updateBrandForm.updateBrand(id, brandRepository);

            URI uri = uriComponentsBuilder.path("/brand/{id}").buildAndExpand(brand.getId()).toUri();
            return ResponseEntity.ok(new BrandDto(brand));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<BrandDto> registerBrand(@RequestBody @Valid BrandForm brandForm, UriComponentsBuilder uriComponentsBuilder){
            Brand brand= brandForm.convert();
            brandRepository.save(brand);
            URI uri = uriComponentsBuilder.path("/brand/{id}").buildAndExpand(brand.getId()).toUri();
            return ResponseEntity.created(uri).body(new BrandDto(brand));
    }
}
