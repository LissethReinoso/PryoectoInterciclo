/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lisseth
 */
public class ControladorFacturaEntrada {
    
    private List<FacturaEntrada> entradas;

    public ControladorFacturaEntrada() {
        entradas = new ArrayList<FacturaEntrada>();
    }

    public ControladorFacturaEntrada(List<FacturaEntrada> entradas) {
        this.entradas = entradas;
    }

    public List<FacturaEntrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<FacturaEntrada> entradas) {
        this.entradas = entradas;
    }


    public boolean crear(Date fechaIngreso, Vehiculo vehiculo) throws EspacioException, VehiculoException {
        FacturaEntrada entrada = new FacturaEntrada(generarCodigo(), fechaIngreso, vehiculo);
        validarCampos(entrada);
        return entradas.add(entrada);
    }

    public FacturaEntrada buscarOrden(int codigo) {
        for (FacturaEntrada fen : entradas) {
            if (fen.getCodigo() == codigo) {
                return fen;
            }
        }
        return null;
    }

    
    public boolean eliminar(int codigo) {
        return entradas.remove(this.buscarOrden(codigo));
    }

    public boolean actualizar(int codigo, Date fechaIngreso,  Vehiculo vehiculo) throws EspacioException, VehiculoException {
        FacturaEntrada en = this.buscarOrden(codigo);
        if (en != null) {
            en.setFechaIngreso(fechaIngreso);
            en.setVehiculo(vehiculo);
            validarCampos(en);
            entradas.set(codigo, en);
        }
        return false;
    }

    public static void validarCampos(FacturaEntrada entrada) throws EspacioException, VehiculoException {
        if (entrada.getIngreso().equals("")) {
            
            throw new EspacioException();
        }if(entrada.getVehiculo() == null){
             throw new VehiculoException();
        }
    }
     public int generarCodigo() {
        if (entradas.size() > 0) {
            FacturaEntrada entrada = entradas.get(entradas.size() - 1);
            return entrada.getCodigo() + 1;
        }
        return 0;
    }
    
     public int buscar(int codigo) {
        for (int i = 0; i < entradas.size(); i++) {
            FacturaEntrada entr = entradas.get(i);
            if (entr.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    
}
