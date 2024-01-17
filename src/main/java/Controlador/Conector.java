package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelo.Departamentos;
import Modelo.Empleados;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conector {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    
    private void Sesion (){
        emf = Persistence.createEntityManagerFactory("com.mycompany_Tarea4_Hibernate_LuisHerrador_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    private void cerrarSesion(){
        em.close();
    }
    
    public Departamentos consultarDepartamento( int numeroDepartamento ){
        Departamentos d1 = new Departamentos();
        Sesion();
        String consulta = "FROM Departamentos WHERE dept_no =" + numeroDepartamento;
        Query q = em.createQuery(consulta);
        d1 = (Departamentos) q.getSingleResult();
        cerrarSesion();
        return d1;
    }
    
    
    public boolean Insertar(Empleados e1){
    
        boolean resultado = false;
        Sesion();
        
        try {
            em.getTransaction().begin();
            em.persist(e1);
            em.getTransaction().commit();
            resultado = true;
        } catch (org.hibernate.DuplicateMappingException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
        }
        
        cerrarSesion();
        return resultado;
    }
    
    public boolean borrar(Empleados a){
            Sesion();
         Empleados a1=new Empleados();
         a1= (Empleados) em.find(Empleados.class,a.getEmp_no());
         try
         {
                em.getTransaction().begin();
                em.remove(a1);
                em.getTransaction().commit();
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha dado de alta", "ERROR", 0);
         ex.printStackTrace();
              em.getTransaction().rollback();
         } finally {
            cerrarSesion();
         }
         return true;
    }
    
    public List<Empleados> devolverTodosEmpleados(){
        Sesion();
        String consulta = "FROM Empleados";
        Query query = em.createQuery(consulta);
        List<Empleados> listaEmpleados = query.getResultList();
        cerrarSesion();
        return listaEmpleados;
    }
    
    public List<Departamentos> devolverTodosDepartamento(){
        Sesion();
        String consulta = "FROM Departamentos";
        Query query = em.createQuery(consulta);
        List<Departamentos> listaDepartamentos = query.getResultList();
        cerrarSesion();
        return listaDepartamentos;
    }
    
    
    
    public boolean Actualizar(Empleados al){
        boolean resultado = false;
        Sesion();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(al);
            transaction.commit();
            resultado = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        cerrarSesion();
        return resultado;
    }
    
    
}
