package com.clinica.clinica.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.clinica.clinica.models.Clinica;
import com.clinica.clinica.repository.ClinicaRepository;
import com.clinica.clinica.service.ClinicaServiceImp;

@ExtendWith (MockitoExtension.class)
class ClinicaServiceImpTest {
    
    @Mock
    private ClinicaRepository repository;

    @InjectMocks 
    private ClinicaServiceImp service;

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
    void testGetAllClinicas(){
        List<Clinica> expected = Arrays.asList(clinica);
        when(repository.findAll()).thenReturn(expected);
        assertEquals(expected, service.getClinicas());
        verify(repository).findAll();
    } 

    @Test 
    void testGetClinicaById(){
        when(repository.findById(1L)).thenReturn(Optional.of(clinica));
        assertEquals(Optional.of(clinica), service.getAtencionById(1L));
        verify(repository).findById(1L);
    }

    @Test 
    void testCreateClinica(){
        when(repository.save(clinica)).thenReturn(clinica);
        assertEquals(clinica, service.createAtencionClinica(clinica));
        verify(repository).save(clinica);
    }

    @Test  
    void testUpdateClinicaExist(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(clinica)).thenReturn(clinica);

        Clinica result = service.updateAtencionClinica(1L, clinica);

        assertEquals(1L, clinica.getIdAtencion());
        assertEquals(clinica, result);
        verify(repository).existsById(1L);
        verify(repository).save(clinica);
    }

    @Test 
    void testUpdateClinicaNotExist(){
        when(repository.existsById(1L)).thenReturn(false);
        assertNull(service.updateAtencionClinica(1L, clinica));
        verify(repository).existsById(1L);
        verify(repository, never()).save(any());
    }

    @Test 
    void testDeleteClinica(){
        service.deleteClinica(1L);
        verify(repository).deleteById(1L);
    }

    @AfterEach
    void verificarSinLlamadasExtra() {
        verifyNoMoreInteractions(repository); 
    }
}
