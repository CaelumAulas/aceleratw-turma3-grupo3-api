package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.model.Brand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

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
