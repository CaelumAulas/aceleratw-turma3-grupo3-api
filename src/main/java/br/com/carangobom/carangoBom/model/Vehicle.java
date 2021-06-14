package br.com.carangobom.carangoBom.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int years;
    private Double price;

    @ManyToOne()
	private Brand brand;

    public Vehicle(Brand brand, String model, int years, Double price) {
        this.brand= brand;
        this.model = model;
        this.years = years;
        this.price = price;
    }

    public Vehicle(){

    }





}