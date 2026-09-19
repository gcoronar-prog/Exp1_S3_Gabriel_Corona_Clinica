package com.clinica.clinica.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long idAtencion;

    @Column(name = "rut_paciente")
    private Long rutPaciente;
    
    @Column (name = "dv_paciente")
    private String dvPaciente;

    @Column(name = "nombres_paciente")
    private String nombresPaciente;
    @Column(name = "apellidos_paciente")
    private String apellidosPaciente;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "historial_medico")
    private String historialMedico;
    @Column(name = "numero_atenciones")
    private int NumeroAtenciones;
    @Column(name = "nombre_medico")
    private String NombreMedico;
    @Column(name = "apellido_medico")
    private String ApellidoMedico;



    //Getters
    public Long getIdAtencion(){
        return idAtencion;
    }

    public Long getRutPaciente(){
        return rutPaciente;
    }

    public String getNombresPaciente(){
        return nombresPaciente;
    }
    public String getApellidosPaciente(){
        return apellidosPaciente;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public String getHistorialMedico(){
        return historialMedico;
    }

    public int getNumeroAtenciones(){
        return NumeroAtenciones;
    }

    public String getNombreMedico(){
        return NombreMedico;
    }

    public String getApellidoMedico(){
        return ApellidoMedico;
    }


    public String getDvPaciente(){
        return dvPaciente;
    }

    //Setters para más adelante
    public void setIdAtencion(Long idAtencion){
        this.idAtencion=idAtencion;
    }

    public void setNumeroAtenciones(int NumeroAtenciones){
        this.NumeroAtenciones=NumeroAtenciones;
    }
    
    public void setRutPaciente(Long rutPaciente){
        this.rutPaciente=rutPaciente;
    }

    public void setNombresPaciente(String nombresPaciente){
         this.nombresPaciente=nombresPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente){
        this.apellidosPaciente=apellidosPaciente;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }

    public void setHistorialMedico(String historialMedico){
        this.historialMedico=historialMedico;
    }

    public void setNombreMedico(String NombreMedico){
        this.NombreMedico=NombreMedico;
    }

    public void setApellidoMedico(String ApellidoMedico){
        this.ApellidoMedico=ApellidoMedico;
    }


    public void setDvPaciente(String dvPaciente){
        this.dvPaciente=dvPaciente;
    }

        
}
