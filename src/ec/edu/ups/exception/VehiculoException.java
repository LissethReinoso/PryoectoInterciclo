/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exception;

/**
 *
 * @author Usuario
 */
public class VehiculoException extends Exception {
    
    public static String mensaje = "El vehiculo no se encuentra registrado";
    public VehiculoException(){
        super(mensaje);
    }
    
    
    
    
}
