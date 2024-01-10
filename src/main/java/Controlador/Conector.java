package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        emf = Persistence.createEntityManagerFactory("Musica");
        em = emf.createEntityManager();
    }
    
    private void cerrarSesion(){
        em.close();
    }
    
    
    public boolean Insertar(Album al){
    
        boolean resultado = false;
        Sesion();
        
        try {
            em.getTransaction().begin();
            em.persist(al);
            em.getTransaction().commit();
            resultado = true;
        } catch (org.hibernate.DuplicateMappingException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
        }
        
        cerrarSesion();
        return resultado;
    }
    
    public boolean borrar(Album a){
        Sesion();
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        cerrarSesion();
        return true;
    }
    
    public List<Album> devolverTodosAlbumes(){
        Sesion();
        String consulta = "FROM Album";
        Query query = em.createQuery(consulta);
        List<Album> listaAlbumes = query.getResultList();
        cerrarSesion();
        return listaAlbumes;
    }
    
    
    
    public boolean Actualizar(Album al){
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
