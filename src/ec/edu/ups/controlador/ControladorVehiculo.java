/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.*;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Lisseth
 */
public class ControladorVehiculo {

    private List<Vehiculo> vehiculos;

    public ControladorVehiculo() {
        vehiculos = new ArrayList<Vehiculo>();
    }

    public ControladorVehiculo(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

   
    
    

    public boolean crear(String placa, String modelo, Espacio espacio, Cliente cliente, String marca) throws EspacioException, PlacaException {
        Vehiculo vehiculo = new Vehiculo(generarCodigo(), placa, marca, modelo, cliente, espacio);
        validacion(vehiculo);
        return vehiculos.add(vehiculo);
    }

    public Vehiculo buscarAuto(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminar(int codigo) {
        return vehiculos.remove(this.buscar(codigo));
    }

    public boolean actualizar(int codigo, String placa, String modelo, String marca, Espacio espacio, Cliente cliente) throws EspacioException, PlacaException {
        Vehiculo vehiculo = this.buscar(codigo);
        if (vehiculo != null) {
            vehiculo.setEspacio(espacio);
            vehiculo.setModelo(modelo);
            vehiculo.setCliente(cliente);
            validacion(vehiculo);
            vehiculos.set(codigo, vehiculo);
            return true;
        }
        return false;
    }

    public Vehiculo buscar(int codigo) {
        for (Vehiculo v : vehiculos) {
            if (v.getCodigo() == codigo) {
                return v;
            }
        }
        return null;
    }

    public static void validacion(Vehiculo vehiculo) throws EspacioException, PlacaException {
        if (vehiculo.getModelo().equals("")) {
            throw new EspacioException();
        }

        if (vehiculo.getPlaca().length() > 6 && vehiculo.getPlaca().length() < 8) {
            throw new PlacaException();
        }
    }

    public int buscarPosicion(int codigo) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (v.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public int generarCodigo() {
        if (vehiculos.size() > 0) {
            Vehiculo vehiculo = vehiculos.get(vehiculos.size() - 1);
            return vehiculo.getCodigo() + 1;
        }
        return 0;
    }

}
