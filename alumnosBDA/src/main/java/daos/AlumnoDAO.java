/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.AlumnoEntidad;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ReneEzequiel23
 */
public class AlumnoDAO implements IAlumnoDAO{
    private IConexionBD conexionBD;

    public AlumnoDAO() {
        this.conexionBD = new ConexionBD();
    }
    
    @Override
    public AlumnoEntidad agregarAlumno(AlumnoEntidad alumno) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(alumno);
            entityTransaction.commit();
            return this.consultarPorID(alumno.getId());
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al crear al alumno", e);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<AlumnoEntidad> listaAlumnos() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<AlumnoEntidad> entidades = null;

        try {
            entidades = entityManager.createQuery("SELECT a FROM AlumnoEntidad a", AlumnoEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los alumnos", e);
        } finally {
            entityManager.close();
        }

        return entidades;
    }
    
    @Override
    public Long eliminarAlumno(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            AlumnoEntidad alumno = entityManager.find(AlumnoEntidad.class, id);
            if (alumno != null) {
                entityManager.remove(alumno);
            }
            entityTransaction.commit();
            return  id;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar al alumno", e);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public AlumnoEntidad editarAlumno(AlumnoEntidad alumno) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(alumno);
            entityTransaction.commit();
            return this.consultarPorID(alumno.getId());
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al actualizar al alumno", e);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public AlumnoEntidad consultarPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        AlumnoEntidad beneficiario = null;

        try {
            beneficiario = entityManager.find(AlumnoEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer por ID", e);
        } finally {
            entityManager.close();
        }

        return beneficiario;
    }
}
