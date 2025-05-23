package com.example.dressrentalapp.controller;

import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.model.request.DressRequestDTO;
import com.example.dressrentalapp.service.DressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DressControllerTest {

    @Mock
    private DressService dressService;

    @InjectMocks
    private DressController dressController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(dressController).build();
    }

    @Test
    void addDress_ReturnsAddedDress() throws Exception {
        // given
        DressRequestDTO dressRequestDTO = new DressRequestDTO();
        dressRequestDTO.setName("Evening Gown");
        dressRequestDTO.setSize("M");
        dressRequestDTO.setPrice(200.0);

        Dress dress = new Dress();
        dress.setName(dressRequestDTO.getName());
        dress.setSize(dressRequestDTO.getSize());
        dress.setPrice(dressRequestDTO.getPrice());

        when(dressService.addDress(any(Dress.class))).thenReturn(dress);

        // when & then
        mockMvc.perform(post("/api/dresses/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Evening Gown\", \"size\":\"M\", \"price\":200.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Evening Gown"))
                .andExpect(jsonPath("$.size").value("M"))
                .andExpect(jsonPath("$.price").value(200.0));
    }

    @Test
    void getAllDresses_ReturnsDressList() throws Exception {
        // given
        Dress dress1 = new Dress();
        dress1.setName("Evening Gown");
        dress1.setSize("M");
        dress1.setPrice(200.0);

        Dress dress2 = new Dress();
        dress2.setName("Summer Dress");
        dress2.setSize("L");
        dress2.setPrice(150.0);

        when(dressService.getAllDresses()).thenReturn(List.of(dress1, dress2));

        // when & then
        mockMvc.perform(get("/api/dresses/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Evening Gown"))
                .andExpect(jsonPath("$[1].name").value("Summer Dress"));
    }

    @Test
    void rentDress_ReturnsRentedDress() throws Exception {
        // given
        Dress dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setSize("M");
        dress.setPrice(200.0);

        when(dressService.rentDress(1L)).thenReturn(dress);

        // when & then
        mockMvc.perform(put("/api/dresses/rent/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Evening Gown"))
                .andExpect(jsonPath("$.size").value("M"));
    }
}
