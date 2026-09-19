package com.clinica.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.clinica.models.Clinica;
import com.clinica.clinica.repository.ClinicaRepository;

@Service
public class ClinicaServiceImp implements ClinicaService {
    @Autowired 
    private ClinicaRepository clinicaRepository;

    @Override 
    public List<Clinica> getClinicas() {
        return clinicaRepository.findAll();
    }

    @Override 
    public Optional<Clinica> getAtencionById(Long idAtencion) {
        return clinicaRepository.findById(idAtencion);
    }


    @Override
    public Clinica createAtencionClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override 
    public Clinica updateAtencionClinica(Long idAtencion, Clinica clinica){
        if(clinicaRepository.existsById(idAtencion)){
            clinica.setIdAtencion(idAtencion);
            return clinicaRepository.save(clinica);
        }else{
            return null;
        }
    }

    @Override 
    public void deleteClinica(Long idAtencion){
        clinicaRepository.deleteById(idAtencion);
    }


}
