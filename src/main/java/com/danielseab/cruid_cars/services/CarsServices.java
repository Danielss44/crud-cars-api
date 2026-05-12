package com.danielseab.cruid_cars.services;

import com.danielseab.cruid_cars.dto.CarsRequestDTO;
import com.danielseab.cruid_cars.infra.entity.cars.Cars;
import com.danielseab.cruid_cars.infra.repository.CarsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServices {

    @Autowired
   private CarsRepository carsRepository;

    public Cars cadastroCarro(CarsRequestDTO dto){
        Cars cars = new Cars();

        cars.setPlaca(dto.getPlaca());
        cars.setModelo(dto.getModelo());
        cars.setMarca(dto.getMarca());
        cars.setAno(dto.getAno());
        cars.setPreco(dto.getPreco());
        cars.setKm(dto.getKm());
        cars.setStatus(dto.getStatus());

        return carsRepository.save(cars);
    }

    public List<Cars> listarCarros(){
        return carsRepository.findAll();
    }

    public Cars buscarID(Long id){
        return carsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carro nâo encrontado"));
    }

    public Cars atualizarCarro(Long id, CarsRequestDTO carroAtualizado){
        Cars cars = buscarID(id);

            cars.setPlaca(carroAtualizado.getPlaca());
            cars.setModelo(carroAtualizado.getModelo());
            cars.setMarca(carroAtualizado.getMarca());
            cars.setAno(carroAtualizado.getAno());
            cars.setPreco(carroAtualizado.getPreco());
            cars.setKm(carroAtualizado.getKm());
            cars.setStatus(carroAtualizado.getStatus());

            return carsRepository.save(cars);
            
    }

    public void deletarCarros(Long id) {
        carsRepository.deleteById(id);
    }

}
