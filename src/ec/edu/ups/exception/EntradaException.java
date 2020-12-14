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
public class EntradaException extends Exception {
    public static String mensaje = "La factura de ingreso no existe";
    public EntradaException () {
        super(mensaje);
    }
}
