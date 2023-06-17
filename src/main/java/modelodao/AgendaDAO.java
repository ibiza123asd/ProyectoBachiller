/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.Agenda;
import modelo.AgendaDTO;
import modelo.Cita;
import java.text.SimpleDateFormat;
import modelo.Medico;

/**
 *
 * @author Brandon
 */
public class AgendaDAO {

    public AgendaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<AgendaDTO> listarAgenda(int idMedico) {
        String jpql = "SELECT A FROM Agenda as A WHERE A.idMedico.idMedico=:idMedico";
        EntityManager em = getEntityManager();
        List<AgendaDTO> agendaslista = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {

            TypedQuery<Agenda> query = em.createQuery(jpql, Agenda.class);
            query.setParameter("idMedico", idMedico);
            List<Agenda> agendas = query.getResultList();

            for (Agenda agenda : agendas) {
                AgendaDTO agendaDTO = new AgendaDTO();
                agendaDTO.setIdAgenda(agenda.getIdAgenda());
                agendaDTO.setFechaHora(formatoFecha.format(agenda.getFechaHora()));
                agendaDTO.setIdMedico(agenda.getIdMedico().getIdMedico());
                agendaDTO.setNombreMedico(agenda.getIdMedico().getNombreMedico());
                agendaDTO.setTurno(agenda.getTurno());
                agendaslista.add(agendaDTO);
            }

        } finally {
            em.close();
        }
        return agendaslista;

    }

    public AgendaDTO findAgenda(Integer id) {
        EntityManager em = getEntityManager();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Agenda agenda = em.find(Agenda.class, id);
            AgendaDTO agendaDTO = new AgendaDTO();
            agendaDTO.setIdAgenda(agenda.getIdAgenda());     
            agendaDTO.setFechaHora(formatoFecha.format(agenda.getFechaHora()));
            agendaDTO.setIdMedico(agenda.getIdMedico().getIdMedico());
            agendaDTO.setNombreMedico(agenda.getIdMedico().getNombreMedico());
            agendaDTO.setTurno(agenda.getTurno());
            return agendaDTO;
        } finally {
            em.close();
        }
    }
    
     public void createAgenda(Agenda agenda) {
        EntityManager em = getEntityManager();
        try {
            System.out.println("Entrando a crear la agenda");
            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();
            System.out.println("Agenda creado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al crear el magenda: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
