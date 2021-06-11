package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.Repository;


public interface BrandRepository extends Repository<Brand, Long> {
    //Page<Brand> findByName(String name, Pageable pages);

}