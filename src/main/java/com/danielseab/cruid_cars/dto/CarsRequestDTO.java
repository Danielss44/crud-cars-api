package com.danielseab.cruid_cars.dto;

import com.danielseab.cruid_cars.infra.entity.cars.Statuscar;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

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
    private int ano;

    @Positive
    private float preco;

    @Positive
    private int km;

    private enum status{
        DISPONIVEL,
        VENDIDO,
        RESERVADO,
        MANUTENCAO
    };
    
    private Statuscar status;
}
