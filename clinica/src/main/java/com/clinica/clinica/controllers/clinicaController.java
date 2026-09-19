package com.clinica.clinica.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.clinica.clinica.models.Clinica;
import com.clinica.clinica.service.ClinicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping ("/clinica")
public class ClinicaController {
    @Autowired 
    private ClinicaService clinicaService;


    //retorno de todos los datos de pacientes y atenciones.
    @GetMapping
    public List<Clinica> getClinicas() {
        return clinicaService.getClinicas();
    }

    //retorno de datos por id del paciente
    @GetMapping("/{idAtencion}")//idAtencion del 1-8
    public Optional<Clinica> getPacienteId(@PathVariable Long idAtencion) {
        return clinicaService.getAtencionById(idAtencion);
    }


    @PostMapping 
    public Clinica createClinica(@RequestBody Clinica clinica) {
        return clinicaService.createAtencionClinica(clinica);
    }

    @PutMapping ("/{idAtencion}")
    public Clinica updateClinica(@PathVariable Long idAtencion, @RequestBody Clinica clinica) {
        return clinicaService.updateAtencionClinica(idAtencion, clinica);
    }

    @DeleteMapping ("/{idAtencion}")
    public void deleteClinica(@PathVariable Long idAtencion) {
        clinicaService.deleteClinica(idAtencion);
    }

}
