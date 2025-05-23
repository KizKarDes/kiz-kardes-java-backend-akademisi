package com.example.dressrentalapp.service;

import com.example.dressrentalapp.exception.ResourceNotFoundException;
import com.example.dressrentalapp.exception.ValidationException;
import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Elbise servisi
@Service
public class DressService {
    private final DressRepository dressRepository;

    @Autowired
    public DressService(DressRepository dressRepository) {
        this.dressRepository = dressRepository;
    }

    // Elbise ekleme
    public Dress addDress(Dress dress) {
        dressRepository.save(dress);
        return dress;
    }

    // Tüm elbiseleri listeleme
    public List<Dress> getAllDresses() {
        return dressRepository.findAll();
    }

    // Elbise kiralama
    public Dress rentDress(Long id) {
        Dress dress = dressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dress not found with id: " + id));
        if (!dress.isAvailable()) {
            throw new ValidationException("Dress is not available for rent.");
        }
        dress.setAvailable(false);
        dressRepository.save(dress);
        return dress;
    }
}
