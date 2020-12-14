/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.FacturaEntrada;
import ec.edu.ups.modelo.Vehiculo;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public interface IFactura {
    
    
    public Cliente buscarVehiculo(String placa);
    
    //
    public void ingresoVehiculo(Vehiculo v);
    public void salidaVehiculo(Vehiculo v);
    public void costoTotal(int v);
    
   // public Set<Factura> findAll();

   // public int devolverNumero();
    
}
