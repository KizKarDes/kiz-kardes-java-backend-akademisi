package com.example.dressrentalapp.repository;

import com.example.dressrentalapp.model.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Dress için JPA repository
@Repository
public interface DressRepository extends JpaRepository<Dress, Long> {
}
