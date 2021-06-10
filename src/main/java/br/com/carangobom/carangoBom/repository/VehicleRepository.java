package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.models.Vehicle;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Brand> findByName(String name, Pageable pages);

}