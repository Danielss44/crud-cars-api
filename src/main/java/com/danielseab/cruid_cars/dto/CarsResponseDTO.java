package com.danielseab.cruid_cars.dto;

import com.danielseab.cruid_cars.infra.entity.cars.Statuscar;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarsResponseDTO {

    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotNull
    private int ano;

    @Positive
    private float preco;

    @Positive
    private int km;

    private Statuscar status;

}

