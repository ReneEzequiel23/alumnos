/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dtos.AlumnoDTO;
import excepciones.NegocioException;
import java.util.List;


/**
 *
 * @author ReneEzequiel23
 */
public interface IAlumnoNegocio {
    void agregar(AlumnoDTO alumno) throws NegocioException;
    
    void editar(AlumnoDTO alumno) throws NegocioException;
    
    void eliminar(Long id) throws NegocioException;
    
    List<AlumnoDTO> listaAlumnos() throws NegocioException;
}
