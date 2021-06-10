package br.com.carangobom.carangoBom.models;


import lombok.Data;

import javax.persistence.*;
import java.time.Year;

@Entity
@Data
@Table(name="brands")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	private Brand brand;
    private String model;
    private Year years;
    private Double price;


}