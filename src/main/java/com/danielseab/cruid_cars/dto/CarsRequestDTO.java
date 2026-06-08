package com.danielseab.cruid_cars.dto;

import com.danielseab.cruid_cars.infra.entity.cars.Statuscar;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarsRequestDTO {

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca; //marca

    @NotNull
    @Min(1900)
    private int ano;

    @Positive
    private BigDecimal preco;

    @Positive
    private int km;

    private Statuscar status;
}
