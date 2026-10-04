package com.clinica.clinica.model;

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
        //clinica.setFechaNacimiento("01/01/1990");
        clinica.setHistorialMedico("Historial Test");
        clinica.setNombreMedico("Dr. Smith");
        clinica.setApellidoMedico("Johnson");
        clinica.setDvPaciente("9");

        assert(clinica.getIdAtencion().equals(1L));
        assert(clinica.getNumeroAtenciones() == 1);
        assert(clinica.getRutPaciente().equals(12345678L));
        assert(clinica.getNombresPaciente().equals("Juan"));
        assert(clinica.getApellidosPaciente().equals("Perez"));
        //assert(clinica.getFechaNacimiento().equals("01/01/1990"));
        assert(clinica.getHistorialMedico().equals("Historial Test"));
        assert(clinica.getNombreMedico().equals("Dr. Smith"));
        assert(clinica.getApellidoMedico().equals("Johnson"));
        assert(clinica.getDvPaciente().equals("9"));
    }
}
