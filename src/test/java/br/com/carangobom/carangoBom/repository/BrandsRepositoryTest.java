package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")


public class BrandsRepositoryTest {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
   public void ShouldReturnVehicleById() {


        Brand brand =  new Brand();
        testEntityManager.persist(brand);
        Optional<Brand> brand1 = brandRepository.findById(1l);
        Assert.assertNotNull(brand1);

    }

    @Test
    public void ShouldNotReturnVehicleById() {

        Optional<Brand> brands = brandRepository.findById(6l);
        Assert.assertFalse(brands.isPresent());

    }





}