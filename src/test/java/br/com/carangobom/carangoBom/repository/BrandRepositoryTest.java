package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BrandRepositoryTest {
    @Autowired
    private BrandRepository brandRepository;
    @Test
    public void test(){

    }

}