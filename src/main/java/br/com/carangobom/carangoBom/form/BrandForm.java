package br.com.carangobom.carangoBom.form;

import br.com.carangobom.carangoBom.model.Brand;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BrandForm {
    @NotNull
    @NotEmpty

    private String name;

    public BrandForm(String name) {
        this.name = name;
    }

    public Brand convert() {


        return new Brand(name);
    }
}
