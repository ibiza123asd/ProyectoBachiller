/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package Servicios;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;
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
@WebService(serviceName = "Services")
@Stateless()
public class Services {

    ServiciosWeb serviciosweb = new ServiciosWeb();

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "listarEspecialidades")
    public List<Especialidad> listarEspecialidades() {
        return serviciosweb.listarEspecialidad();
    }

    /**
     * Web service operation
     *
     * @param documento
     * @return
     */
    @WebMethod(operationName = "findCitas")
    public List<Object[]> findCitas(@WebParam(name = "documento") String documento) {
        return serviciosweb.findListaCitas(documento);
    }

    /**
     * Web service operation
     *
     * @param codEspecialidad
     * @return
     */
    @WebMethod(operationName = "listarMedicoByEspecialidad")
    public List<MedicoDTO> listarMedicoByEspecialidad(@WebParam(name = "codEspecialidad") int codEspecialidad) {
        //TODO write your implementation code here:
        return serviciosweb.listarMedicosByEspecialidad(codEspecialidad);
    }

    /**
     * Web service operation
     *
     * @param codMedico
     * @return
     */
    @WebMethod(operationName = "listarAgendaByMedico")
    public List<AgendaDTO> listarAgendaByMedico(@WebParam(name = "codMedico") int codMedico) {
        //TODO write your implementation code here:
        return serviciosweb.listarAgendaByMedico(codMedico);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarCita")
    public void registrarCita(@WebParam(name = "cita") Cita cita) {
        serviciosweb.registrarCita(cita);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarCita")
    public CitaDTO encontrarCita(@WebParam(name = "codigo") int codigo) {
        return serviciosweb.encontrarCita(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarUltimoRegistro")
    public int encontrarUltimoRegistro() {
        //TODO write your implementation code here:
        return serviciosweb.encontrarUltimoRegistro();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarPaciente")
    public void registrarPaciente(@WebParam(name = "paciente") Paciente paciente) {
        serviciosweb.registrarPaciente(paciente);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarMedico")
    public MedicoDTO encontrarMedico(@WebParam(name = "idMedico") int idMedico) {
        //TODO write your implementation code here:
        return serviciosweb.encontrarMedico(idMedico);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarEspecialidad")
    public Especialidad encontrarEspecialidad(@WebParam(name = "idEspecialidad") int idEspecialidad) {
        //TODO write your implementation code here:
        return serviciosweb.encontrarEspecialidad(idEspecialidad);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarAgenda")
    public AgendaDTO encontrarAgenda(@WebParam(name = "idAgenda") int idAgenda) {
        //TODO write your implementation code here:
        return serviciosweb.encontrarAgenda(idAgenda);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encontrarPaciente")
    public Paciente encontrarPaciente(@WebParam(name = "documento") String documento) {
        //TODO write your implementation code here:
        return serviciosweb.findPaciente(documento);
    }

    @WebMethod(operationName = "logeo")
    public Paciente logeo(@WebParam(name = "documento") String documento, @WebParam(name = "password") String password) {
        return serviciosweb.findByLogeo(documento, password);
    }

    @WebMethod(operationName = "updatePaciente")
    public void updatePaciente(@WebParam(name = "paciente") Paciente paciente) {
        serviciosweb.updatePaciente(paciente);
    }

    @WebMethod(operationName = "countAppointmentsByPatient")
    public List<Object[]> countAppointmentsByPatient() {
        return serviciosweb.countAppointmentsByPatient();
    }

    @WebMethod(operationName = "pacientePorEspecialidad")
    public List<Object[]> pacientePorEspecialidad() {
        return serviciosweb.pacientePorEspecialidad();
    }

    @WebMethod(operationName = "countMedicsByShift")
    public List<Object[]> countMedicsByShift() {
        return serviciosweb.countMedicsByShift();
    }

    @WebMethod(operationName = "countPatientsByMedic")
    public List<Object[]> countPatientsByMedic() {
        return serviciosweb.countPatientsByMedic();
    }

    @WebMethod(operationName = "countMedicsBySpecialty")
    public List<Object[]> countMedicsBySpecialty() {
        return serviciosweb.countMedicsBySpecialty();
    }
    
     @WebMethod(operationName = "createMedic")
    public void createMedic(Medico medico) {
        this.serviciosweb.createMedico(medico);
    }
     @WebMethod(operationName = "createEspeciality")
    public void createEspeciality(Especialidad especialidad) {
        this.serviciosweb.createEspecialidad(especialidad);
    }
     @WebMethod(operationName = "createMAgenda")
    public void createMAgenda(Agenda agenda) {
        this.serviciosweb.createAgenda(agenda);
    }
    
     @WebMethod(operationName = "listarMedicos")
    public List<Object[]> listarMedicos() {
        return serviciosweb.listarMedicos();
    }
     @WebMethod(operationName = "listarAllAgenda")
    public List<Object[]> listarAllAgenda() {
        return serviciosweb.listarAllAgenda();
    }
    
     
    @WebMethod(operationName = "listarAllCitas")
    public List<Date> listarAllCitas() {
        //TODO write your implementation code here:
        return serviciosweb.listarAllCitas();
    }
    
    @WebMethod(operationName = "encontrarCitaUltima")
    public CitaDTO encontrarCitaUltima() {
        return serviciosweb.encontrarCitaUltima();
    }
    
    @WebMethod(operationName = "listarCitasByIdPaciente")
    public List<CitaDTO> listarCitasByIdPacienteo(@WebParam(name = "idPaciente") int idPaciente) {
        //TODO write your implementation code here:
        return serviciosweb.encontrarCitasporIdPaciente(idPaciente);
    }
}
