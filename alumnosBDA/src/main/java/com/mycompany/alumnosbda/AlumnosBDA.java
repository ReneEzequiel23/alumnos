/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alumnosbda;

import daos.AlumnoDAO;
import entidades.AlumnoEntidad;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ReneEzequiel23
 */
public class AlumnosBDA {

    public static void main(String[] args) {
        AlumnoEntidad alumno = new AlumnoEntidad("rene3","Lpoez4","figueria5");
        IAlumnoDAO dao = new AlumnoDAO();
        alumno.setId(1L);
        try {
            dao.editarAlumno(alumno);
            for (int i = 0; i < dao.listaAlumnos().size(); i++) {
                System.out.println(dao.listaAlumnos().get(i));
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(AlumnosBDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
