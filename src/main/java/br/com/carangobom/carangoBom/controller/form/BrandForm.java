package br.com.carangobom.carangoBom.controller.form;

import br.com.carangobom.carangoBom.model.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
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
