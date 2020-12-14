/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Lisseth
 */
public class Vehiculo<T> {
    
    private int codigo;
    private String placa;
    private T marca;
    private T modelo;
    private Cliente cliente;
    private Espacio espacio;
    private List<FacturaEntrada> facturas;

    public Vehiculo() {
        facturas= new ArrayList<>();
    }


    public Vehiculo(int codigo, String placa, T marca, T modelo, Cliente cliente, Espacio espacio) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
        this.espacio = espacio;
    }


    public T getMarca() {
        return marca;
    }

    public void setMarca(T marca) {
        this.marca = marca;
    }

    public T getModelo() {
        return modelo;
    }

    public void setModelo(T modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    
    
    
    
    public List<FacturaEntrada> getFacturas() {
        return facturas;
    }

    public void agregacionFactura(FacturaEntrada fac) {
        facturas.add(fac);
    }

    public void actualizarFactura(FacturaEntrada fac) {
        if (facturas.contains(fac)) {
            int index = facturas.indexOf(fac);
            facturas.set(index, fac);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.placa);
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
        final Vehiculo<?> other = (Vehiculo<?>) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

}
