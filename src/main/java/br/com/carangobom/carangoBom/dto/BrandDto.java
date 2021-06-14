package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.models.Vehicle;
import br.com.carangobom.carangoBom.repository.VehiclesRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.naming.Name;
import javax.persistence.NamedAttributeNode;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter

public class BrandDto {
    private Long id;
    private String name;


    public BrandDto(Brand brand) {
        this.id=brand.getId();
        this.name=brand.getName();


    }

    public static Page<BrandDto> converter(Page<Brand> brands) {
      return brands.map(BrandDto::new);

    }

}
