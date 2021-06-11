package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {



}