package com.danielseab.cruid_cars.infra.repository;


import com.danielseab.cruid_cars.infra.entity.cars.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars, String> {
    Optional<Cars> findById(Long id);

    boolean existsByPlaca(String placa);

    void deleteById(Long id);
}
