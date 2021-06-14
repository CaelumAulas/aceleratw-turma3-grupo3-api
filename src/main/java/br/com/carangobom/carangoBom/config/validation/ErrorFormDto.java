package br.com.carangobom.carangoBom.config.validation;

import lombok.Data;

@Data

public class ErrorFormDto {
    private String field;
    private  String message;


    public ErrorFormDto(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
