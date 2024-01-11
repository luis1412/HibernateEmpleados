/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class ComprobadorDatos {
    
    
    public static boolean comprobarEntero(String numero, Component c){
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(c, "No puedes dejar campos en blanco");
            return false;
        }
        
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(c, "Comprueba los datos introducidos, no puede ser de tipo texto si se pide un numero");
            return false;
        }
    }
    public static boolean comprobarFloat(String numero, Component c){
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(c, "No puedes dejar campos en blanco");
            return false;
        }
                try {
           Float.parseFloat(numero);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(c, "Comprueba los datos introducidos, no puede ser de tipo texto si se pide un numero");
            return false;
        }
    }
}
    
    

