package com.danielseab.cruid_cars.controllers;

import com.danielseab.cruid_cars.dto.CarsRequestDTO;
import com.danielseab.cruid_cars.dto.CarsResponseDTO;
import com.danielseab.cruid_cars.infra.entity.cars.Cars;
import com.danielseab.cruid_cars.infra.repository.CarsRepository;
import com.danielseab.cruid_cars.services.CarsServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor

public class CarsController {

    private final CarsServices carsServices;

    @PostMapping
    public ResponseEntity<CarsResponseDTO> register(@RequestBody CarsRequestDTO dto){
        return ResponseEntity.status(201).body(carsServices.cadastroCarro(dto));
    }

    @GetMapping
    public ResponseEntity<List<CarsResponseDTO>> listarCarros(){
        return ResponseEntity.ok(carsServices.listarCarros());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CarsResponseDTO> buscarID(@PathVariable Long id){
        return ResponseEntity.ok(carsServices.buscarID(id));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<CarsResponseDTO> atualizarCarros(@PathVariable Long id, @RequestBody CarsRequestDTO dto){
        return ResponseEntity.accepted().body(carsServices.atualizarCarro(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarros(@PathVariable Long id){
        carsServices.deletarCarros(id);
        return ResponseEntity.noContent().build();
    }
}
