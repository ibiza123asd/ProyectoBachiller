/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package Servicios;

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
     * @return 
     */
    @WebMethod(operationName = "listarEspecialidades")
    public List<Especialidad>listarEspecialidades() {
        return serviciosweb.listarEspecialidad();
    }

    /**
     * Web service operation
     * @param documento
     * @return 
     */
    @WebMethod(operationName = "findCitas")
    public List<Object[]> findCitas(@WebParam(name = "documento") String documento) {
        return serviciosweb.findListaCitas(documento);
    }

    /**
     * Web service operation
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logeo")
    public Paciente logeo(@WebParam(name = "documento") String documento, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return serviciosweb.findByLogeo(documento, password);
    }
}
