/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Cita;
import modelo.Especialidad;
import modelo.Medico;

/**
 *
 * @author Brandon
 */
public class EspecialidadDAO {

    public EspecialidadDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Especialidad> listarEspecialidades() {
        String jpql;
        EntityManager em = getEntityManager();
        try {
            jpql = "SELECT E FROM Especialidad as E";
            List<Especialidad> lista = this.getEntityManager().createQuery(jpql, Especialidad.class)
                    .getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

    public Especialidad findEspecialidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }
    
     public void createEspecialidad(Especialidad especialidad) {
        EntityManager em = getEntityManager();
        try {
            System.out.println("Entrando a crear la especialidad");
            em.getTransaction().begin();
            em.persist(especialidad);
            em.getTransaction().commit();
            System.out.println("Especialidad creada exitosamente");
        } catch (Exception e) {
            System.out.println("Error al crear la especialidad: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

}
