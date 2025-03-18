/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alumnosnegocio;

import dtos.AlumnoDTO;
import entidades.AlumnoEntidad;
import excepciones.NegocioException;
import interfaces.IAlumnoNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.AlumnoNegocio;

/**
 *
 * @author ReneEzequiel23
 */
public class AlumnosNegocio {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AlumnoDTO alumno = new AlumnoDTO(3L,"Editado","Editado","Editado");
        
        IAlumnoNegocio negocio = new AlumnoNegocio();
        
        try {
            for (int i = 0; i < negocio.listaAlumnos().size(); i++) {
                System.out.println(negocio.listaAlumnos().get(i));
            }
        } catch (NegocioException ex) {
            Logger.getLogger(AlumnosNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
