/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import Servicios.ServiciosWeb;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Agenda;
import modelo.AgendaDTO;
import modelo.Cita;
import modelo.CitaDTO;
import modelo.Especialidad;
import modelo.Medico;
import modelo.MedicoDTO;
import modelo.Paciente;

/**
 *
 * @author Brandon
 */
public class prueba {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostaSalud");
        EspecialidadDAO especialidadDAO = new EspecialidadDAO(emf);
        AgendaDAO agendaDAO = new AgendaDAO(emf);
        MedicoDAO medicoDAO = new MedicoDAO(emf);
        CitaDAO citaDAO = new CitaDAO(emf);
        List<AgendaDTO> listado = agendaDAO.listarAgenda(10);
        PacienteDAO pacienteDAO = new PacienteDAO(emf);
        listado.forEach(agendadto -> {
            System.out.println(agendadto.toString());
        });
        Paciente paciente = pacienteDAO.findPaciente("40429532");
        paciente.setIdPaciente(paciente.getIdPaciente());
        paciente.setContrasena("olematadorrrrrr");
        pacienteDAO.edit(paciente);
        
        
        
    

    }
}
