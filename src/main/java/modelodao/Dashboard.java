/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.Agenda;
import modelo.AgendaDTO;

/**
 *
 * @author Brandon
 */
public class Dashboard {

    public Dashboard(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Object[]> pacientePorEspecialidad() {
        String jpql = "SELECT      E.nombreEspecialidad,\n"
                + "            COUNT(C.idPaciente)\n"
                + "FROM        Cita C\n"
                + "JOIN        C.idMedico B\n"
                + "JOIN        B.idEspecialidad E\n"
                + "GROUP BY    E.nombreEspecialidad";
        EntityManager em = getEntityManager();
        List<Object[]> resultados = new ArrayList<>();
        try {

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            resultados = query.getResultList();

        } finally {
            em.close();
        }
        return resultados;

    }

    public List<Object[]> countMedicsByShift() {
        String jpql = "SELECT  A.turno, COUNT(M.idMedico) \n"
                + "FROM    Agenda A \n"
                + "JOIN    A.idMedico M\n"
                + "GROUP BY A.turno";
        EntityManager em = getEntityManager();
        List<Object[]> resultados = new ArrayList<>();
        try {

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            resultados = query.getResultList();

        } finally {
            em.close();
        }
        return resultados;

    }

    public List<Object[]> countPatientsByMedic() {
        String jpql = "SELECT      M.idMedico,\n"
                + "            M.nombreMedico,\n"
                + "            COUNT(C.idPaciente)\n"
                + "FROM        Cita C\n"
                + "JOIN        C.idMedico M\n"
                + "GROUP BY    M.idMedico, M.nombreMedico";
        EntityManager em = getEntityManager();
        List<Object[]> resultados = new ArrayList<>();
        try {

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            resultados = query.getResultList();

        } finally {
            em.close();
        }
        return resultados;

    }

    public List<Object[]> countMedicsBySpecialty() {
        String jpql = "SELECT      E.nombreEspecialidad, COUNT(M.idMedico)\n"
                + "FROM        Medico M\n"
                + "JOIN        M.idEspecialidad E\n"
                + "GROUP BY    E.nombreEspecialidad";
        EntityManager em = getEntityManager();
        List<Object[]> resultados = new ArrayList<>();
        try {

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            resultados = query.getResultList();

        } finally {
            em.close();
        }
        return resultados;

    }

    public List<Object[]> countAppointmentsByPatient() {
        String jpql = "SELECT      P.nombre, COUNT(C.idCita)\n"
                + "FROM        Cita C\n"
                + "JOIN        C.idPaciente P\n"
                + "GROUP BY    P.nombre";
        EntityManager em = getEntityManager();
        List<Object[]> resultados = new ArrayList<>();
        try {

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            resultados = query.getResultList();

        } finally {
            em.close();
        }
        return resultados;

    }
}
