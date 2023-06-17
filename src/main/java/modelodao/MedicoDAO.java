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
import modelo.Cita;
import modelo.Especialidad;
import modelo.Medico;
import modelo.MedicoDTO;

/**
 *
 * @author Brandon
 */
public class MedicoDAO {

    public MedicoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<MedicoDTO> listarMedicoByEspecialidad(int idEspecialidad) {
        String jpql;
        EntityManager em = getEntityManager();
        List<MedicoDTO> medicosDTO;
        try {
            jpql = "SELECT M FROM Medico AS M where M.idEspecialidad.idEspecialidad=:idEspecialidad";
            TypedQuery<Medico> query = (TypedQuery<Medico>) this.getEntityManager().createQuery(jpql, Medico.class);
            query.setParameter("idEspecialidad", idEspecialidad);
            List<Medico> medicos = query.getResultList();
            medicosDTO = new ArrayList<>();

            medicos.stream().map(medico -> {
                MedicoDTO medicoDTO = new MedicoDTO();
                medicoDTO.setIdMedico(medico.getIdMedico());
                medicoDTO.setNombreMedico(medico.getNombreMedico());
                medicoDTO.setApellidoMat(medico.getApellidoMat());
                medicoDTO.setApellidoPat(medico.getApellidoPat());
                medicoDTO.setTelefono(medico.getTelefono());
                medicoDTO.setIdEspecialidad(medico.getIdEspecialidad().getIdEspecialidad());
                medicoDTO.setNombreEspecialidad(medico.getIdEspecialidad().getNombreEspecialidad());
// Mapea los demás campos necesarios
                return medicoDTO;
            }).forEachOrdered(medicoDTO -> {
                medicosDTO.add(medicoDTO);
            });
        } finally {
            em.close();
        }
        return medicosDTO;
    }

    public MedicoDTO findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            Medico medico = em.find(Medico.class, id);
            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setIdMedico(medico.getIdMedico());
            medicoDTO.setNombreMedico(medico.getNombreMedico());
            medicoDTO.setApellidoMat(medico.getApellidoMat());
            medicoDTO.setApellidoPat(medico.getApellidoPat());
            medicoDTO.setTelefono(medico.getTelefono());
            medicoDTO.setIdEspecialidad(medico.getIdEspecialidad().getIdEspecialidad());
            medicoDTO.setNombreEspecialidad(medico.getIdEspecialidad().getNombreEspecialidad());
            return medicoDTO;
        } finally {
            em.close();
        }
    }

    public void createMedico(Medico medico) {
        EntityManager em = getEntityManager();
        try {
            System.out.println("Entrando a crear el medico");
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
            System.out.println("Medico creado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al crear el medico: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Object[]> listarMedic() {
        String jpql;
        EntityManager em = getEntityManager();
        try {
            jpql = "SELECT M.idMedico,M.nombreMedico,M.apellidoMat,M.apellidoPat,M.telefono,M.idEspecialidad.idEspecialidad FROM Medico M";
            List<Object[]> lista = this.getEntityManager().createQuery(jpql, Object[].class)
                    .getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

}
