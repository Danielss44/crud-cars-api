package com.danielseab.cruid_cars.infra.exceptions;

public class CarExistsException extends RuntimeException {

    public CarExistsException(){
        super("Carro já cadastrado");
    }
    public CarExistsException(String message) {
        super(message);
    }
}
