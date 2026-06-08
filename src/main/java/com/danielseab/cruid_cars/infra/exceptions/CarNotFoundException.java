package com.danielseab.cruid_cars.infra.exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(){
        super("Carro não encrontado");
    }
    public CarNotFoundException(String message) {
        super(message);
    }
}
