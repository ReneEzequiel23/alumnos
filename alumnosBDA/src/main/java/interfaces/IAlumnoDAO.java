/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.AlumnoEntidad;
import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IAlumnoDAO {
    AlumnoEntidad agregarAlumno(AlumnoEntidad alumno)throws PersistenciaException;
    
    List<AlumnoEntidad> listaAlumnos() throws PersistenciaException;
    
    Long eliminarAlumno(Long id) throws PersistenciaException;
    
    AlumnoEntidad editarAlumno(AlumnoEntidad alumno) throws PersistenciaException;
    
    AlumnoEntidad consultarPorID(Long id) throws PersistenciaException;
}
