package ru.mtsbank.hw.exceptions;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String message){
        super(message);
    }
}
