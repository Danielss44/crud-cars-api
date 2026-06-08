package com.danielseab.cruid_cars.dto;

import com.danielseab.cruid_cars.infra.entity.cars.Statuscar;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarsResponseDTO {

    private Long id;

    private String placa;

    private String modelo;

    private String marca;

    private int ano;

    private BigDecimal preco;

    private int km;

    private Statuscar status;

}

