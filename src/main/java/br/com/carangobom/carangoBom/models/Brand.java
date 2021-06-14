package br.com.carangobom.carangoBom.models;


import br.com.carangobom.carangoBom.dto.VehicleDto;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity


public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Brand(){}

    public Brand(String name) {
        this.name = name;
    }
}