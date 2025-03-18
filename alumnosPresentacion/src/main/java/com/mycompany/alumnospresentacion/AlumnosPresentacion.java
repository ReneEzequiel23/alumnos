/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alumnospresentacion;

import Presentacion.FrmAlumnos;
import excepciones.NegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.AlumnoNegocio;


/**
 *
 * @author ReneEzequiel23
 */
public class AlumnosPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        try {
            FrmAlumnos frm = new FrmAlumnos(alumnoNegocio);
            frm.show();
        } catch (NegocioException ex) {
            Logger.getLogger(AlumnosPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
