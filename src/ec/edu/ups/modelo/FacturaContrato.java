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
public class FacturaContrato {
    
    private int codigo;
    private String cedula;
    private Contrato contrato;
    private Date salida;
    private double multa;
    private double descuento;
    private double total;

    public FacturaContrato() {
    }

    public FacturaContrato(int codigo, String cedula, Contrato contrato, Date salida, double multa, double descuento, double total) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.contrato = contrato;
        this.salida = salida;
        this.multa = multa;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
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
