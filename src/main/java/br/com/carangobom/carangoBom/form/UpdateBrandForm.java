package br.com.carangobom.carangoBom.form;

import br.com.carangobom.carangoBom.model.Brand;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class UpdateBrandForm {


    @NotNull @NotEmpty

    private String name;

    public UpdateBrandForm(String name) {
        this.name = name;
    }

    public Brand updateBrand(Long id, BrandRepository brandRepository) {
        Optional<Brand> brand = brandRepository.findById(id);
        brand.get().setName(this.name);

        return brand.get();


    }
}
