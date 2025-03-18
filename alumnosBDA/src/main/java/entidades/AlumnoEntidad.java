/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ReneEzequiel23
 */
@Entity
@Table(name = "tblAlumnos")
public class AlumnoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Long id;

    @Column(name = "nombres", length = 70, nullable = false)
    private String nombres;

    @Column(name = "apellidoPaterno", length = 35, nullable = false)
    private String paterno;

    @Column(name = "apellidoMaterno", length = 35, nullable = true)
    private String materno;

    public AlumnoEntidad() {
    }

    public AlumnoEntidad(
            String nombres,
            String paterno,
            String materno
    ) {
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
    }

    public AlumnoEntidad(Long id, String nombres, String paterno, String materno) {
        this.id = id;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Override
    public String toString() {
        return "AlumnoEntidad{" + "id=" + id + ", nombres=" + nombres + ", paterno=" + paterno + ", materno=" + materno + '}';
    }
}