package com.danielseab.cruid_cars.infra.entity.cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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


    private int ano;


    private float preco;

    private int km;

    @Enumerated(EnumType.STRING)
    private Statuscar status;

}
