package br.com.carangobom.carangoBom.models;


import lombok.Data;

import javax.persistence.*;
import java.time.Year;


@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
	private Brand brand;

    public Vehicle(){

    }


    private String model;
    private int years;
    private Double price;


}