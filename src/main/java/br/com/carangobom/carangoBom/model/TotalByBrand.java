package br.com.carangobom.carangoBom.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalByBrand {
    private String brandName;
    private double amount;
}
