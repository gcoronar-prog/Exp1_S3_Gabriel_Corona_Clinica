package com.clinica.clinica.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.clinica.clinica.controllers.ClinicaController;
import com.clinica.clinica.models.Clinica;
import com.clinica.clinica.service.ClinicaService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest (ClinicaController.class)
class ClinicaControllerTest {
    
    @Autowired 
    private MockMvc mockMvc;

    @MockitoBean
    private ClinicaService service; 

    @Autowired 
    private ObjectMapper mapper;

    private Clinica clinica;

    @BeforeEach
    void setup() {
        clinica = new Clinica();
        clinica.setIdAtencion(1L);
        clinica.setNumeroAtenciones(1);
        clinica.setRutPaciente(12345678L);
        clinica.setNombresPaciente("Juan");
        clinica.setApellidosPaciente("Perez");
        //clinica.setFechaNacimiento("01/01/1990");
        clinica.setHistorialMedico("Historial Test");
        clinica.setNombreMedico("Dr. Smith");
        clinica.setApellidoMedico("Johnson");
        clinica.setDvPaciente("9");
    } 

    @Test 
    void testGetAllClinicas() throws Exception{
        when(service.getClinicas()).thenReturn(Arrays.asList(clinica));
        mockMvc.perform(get("/clinica"))
        .andExpect(status().isOk())
        .andExpect(content()
        .json(mapper.writeValueAsString(Arrays.asList(clinica))));
    }
    
    @Test 
    void testGetClinicaById() throws Exception {
        when(service.getAtencionById(1L)).thenReturn(Optional.of(clinica));
        mockMvc.perform(get("/clinica/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(clinica)));
    }

    @Test 
    void testCreateClinica() throws Exception{
        when(service.createAtencionClinica(any(Clinica.class))).thenReturn(clinica);
        mockMvc.perform(post("/clinica")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(clinica)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(clinica)));
    }    

    @Test 
    void testUpdateClinica() throws Exception{
        when(service.updateAtencionClinica(eq(1L), any(Clinica.class))).thenReturn(clinica);
        mockMvc.perform(put("/clinica/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(clinica)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(clinica)));
    }

    @Test 
    void testDeleteClinica() throws Exception{
        mockMvc.perform(delete("/clinica/1"))
                .andExpect(status().isOk());
        verify(service).deleteClinica(1L);
    }

}
