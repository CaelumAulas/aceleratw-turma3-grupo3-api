package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Brand> findByName(String name, Pageable pages);

}