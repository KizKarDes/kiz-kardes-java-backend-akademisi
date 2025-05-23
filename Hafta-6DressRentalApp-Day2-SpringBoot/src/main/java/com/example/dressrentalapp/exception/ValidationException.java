package com.example.dressrentalapp.exception;

// Doğrulama hatalarında fırlatılacak özel hata sınıfı
public class ValidationException extends RuntimeException {

    // Hata mesajını alan kurucu
    public ValidationException(String message) {
        super(message);
    }

    // Hata mesajını ve sebep olan hatayı alan kurucu
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
