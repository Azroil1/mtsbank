package ru.mtsbank.hw.exceptions;

public class NonValidArgumentException extends RuntimeException {
    public NonValidArgumentException(String message){
        super(message);
    }

}
