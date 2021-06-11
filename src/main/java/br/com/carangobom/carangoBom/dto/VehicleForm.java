package br.com.carangobom.carangoBom.dto;

import br.com.carangobom.carangoBom.models.Brand;
import br.com.carangobom.carangoBom.models.Vehicle;
import br.com.carangobom.carangoBom.repository.BrandRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleForm {
    @NotNull
    @NotEmpty
    @Length( min=20)
    private  String titulo;
    @NotNull @NotEmpty @Length( min=5)
    private  String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;

    public Vehicle converter(BrandRepository brandRepository) {


        return null ;
    }
}