/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.AlumnoEntidad;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ReneEzequiel23
 */
public class AlumnoDAOTest {
    
    public AlumnoDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testAgregarAlumno() throws Exception {
        System.out.println("agregarAlumno");
        AlumnoEntidad alumno = new AlumnoEntidad("rene3","Lpoez4","figueria5");
        AlumnoDAO instance = new AlumnoDAO();
        AlumnoEntidad exp = instance.agregarAlumno(alumno);
        assertEquals(alumno.getId(), exp.getId());
    }

    /**
     * Test of listaAlumnos method, of class AlumnoDAO.
     */
    @Test
    public void testListaAlumnos() throws Exception {
        System.out.println("listaAlumnos");
        AlumnoDAO instance = new AlumnoDAO();
        
        List<AlumnoEntidad> result = instance.listaAlumnos();
        assertNotNull(result, "lista");
    }

    /**
     * Test of eliminarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testEliminarAlumno() throws Exception {
        System.out.println("eliminarAlumno");
        Long id = 17L;
        AlumnoDAO instance = new AlumnoDAO();
        AlumnoEntidad result =instance.consultarPorID(id);
        Long expResult = instance.eliminarAlumno(id);
        assertEquals(expResult, result.getId());
    }

    /**
     * Test of editarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testEditarAlumno() throws Exception {
        System.out.println("editarAlumno");
        AlumnoEntidad alumno = new AlumnoEntidad(14L,"wwCarlos","Felix2","Morales233");
        AlumnoDAO instance = new AlumnoDAO();
        AlumnoEntidad result =instance.consultarPorID(alumno.getId());
        AlumnoEntidad expResult = instance.editarAlumno(alumno);
        assertEquals(expResult.getId(), result.getId());
    }
    
}
