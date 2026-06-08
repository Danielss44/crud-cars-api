package com.danielseab.cruid_cars.infra.entity.cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")

public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca; //marca

    @Min(1900)
    private int ano;


    private BigDecimal preco;

    private int km;

    @Enumerated(EnumType.STRING)
    private Statuscar status;

}
