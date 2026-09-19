package com.clinica.clinica.service;

import java.util.List;
import java.util.Optional;

import com.clinica.clinica.models.Clinica;

public interface ClinicaService {
    List<Clinica> getClinicas();
    Optional<Clinica> getAtencionById(Long idAtencion);
    Clinica createAtencionClinica(Clinica clinica);
    Clinica updateAtencionClinica(Long idAtencion, Clinica clinica);
    void deleteClinica(Long idAtencion);
}
