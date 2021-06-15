package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByBrand_Id(Long id);
}