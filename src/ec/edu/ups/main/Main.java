/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.main;

import ec.edu.ups.controlador.ControladorParqueadero;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.vista.*;

/**
 *
 * @author Usuario
 */
public class Main {
    
     public static void main( String[]  args   ){
        
       // Cliente c= new Cliente(01,"010","n","ap","099","emilio","lreinoso");
        
     //   System.out.println(c);
        
        ControladorParqueadero par = new ControladorParqueadero();
        VentanaPrincipalP p = new VentanaPrincipalP(par);
        p.setVisible(true);
        
        
        
        
    }
    
}
