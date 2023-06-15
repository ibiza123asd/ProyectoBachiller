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
        Dashboard dashboard = new Dashboard(emf);
        PacienteDAO pacienteDAO = new PacienteDAO(emf);
        List<Object[]> resultados = dashboard.countAppointmentsByPatient(); // Llama al método que obtiene los resultados

        for (Object[] resultado : resultados) {
           // Integer idMedicos = (Integer) resultado[0];
            String nombreMedico = (String) resultado[0];
            Long cantidadPacientes = (Long) resultado[1];

            System.out.println(nombreMedico+ "\t" +cantidadPacientes);
            System.out.println("-----------------------------");
        }

    }
}
