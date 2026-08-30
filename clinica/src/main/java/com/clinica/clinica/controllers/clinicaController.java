package com.clinica.clinica.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.clinica.clinica.models.Clinica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class clinicaController {
    private List<Clinica> clinicas = new ArrayList<>();

    //poblado de datos
    public clinicaController(){
        clinicas.add(new Clinica(1, "12345678-9", "María Elena", "Contreras Silva",
                LocalDate.of(1985, 4, 12), "Hipertensión arterial controlada",
                "Control cardiológico 15/03/2026",
                101, "Dr. Jorge Vega Morales"));

        clinicas.add(new Clinica(2, "15234567-8", "Carlos Andrés", "Muñoz Rojas",
                LocalDate.of(1978, 11, 3), "Diabetes tipo 2, tratamiento con metformina",
                "Consulta nutricional 22/03/2026",
                102, "Dra. Cecilia Ponce Miranda"));

        clinicas.add(new Clinica(3, "20123456-8", "Matías Alonso", "Fernández Godoy",
                LocalDate.of(2001, 7, 25), "Sin antecedentes relevantes",
                "Traumatología por esguince de tobillo 05/04/2026",
                103, "Dr. Felipe Cáceres Bravo"));

        clinicas.add(new Clinica(4, "9876543-2", "Rosa Angélica", "Maturana Vera",
                LocalDate.of(1952, 2, 18), "Artrosis de rodilla, osteoporosis",
                "Kinesiología, sesión 4 de 10, 10/04/2026",
                103, "Dr. Felipe Cáceres Bravo"));

        clinicas.add(new Clinica(5, "17654321-K", "Ricardo Esteban", "Pinto Navarro",
                LocalDate.of(1992, 9, 30), "Asma bronquial desde la infancia",
                "Control broncopulmonar 18/04/2026",
                104, "Dra. Verónica Aguilera Reyes"));

        clinicas.add(new Clinica(6, "21345678-K", "Antonia Isidora", "Palma Guzmán",
                LocalDate.of(2003, 12, 8), "Alergia a penicilina",
                "Consulta dermatológica 25/04/2026",
                105, "Dr. Sebastián Torres Lagos"));

        clinicas.add(new Clinica(7, "13987654-1", "Patricia Isabel", "Soto Fuentes",
                LocalDate.of(1981, 6, 14), "Migraña crónica en tratamiento",
                "Neurología, evaluación semestral 02/05/2026",
                106, "Dra. Claudia Riquelme Paz"));

        clinicas.add(new Clinica(8, "19876543-7", "Sebastián Andrés", "Torres Lagos",
                LocalDate.of(1996, 1, 27), "Fractura de radio consolidada en 2023",
                "Control postoperatorio 09/05/2026",
                103, "Dr. Felipe Cáceres Bravo"));
    }

    //retorno de todos los datos de pacientes y atenciones.
    @GetMapping("/clinica")
    public List<Clinica> getClinicas() {
        return clinicas;
    }

    //retorno de datos por id del paciente
    @GetMapping("/clinica/{idPaciente}")//idPaciente del 1-8
    public Clinica getPacienteId(@PathVariable int idPaciente) {
        for(Clinica clinica : clinicas){
            if (clinica.getIdPaciente() == idPaciente) {//se evaluan retornos que coincidan con idPaciente
                return clinica;
            }
        }
        return null;
    }

    //retorno de datos por rut de paciente
    /*rutPaciente =  12345678-9
                    15234567-8
                    20123456-8
                    9876543-2
                    17654321-K
                    21345678-K
                    13987654-1
                    19876543-7*/
    @GetMapping("/clinica/paciente/{rutPaciente}")
    public Clinica getRutPaciente(@PathVariable String rutPaciente) {
        for(Clinica clinica : clinicas){
            if (clinica.getRutPaciente().equals(rutPaciente)) {//se evaluan retornos que coincidan con rut del paciente
                return clinica;
            }
        }
        return null;
    }
//retorno de datos por id de medico
    @GetMapping("/clinica/medico/{idMedico}") //idMedico tiene valores del 101 - 106
    public List<Clinica> getMedicosId(@PathVariable int idMedico) {
        List<Clinica> medicos = new ArrayList<>();//se crea lista de clase
        for (Clinica clinica : clinicas) {
            if (clinica.getIdMedico() == idMedico) {//se verifica que la id del endpoint corresponda con la existente
                 medicos.add(clinica); //se agrega a la lista los datos que coincidan con el idMedico
            }
        }
        return medicos; //retorna los datos segun la id del medico ingresada
    }
}
