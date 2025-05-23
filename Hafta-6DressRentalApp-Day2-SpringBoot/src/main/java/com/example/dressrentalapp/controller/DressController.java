package com.example.dressrentalapp.controller;

import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.model.request.DressRequestDTO;
import com.example.dressrentalapp.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Elbise işlemleri için kontrolcü sınıfı
@RestController
@RequestMapping("/api/dresses")
public class DressController {

    private final DressService dressService;

    @Autowired
    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    // Yeni elbise ekleme işlemi
    @PostMapping("/add")
    public Dress addDress(@Valid @RequestBody DressRequestDTO dressRequestDTO) {
        // DTO'dan Dress modeline dönüştürme
        Dress dress = new Dress();
        dress.setName(dressRequestDTO.getName());
        dress.setSize(dressRequestDTO.getSize());
        dress.setPrice(dressRequestDTO.getPrice());
        return dressService.addDress(dress);
    }

    // Mevcut elbiseleri listeleme işlemi
    @GetMapping("/all")
    public List<Dress> getAllDresses() {
        return dressService.getAllDresses();
    }

    // Elbise kiralama işlemi
    @PutMapping("/rent/{id}")
    public Dress rentDress(@PathVariable Long id) {
        return dressService.rentDress(id);
    }
}
