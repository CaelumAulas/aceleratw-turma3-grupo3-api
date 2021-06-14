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
    private String model;
    private int years;
    private Double price;

    @ManyToOne()
	private Brand brand;

    public Vehicle(){

    }





}