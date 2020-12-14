/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class FacturaEntrada<T> {

    private int codigo;
    private Date Ingreso;

    // private Date fechaSalida;
    //private Cliente cliente;
    private Vehiculo vehiculo;
    //  private T total;
    //  private T tiempo;

    public FacturaEntrada() {
    }

    public FacturaEntrada(int codigo, Date Ingreso, Vehiculo vehiculo) {
        this.codigo = codigo;
        this.Ingreso = Ingreso;
        this.vehiculo = vehiculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getIngreso() {
        return Ingreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.Ingreso = fechaIngreso;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public String toString() {
        return "FacturaEntrada{" + "codigo=" + codigo + ", fechaDeIngreso=" + Ingreso + ", vehiculo=" + vehiculo + '}';
    }

}
