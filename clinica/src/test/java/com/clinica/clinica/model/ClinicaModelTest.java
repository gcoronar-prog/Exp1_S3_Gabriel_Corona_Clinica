package com.clinica.clinica.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.clinica.clinica.models.Clinica;

class ClinicaModelTest {
    @Test 
    //Test de getters y setters de clase Clinica
    void testGettersAndSetters() {
        Clinica clinica = new Clinica();
        clinica.setIdAtencion(1L);
        clinica.setNumeroAtenciones(1);
        clinica.setRutPaciente(12345678L);
        clinica.setNombresPaciente("Juan");
        clinica.setApellidosPaciente("Perez");
        clinica.setFechaNacimiento(LocalDate.of(1990, 1, 1));
        clinica.setHistorialMedico("Historial medico para el Test");
        clinica.setNombreMedico("Long");
        clinica.setApellidoMedico("Johnson");
        clinica.setDvPaciente("9");

        assert(clinica.getIdAtencion().equals(1L));
        assert(clinica.getNumeroAtenciones() == 1);
        assert(clinica.getRutPaciente().equals(12345678L));
        assert(clinica.getNombresPaciente().equals("Juan"));
        assert(clinica.getApellidosPaciente().equals("Perez"));
        assert(clinica.getFechaNacimiento().equals(LocalDate.of(1990, 1, 1)));
        assert(clinica.getHistorialMedico().equals("Historial medico para el Test"));
        assert(clinica.getNombreMedico().equals("Long"));
        assert(clinica.getApellidoMedico().equals("Johnson"));
        assert(clinica.getDvPaciente().equals("9"));
    }
}
