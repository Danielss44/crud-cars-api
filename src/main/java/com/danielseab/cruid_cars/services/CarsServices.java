package com.danielseab.cruid_cars.services;

import com.danielseab.cruid_cars.dto.CarsRequestDTO;
import com.danielseab.cruid_cars.dto.CarsResponseDTO;
import com.danielseab.cruid_cars.infra.entity.cars.Cars;
import com.danielseab.cruid_cars.infra.exceptions.CarExistsException;
import com.danielseab.cruid_cars.infra.exceptions.CarNotFoundException;
import com.danielseab.cruid_cars.infra.repository.CarsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service

public class CarsServices {


   private final CarsRepository carsRepository;

   public CarsResponseDTO toDTO(@RequestBody Cars cars){
       return new CarsResponseDTO(
               cars.getId(),
               cars.getPlaca(),
               cars.getModelo(),
               cars.getMarca(),
               cars.getAno(),
               cars.getPreco(),
               cars.getKm(),
               cars.getStatus()
       );
   }

    public CarsResponseDTO cadastroCarro(@RequestBody CarsRequestDTO dto){
        if(carsRepository.existsByPlaca(dto.getPlaca())){
            throw new CarExistsException();
        }

        Cars cars = new Cars();

        cars.setPlaca(dto.getPlaca());
        cars.setModelo(dto.getModelo());
        cars.setMarca(dto.getMarca());
        cars.setAno(dto.getAno());
        cars.setPreco(dto.getPreco());
        cars.setKm(dto.getKm());
        cars.setStatus(dto.getStatus());

        return toDTO(carsRepository.save(cars));
    }

    public List<CarsResponseDTO> listarCarros(){
        return carsRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public CarsResponseDTO buscarID(@PathVariable Long id){
       Cars cars = carsRepository.findById(id).orElseThrow(() -> new CarNotFoundException());
       return toDTO(cars);
    }

    public CarsResponseDTO atualizarCarro(@PathVariable Long id, @RequestBody CarsRequestDTO carroAtualizado){
        Cars cars = carsRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException());

            cars.setPlaca(carroAtualizado.getPlaca());
            cars.setModelo(carroAtualizado.getModelo());
            cars.setMarca(carroAtualizado.getMarca());
            cars.setAno(carroAtualizado.getAno());
            cars.setPreco(carroAtualizado.getPreco());
            cars.setKm(carroAtualizado.getKm());
            cars.setStatus(carroAtualizado.getStatus());

            return toDTO(carsRepository.save(cars));
            
    }

    public void deletarCarros(@PathVariable Long id) {
       Cars cars = carsRepository.findById(id)
               .orElseThrow(() -> new CarNotFoundException());
        carsRepository.delete(cars);
    }

}
