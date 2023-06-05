/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Agenda;
import modelo.Cita;
import modelo.Paciente;
import modelo.exceptions.NonexistentEntityException;

/**
 *
 * @author Brandon
 */
public class PacienteDAO {

    public PacienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void registrarPaciente(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();          
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Paciente findPaciente(String documento) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT P FROM Paciente AS P WHERE P.dni=:documento";
        try {
            TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
            query.setParameter("documento", documento);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Manejo de excepción cuando no se encuentra el paciente
        } finally {
            em.close();
        }
    }

    public List<Object[]> findListaCitas(String documento) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT C.idCita,P.nombre,M.nombreMedico,E.nombreEspecialidad,A.fechaHora FROM Cita C\n"
                    + "JOIN C.idPaciente P\n"
                    + "JOIN C.idMedico M\n"
                    + "JOIN M.agendaList A\n"
                    + "JOIN M.idEspecialidad E where P.dni=:documento";
            return this.getEntityManager().createQuery(jpql, Object[].class).setParameter("documento", documento).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Paciente findPacienteLogin(String documento, String contrasena) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT P FROM Paciente AS P WHERE P.dni=:documento and P.contrasena=:contrasena";
        try {
            TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
            query.setParameter("documento", documento);
            query.setParameter("contrasena", contrasena);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Manejo de excepción cuando no se encuentra el paciente
        } finally {
            em.close();
        }
    }
    
    public void edit(Paciente paciente){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteEncontrado = em.find(Paciente.class, paciente.getIdPaciente());
            System.out.println("Entrando acá");
            pacienteEncontrado.setContrasena(paciente.getContrasena());
            System.out.println("Entrando acax2");
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
