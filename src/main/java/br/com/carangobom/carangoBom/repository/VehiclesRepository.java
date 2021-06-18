package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByBrand_Name(String name);
}