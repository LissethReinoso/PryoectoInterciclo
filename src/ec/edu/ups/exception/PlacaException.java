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
public class PlacaException extends Exception{
    
    public static String mensaje = "Placa mal ingresada";
    public PlacaException() {
        super(mensaje);
    }
}
