/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Cliente <T> extends Persona{
    
    private int codigo;
    private List<Vehiculo> vehiculos;

    public Cliente() {
        
    }

    public Cliente(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.codigo = codigo;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    //vmetodos
    public boolean agregacionVehiculo(Vehiculo vehiculo) {
      //  vehiculos.add(vehiculo);
        return this.vehiculos.add(new Vehiculo(vehiculo.getCodigo(),vehiculo.getPlaca(),vehiculo.getMarca(),vehiculo.getModelo(),vehiculo.getCliente(),vehiculo.getEspacio()));
    }
    
    public void actualizarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            int index = vehiculos.indexOf(vehiculo);
            vehiculos.set(index, vehiculo);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
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
        final Cliente<?> other = (Cliente<?>) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"codigo=" + codigo + ", vehiculos=" + vehiculos ;
    }

    
  
   
   
    
    
    
    
    
    
    
    
    
}
