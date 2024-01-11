/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="departamentos")
public class Departamentos implements Serializable{
    
    @Id
    @Column(name="dept_no")
    private int dept_no;
    
    @Column(name="dnombre")
    private String dnombre;
    
    @Column(name="loc")
    private String loc;
    
    @OneToMany(mappedBy = "dept_no", cascade = CascadeType.ALL)
    private List<Empleados> empleados;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.dept_no;
        hash = 13 * hash + Objects.hashCode(this.dnombre);
        hash = 13 * hash + Objects.hashCode(this.loc);
        hash = 13 * hash + Objects.hashCode(this.empleados);
        return hash;
    }

    public Departamentos() {
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    
    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
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
        final Departamentos other = (Departamentos) obj;
        if (this.dept_no != other.dept_no) {
            return false;
        }
        if (!Objects.equals(this.dnombre, other.dnombre)) {
            return false;
        }
        if (!Objects.equals(this.loc, other.loc)) {
            return false;
        }
        if (!Objects.equals(this.empleados, other.empleados)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
