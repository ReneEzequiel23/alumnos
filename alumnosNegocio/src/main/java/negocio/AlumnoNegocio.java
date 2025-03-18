/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import daos.AlumnoDAO;
import dtos.AlumnoDTO;
import entidades.AlumnoEntidad;
import excepciones.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import interfaces.IAlumnoNegocio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ReneEzequiel23
 */
public class AlumnoNegocio implements IAlumnoNegocio{
    private IAlumnoDAO alumnoDAO;

    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public AlumnoNegocio() {
        this.alumnoDAO = new AlumnoDAO();
    }
    
    @Override
    public void agregar(AlumnoDTO alumno) throws NegocioException {
        this.validarAlumno(alumno);
        this.validarReglasNegocio(alumno);
        AlumnoEntidad alumnoEntidad = convertirDTOAEntidad(alumno);
        try {
            alumnoDAO.agregarAlumno(alumnoEntidad);
        } catch (PersistenciaException ex) {
            Logger.getLogger(IAlumnoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void editar(AlumnoDTO alumno) throws NegocioException {
        try {
            this.validarAlumno(alumno);
            this.validarReglasNegocio(alumno);
            AlumnoEntidad alumnoEntidad = convertirDTOAEntidad(alumno);
            alumnoDAO.editarAlumno(alumnoEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al editar", e);
        }
    }
    
    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            
            alumnoDAO.eliminarAlumno(id);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar al beneficiario.", ex);
        }
    }
    
    @Override
    public List<AlumnoDTO> listaAlumnos() throws NegocioException {
        try {
            
            List<AlumnoEntidad> listaAlumnos = alumnoDAO.listaAlumnos();
            List<AlumnoDTO> listaDTOS = new ArrayList<>();

            for (AlumnoEntidad alumnoEntidad : listaAlumnos) {
                AlumnoDTO alumnoDTO = convertirEntidadADTO(alumnoEntidad);
                listaDTOS.add(alumnoDTO);
            }
            return listaDTOS;
        } catch (PersistenciaException e) {
            // Capturar excepción de persistencia y lanzar como NegocioException
            throw new NegocioException("Error al obtener la lista de abonos desde la base de datos.", e);
        }
    }
    
    private AlumnoEntidad convertirDTOAEntidad(AlumnoDTO alumno) {
        if (alumno == null) {
            return null;
        }
        
        return new AlumnoEntidad(
        alumno.getId(),
        alumno.getNombre(),
        alumno.getApellidoPaterno(),
        alumno.getApellidoMaterno());
    }
    
    private AlumnoDTO convertirEntidadADTO(AlumnoEntidad alumno) {
        if (alumno == null) {
            return null;
        }
        
        return new AlumnoDTO(
        alumno.getId(),
        alumno.getNombres(),
        alumno.getPaterno(),
        alumno.getMaterno());
    }
    
    private void validarAlumno(AlumnoDTO alumno) throws NegocioException {
        // Verificar que el nombre no esté vacío
        if (alumno.getNombre() == null || alumno.getNombre().isEmpty() || alumno.getNombre().length() > 70) {
            throw new NegocioException("El nombre no puede estar vacío");
        }
        if (alumno.getApellidoPaterno() == null || alumno.getApellidoPaterno().isEmpty() || alumno.getApellidoPaterno().length() > 35) {
            throw new NegocioException("El apellido paterno no puede estar vacío");
        }
        if (alumno.getApellidoMaterno() == null ||alumno.getApellidoMaterno().isEmpty() || alumno.getApellidoMaterno().length() > 35) {
            throw new NegocioException("El apellido materno no puede estar vacío");
        }
    }
    
    private void validarReglasNegocio(AlumnoDTO alumno) throws NegocioException {
        // Verificar que el nombre no esté vacío
        if (alumno.getNombre().contains("groserias")) {
            throw new NegocioException("No introducir groserias");
        }
        if (alumno.getApellidoPaterno().contains("groserias")) {
            throw new NegocioException("No introducir groserias");
        }
        if (alumno.getApellidoMaterno().contains("groserias")) {
            throw new NegocioException("No introducir groserias");
        }
    }
}
