/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="empleados")
public class Empleados implements Serializable{

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @Column(name = "comision")
    private Float comision;

    @Id
    @Column(name = "emp_no")
    private int emp_no;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "oficio")
    private String oficio;

    @Column(name = "fecha_alt")
    private Date fecha_alt;


    @JoinColumn(name ="dept_no", referencedColumnName = "dept_no")
    @ManyToOne
    private Departamentos dept_no;

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(Date fecha_alt) {
        this.fecha_alt = fecha_alt;
    }


    public Departamentos getDept_no() {
        return dept_no;
    }

    public void setDept_no(Departamentos dept_no) {
        this.dept_no = dept_no;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.emp_no;
        hash = 31 * hash + Objects.hashCode(this.apellido);
        hash = 31 * hash + Objects.hashCode(this.oficio);
        hash = 31 * hash + Objects.hashCode(this.fecha_alt);
        hash = 31 * hash + Float.floatToIntBits(this.salario);
        hash = 31 * hash + Float.floatToIntBits(this.comision);
        hash = 31 * hash + Objects.hashCode(this.dept_no);
        return hash;
    }

    public Empleados() {
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

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    
    
    
}
