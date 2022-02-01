package ru.emotional.spring.rest.exeption_handling;

public class NoSuchEmloyeeException extends RuntimeException {

    public NoSuchEmloyeeException(String message) {
        super(message);
    }
}
