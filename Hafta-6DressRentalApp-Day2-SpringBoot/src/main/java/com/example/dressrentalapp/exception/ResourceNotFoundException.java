package com.example.dressrentalapp.exception;

// Kaynak bulunamadığında fırlatılacak özel hata
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
