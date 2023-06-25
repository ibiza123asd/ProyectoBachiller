package modelodao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Cita;
import modelo.CitaDTO;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Brandon
 */
public class CitaDAO {

    public CitaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    
    
    public void generarCita(Cita cita) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico medico = em.find(Medico.class, cita.getIdMedico().getIdMedico());
            Paciente paciente = em.find(Paciente.class, cita.getIdPaciente().getIdPaciente());
            cita.setIdMedico(medico);
            cita.setIdPaciente(paciente);
            em.merge(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
    
    public CitaDTO findCita(Integer id) {
        EntityManager em = getEntityManager();
        try {      
            Cita cita = em.find(Cita.class, id);
            CitaDTO citaDTO = new CitaDTO();
            citaDTO.setIdCita(cita.getIdCita());
            citaDTO.setIdMedico(cita.getIdMedico().getIdMedico());
            citaDTO.setNombreMedico(cita.getIdMedico().getNombreMedico());
            citaDTO.setIdPaciente(cita.getIdPaciente().getIdPaciente());
            citaDTO.setNombrePaciente(cita.getIdPaciente().getNombre());
            citaDTO.setOrden(cita.getOrden());

            return citaDTO;
        } finally {
            em.close();
        }
    }

    public int obtenerUltimoCodigoRegistro() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT C.idCita FROM Cita C ORDER BY C.idCita DESC");
            query.setMaxResults(1);
            Integer codigo = (Integer) query.getSingleResult();
            return codigo != null ? codigo : 0;
        } catch (NoResultException e) {
            return 0;
        } finally {
            em.close();
        }
    }
}
