/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Lisseth
 */
public class FacturaSalida {
    
    private int codigo;
    private String cedula;
    private FacturaEntrada entrada;
    private Date Salida;
    private double descuento;
    private double total;

    public FacturaSalida() {
    }

    public FacturaSalida(int codigo, String cedula, FacturaEntrada entrada, Date Salida, double descuento, double total) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.entrada = entrada;
        this.Salida = Salida;
        this.descuento = descuento;
        this.total = total;
    }

    


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public FacturaEntrada getEntrada() {
        return entrada;
    }

    public void setEntrada(FacturaEntrada entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return Salida;
    }

    public void setSalida(Date Salida) {
        this.Salida = Salida;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
    
}
