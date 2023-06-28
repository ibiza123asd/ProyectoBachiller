package modelodao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
            //em.merge(cita);    
            em.persist(cita);
            em.getTransaction().commit();
            em.refresh(cita);
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
            citaDTO.setFechaHora(cita.getFechaHora().toString());
            citaDTO.setCosto(cita.getCostoCita());
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

    public List<Date> listarAllCitas() {
        String jpql;
        EntityManager em = getEntityManager();
        try {
            jpql = "SELECT C.fechaHora FROM Cita as C";
            List<Date> lista = this.getEntityManager().createQuery(jpql, Date.class)
                    .getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

    public CitaDTO encontrarUltimaCita() {
        String jpql;
        CitaDTO citadto;
        EntityManager em = getEntityManager();
        try {
            jpql = "SELECT c FROM Cita c WHERE c.idCita = (SELECT MAX(c2.idCita) FROM Cita c2)";
            TypedQuery<Cita> query = em.createQuery(jpql, Cita.class);
            query.setMaxResults(1); // Limitamos el resultado a un solo registro
            Cita cita = query.getSingleResult();
            citadto = new CitaDTO();
            citadto.setIdCita(cita.getIdCita());
            citadto.setOrden(cita.getOrden());
            citadto.setNombreMedico(cita.getIdMedico().getNombreMedico());
            citadto.setCosto(cita.getCostoCita());
            citadto.setNombrePaciente(cita.getIdPaciente().getNombre());
            return citadto;
        } finally {
            em.close();
        }
    }
    
    public List<CitaDTO> listarCitasByIdPaciente(int idPaciente) {
        String jpql;
        EntityManager em = getEntityManager();
        List<CitaDTO> citasDTO;
        try {
             SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            jpql = "SELECT c FROM Cita as c Where c.idPaciente.idPaciente=:idPaciente";
            TypedQuery<Cita> query = (TypedQuery<Cita>) this.getEntityManager().createQuery(jpql, Cita.class);
            query.setParameter("idPaciente", idPaciente);
            List<Cita> citas = query.getResultList();
            citasDTO = new ArrayList<>();

            citas.stream().map(cita -> {
                CitaDTO citadto = new CitaDTO();
                citadto.setNombreMedico(cita.getIdMedico().getNombreMedico());
                citadto.setNombrePaciente(cita.getIdPaciente().getNombre());
                citadto.setCosto(cita.getCostoCita());
                citadto.setOrden(cita.getOrden());
                citadto.setFechaHora(formatoFecha.format(cita.getFechaHora()));
                citadto.setIdCita(cita.getIdCita());
                citadto.setIdMedico(cita.getIdMedico().getIdMedico());
                citadto.setApeMatMedico(cita.getIdMedico().getApellidoMat());
                citadto.setApePatMedico(cita.getIdMedico().getApellidoPat());
                MedicoDTO medico = new MedicoDAO(emf).findMedico(cita.getIdMedico().getIdMedico());
                citadto.setNombreEspecialidad(medico.getNombreEspecialidad());
                return citadto;
            }).forEachOrdered(citadto -> {
                citasDTO.add(citadto);
            });
        } finally {
            em.close();
        }
        return citasDTO;
    }
    
    public List<CitaDTO> listarCitasByIdMedico(int idMedico) {
        String jpql;
        EntityManager em = getEntityManager();
        List<CitaDTO> citasDTO;
        try {
            jpql = "SELECT c FROM Cita as c Where c.idMedico.idMedico=:idMedico";
             SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            TypedQuery<Cita> query = (TypedQuery<Cita>) this.getEntityManager().createQuery(jpql, Cita.class);
            query.setParameter("idMedico", idMedico);
            List<Cita> citas = query.getResultList();
            citasDTO = new ArrayList<>();

            citas.stream().map(cita -> {
                CitaDTO citadto = new CitaDTO();
                citadto.setNombreMedico(cita.getIdMedico().getNombreMedico());
                citadto.setNombrePaciente(cita.getIdPaciente().getNombre());
                citadto.setCosto(cita.getCostoCita());
                citadto.setOrden(cita.getOrden());
                citadto.setFechaHora(formatoFecha.format(cita.getFechaHora()));
                citadto.setIdCita(cita.getIdCita());
                citadto.setIdMedico(cita.getIdMedico().getIdMedico());
                citadto.setApeMatMedico(cita.getIdMedico().getApellidoMat());
                citadto.setApePatMedico(cita.getIdMedico().getApellidoPat());
                MedicoDTO medico = new MedicoDAO(emf).findMedico(cita.getIdMedico().getIdMedico());
                citadto.setNombreEspecialidad(medico.getNombreEspecialidad());
                return citadto;
            }).forEachOrdered(citadto -> {
                citasDTO.add(citadto);
            });
        } finally {
            em.close();
        }
        return citasDTO;
    }
    
    
}
