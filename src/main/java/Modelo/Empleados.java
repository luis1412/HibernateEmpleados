/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table
public class Empleados {

    @Id
    @Column(name = "emp_no")
    private int emp_no;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "oficio")
    private String oficio;

    @Column(name = "fecha_alt")
    private LocalDate fecha_alt;

    @Column(name = "salario")
    private float salario;

    @Column(name = "comision")
    private float comision;

    @ManyToOne
    @Column(name = "dept_no")
    private int dept_no;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.emp_no;
        hash = 13 * hash + Objects.hashCode(this.apellido);
        hash = 13 * hash + Objects.hashCode(this.oficio);
        hash = 13 * hash + Objects.hashCode(this.fecha_alt);
        hash = 13 * hash + Float.floatToIntBits(this.salario);
        hash = 13 * hash + Float.floatToIntBits(this.comision);
        hash = 13 * hash + this.dept_no;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleados other = (Empleados) obj;
        if (this.emp_no != other.emp_no) {
            return false;
        }
        if (Float.floatToIntBits(this.salario) != Float.floatToIntBits(other.salario)) {
            return false;
        }
        if (Float.floatToIntBits(this.comision) != Float.floatToIntBits(other.comision)) {
            return false;
        }
        if (this.dept_no != other.dept_no) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.oficio, other.oficio)) {
            return false;
        }
        if (!Objects.equals(this.fecha_alt, other.fecha_alt)) {
            return false;
        }
        return true;
    }

    
    
    
}
