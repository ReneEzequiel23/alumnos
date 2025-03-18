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
    void agregarAlumno(AlumnoEntidad alumno)throws PersistenciaException;
    
    List<AlumnoEntidad> listaAlumnos() throws PersistenciaException;
    
    void eliminarAlumno(Long id) throws PersistenciaException;
    
    void editarAlumno(AlumnoEntidad alumno) throws PersistenciaException;
}
