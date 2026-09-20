package com.clinica.clinica.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long idAtencion;

    @NotNull(message = "El RUT no puede estar vacío")
    @Min(value = 1,        message = "El RUT debe ser mayor que cero")
    @Max(value = 99999999, message = "El RUT debe tener máximo 8 dígitos")
    @Column(name = "rut_paciente")
    private Long rutPaciente;

    @Size (min = 1, max = 1, message = "El dígito verificador debe tener un solo carácter")
    @NotBlank (message = "El dígito verificador no puede estar vacío")
    @Pattern (regexp = "[0-9Kk]", message = "El dígito verificador debe ser un dígito o la letra K")
    @Column (name = "dv_paciente")
    private String dvPaciente;

    @Size(min=4, max=50, message="Los nombres del paciente deben tener entre 4 y 50 caracteres")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre del paciente solo puede contener letras y espacios")
    @NotBlank (message = "El nombre del paciente no puede estar vacío")
    @Column(name = "nombres_paciente")
    private String nombresPaciente;

    @Size(min=4, max=50, message="Los apellidos del paciente deben tener entre 4 y 50 caracteres")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Los apellidos del paciente solo pueden contener letras y espacios")
    @NotBlank (message = "Los apellidos del paciente no pueden estar vacíos")
    @Column(name = "apellidos_paciente")
    private String apellidosPaciente;

    @JsonFormat (pattern = "yyyy-MM-dd")
    @Past (message = "La fecha de nacimiento debe ser una fecha pasada")
    @NotNull  (message = "La fecha de nacimiento no puede estar vacía")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Size(min=20, max=200, message="El historial médico debe tener entre 20 y 200 caracteres")
    @NotBlank (message = "El historial médico no puede estar vacío")
    @Column(name = "historial_medico")
    private String historialMedico;

    @NotNull (message="El número de atenciones no puede estar vacío")
    @Max (value=999, message = "El número de atenciones no debe exceder los 3 dígitos")
    @Column(name = "numero_atenciones")
    private int NumeroAtenciones;

    @Size(min=4, max=50, message="Los nombres del médico deben tener entre 4 y 50 caracteres")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre del médico solo puede contener letras y espacios")
    @NotBlank (message = "El nombre del médico no puede estar vacío")
    @Column(name = "nombre_medico")
    private String NombreMedico;

    @Size(min=4, max=50, message="Los apellidos del médico deben tener entre 4 y 50 caracteres")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido del médico solo puede contener letras y espacios")
    @NotBlank (message = "El apellido del médico no puede estar vacío")
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
