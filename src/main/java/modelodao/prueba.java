/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import Servicios.ServiciosWeb;
import java.util.Date;
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
        List<Object[]> listado = agendaDAO.listarAgenda();
        Dashboard dashboard = new Dashboard(emf);
        PacienteDAO pacienteDAO = new PacienteDAO(emf);
        List<Object[]> resultados = dashboard.countAppointmentsByPatient(); // Llama al método que obtiene los resultados

        for (Object[] resultado : listado) {
            Date fechaHora = (Date) resultado[0];
            Integer idAgenda = (Integer) resultado[1];
            String nombremedico = (String) resultado[2];
            String apellidoMat = (String) resultado[3];
            String apellidoPat = (String) resultado[4];
            String fecha = (String) resultado[5];
            System.out.println(fechaHora +"\t"+idAgenda+"\t"+nombremedico+ "\t"+apellidoPat+"\t"+ apellidoMat+"\t"+fecha);
            System.out.println("-----------------------------");
        }
        /*Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(2);
        Medico medico = new Medico();
        medico.setNombreMedico("Raul");
        medico.setApellidoPat("Coronado");
        medico.setApellidoMat("Carbal");
        medico.setIdEspecialidad(especialidad);
        medico.setTelefono("987111654");
        
        medicoDAO.createMedico(medico);*/

 /*Especialidad especialidad1 = new Especialidad ();
        especialidad1.setNombreEspecialidad("Cardiologia");
        especialidadDAO.createEspecialidad(especialidad1);
        Agenda agenda = new Agenda();
        agenda.setTurno("Tarde");
        Date date = new Date();
        agenda.setFechaHora(date);
        agenda.setIdMedico(new Medico (31));
        agendaDAO.createAgenda(agenda);*/
    }
}
