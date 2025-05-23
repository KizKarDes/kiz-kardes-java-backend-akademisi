package com.example.dressrentalapp.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.dressrentalapp.exception.ResourceNotFoundException;
import com.example.dressrentalapp.exception.ValidationException;
import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.repository.DressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DressServiceTest {

    @Mock
    private DressRepository dressRepository;

    @InjectMocks
    private DressService dressService;

    @Test
    public void addDress_SavesDress() {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setAvailable(true);

        when(dressRepository.save(dress)).thenReturn(dress);

        // when
        Dress savedDress = dressService.addDress(dress);

        // then
        assertEquals(dress.getName(), savedDress.getName());
        verify(dressRepository).save(dress);
    }

    @Test
    public void getAllDresses_ReturnsDressList() {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setAvailable(true);

        when(dressRepository.findAll()).thenReturn(List.of(dress));

        // when
        List<Dress> dresses = dressService.getAllDresses();

        // then
        assertEquals(1, dresses.size());
        assertEquals(dress.getName(), dresses.get(0).getName());
        verify(dressRepository).findAll();
    }

    @Test
    public void rentDress_DressExists_ChangesAvailability() {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setAvailable(true);

        when(dressRepository.findById(dress.getId())).thenReturn(Optional.of(dress));
        when(dressRepository.save(dress)).thenReturn(dress);

        // when
        Dress rentedDress = dressService.rentDress(dress.getId());

        // then
        assertFalse(rentedDress.isAvailable());
        verify(dressRepository).findById(dress.getId());
        verify(dressRepository).save(dress);
    }

    @Test
    public void rentDress_DressDoesNotExist_ThrowsResourceNotFoundException() {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setAvailable(true);

        when(dressRepository.findById(dress.getId())).thenReturn(Optional.empty());

        // when & then
        assertThrows(ResourceNotFoundException.class, () -> {
            dressService.rentDress(dress.getId());
        });

        verify(dressRepository).findById(dress.getId());
        verify(dressRepository, never()).save(any());
    }

    @Test
    public void rentDress_DressNotAvailable_ThrowsValidationException() {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setAvailable(false);

        when(dressRepository.findById(dress.getId())).thenReturn(Optional.of(dress));

        // when & then
        assertThrows(ValidationException.class, () -> {
            dressService.rentDress(dress.getId());
        });

        verify(dressRepository).findById(dress.getId());
        verify(dressRepository, never()).save(any());
    }
}
