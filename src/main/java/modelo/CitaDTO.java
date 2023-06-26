/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Brandon
 */
public class CitaDTO {
    private Integer idCita;
    private Integer idMedico;
    private String nombreMedico;
    private Integer idPaciente;
    private String nombrePaciente;
    private Integer orden;
    private String fechaHora;
    private Double costo;

    public CitaDTO() {
    }
    
    
    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return "CitaDTO{" + "idCita=" + idCita + ", idMedico=" + idMedico + ", nombreMedico=" + nombreMedico + ", idPaciente=" + idPaciente + ", nombrePaciente=" + nombrePaciente + ", orden=" + orden + ", fechaHora=" + fechaHora + ", costo=" + costo + '}';
    }
 

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    
    
    
    
}
