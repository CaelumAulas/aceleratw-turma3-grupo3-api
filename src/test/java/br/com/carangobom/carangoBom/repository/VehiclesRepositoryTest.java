package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.model.Vehicle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.junit.Test;
import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")


public class VehiclesRepositoryTest {
    @Autowired
    private VehiclesRepository vehiclesRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
   public void ShouldReturnVehicleById() {
        String brandName="ford";

        Vehicle vehicle =  new Vehicle();
        testEntityManager.persist(vehicle);
        Optional<Vehicle> vehicle1 = vehiclesRepository.findById(1l);
        Assert.assertNotNull(vehicle1);

    }

    @Test
    public void ShouldNotReturnVehicleById() {
        
        Optional<Vehicle> vehicles = vehiclesRepository.findById(6l);
        Assert.assertFalse(vehicles.isPresent());

    }





}