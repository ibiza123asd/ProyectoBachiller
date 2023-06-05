
package Servicios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import modelo.Agenda;
import modelo.Especialidad;
import modelo.Medico;
import modelodao.AgendaDAO;
import modelodao.CitaDAO;
import modelodao.EspecialidadDAO;
import modelodao.MedicoDAO;
import modelodao.PacienteDAO;
import modelo.*;


public class ServiciosWeb {

    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostaSalud");
    EspecialidadDAO especialidadDAO = new EspecialidadDAO(emf);
    MedicoDAO medicoDAO = new MedicoDAO(emf);
    AgendaDAO agendaDAO = new AgendaDAO(emf);
    CitaDAO citaDAO = new CitaDAO(emf);
    PacienteDAO pacienteDAO = new PacienteDAO(emf);

    public List<Especialidad> listarEspecialidad() {
        /*try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Especialidad.class);
        } catch (JAXBException ex) {
            Logger.getLogger(ServiciosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return especialidadDAO.listarEspecialidades();
    }

    public List<MedicoDTO> listarMedicosByEspecialidad(int codEspecialidad) {
        return medicoDAO.listarMedicoByEspecialidad(codEspecialidad);
    }

    public List<AgendaDTO> listarAgendaByMedico(int codMedico) {
        return agendaDAO.listarAgenda(codMedico);
    }

    public void registrarCita(Cita cita) {
        citaDAO.generarCita(cita);
    }

    public CitaDTO encontrarCita(int codigo) {
        return citaDAO.findCita(codigo);
    }

    public int encontrarUltimoRegistro() {
        return citaDAO.obtenerUltimoCodigoRegistro();
    }

    public void registrarPaciente(Paciente paciente) {
        pacienteDAO.registrarPaciente(paciente);
    }
    
    public MedicoDTO encontrarMedico(int idmedico){
        return medicoDAO.findMedico(idmedico);
    }
    
    public Especialidad encontrarEspecialidad(int idEspecialidad){
        return especialidadDAO.findEspecialidad(idEspecialidad);
    }
    
    public AgendaDTO encontrarAgenda(int idAgenda){
        return agendaDAO.findAgenda(idAgenda);
    }
    
    public Paciente findPaciente(String documento){
        return pacienteDAO.findPaciente(documento);        
    }
    
    public List<Object[]> findListaCitas(String documento){
        return pacienteDAO.findListaCitas(documento);
    }
    
    public Paciente findByLogeo(String documento,String password){
        return pacienteDAO.findPacienteLogin(documento, password);
    }
    
    public void updatePaciente(Paciente paciente){
        this.pacienteDAO.edit(paciente);
    }
}
