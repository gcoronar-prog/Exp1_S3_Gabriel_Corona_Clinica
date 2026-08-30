package com.clinica.clinica.models;

import java.time.LocalDate;

public class Clinica {
    private int idPaciente;
    private String rutPaciente;
    private String nombresPaciente;
    private String apellidosPaciente;
    private LocalDate fechaNacimiento;
    private String historialMedico;
    private String atenciones;
    private int idMedico;
    private String medico;


    public Clinica(int idPaciente, String rutPaciente, String nombresPaciente, String apellidosPaciente, LocalDate fechaNacimiento, String historialMedico, String atenciones,
        int idMedico, String medico) {
        this.idPaciente=idPaciente;
        this.rutPaciente=rutPaciente;
        this.nombresPaciente=nombresPaciente;
        this.apellidosPaciente=apellidosPaciente;
        this.fechaNacimiento=fechaNacimiento;
        this.historialMedico=historialMedico;
        this.atenciones=atenciones;
        this.idMedico=idMedico;
        this.medico=medico;
    }

    //Getters
    public int getIdPaciente(){
        return idPaciente;
    }

    public int getIdMedico(){
        return idMedico;
    }

    public String getRutPaciente(){
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

    public String getAtenciones(){
        return atenciones;
    }

    public String getMedico(){
        return medico;
    }
    

    //Setters para más adelante
    public void setIdMedico(int idMedico){
        this.idMedico=idMedico;
    }

    public void setMedico(String medico){
        this.medico=medico;
    }

    public void setIdPaciente(int idPaciente){
        this.idPaciente=idPaciente;
    }
    
    public void setRutPaciente(String rutPaciente){
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

        public void setAtenciones(String atenciones){
         this.atenciones=atenciones;
    }
        
       
        
        
       
       

}
