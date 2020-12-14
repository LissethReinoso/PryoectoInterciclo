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
public class ControladorFacturaSalida {
 
     private List<FacturaSalida> salidas;

    public ControladorFacturaSalida() {
        salidas = new ArrayList<FacturaSalida>();
    }

    public ControladorFacturaSalida(List<FacturaSalida> salidas) {
        this.salidas = salidas;
    }

    public List<FacturaSalida> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<FacturaSalida> salidas) {
        this.salidas = salidas;
    }

   public int generarCodigo() {
        if (salidas.size() > 0) {
            FacturaSalida salida = salidas.get(salidas.size() - 1);
            return salida.getCodigo() + 1;
        }
        return 0;
    }

    public boolean crearFacturaSalida(String cedula, FacturaEntrada entrada, Date salida, double descuento, double total) throws EspacioException, EntradaException {
        FacturaSalida facturaE = new FacturaSalida(generarCodigo(), cedula, entrada, salida,descuento, total);
        validacion(facturaE);
        return salidas.add(facturaE);
    }

    public FacturaSalida buscar(int codigo) {
        for (FacturaSalida facS : salidas) {
            if (facS.getCodigo() == codigo) {
                return facS;
            }
        }
        return null;
    }


    public boolean eliminar(int codigo) {
        return salidas.remove(this.buscar(codigo));
    }

    public int buscarPosicion(int codigo) {
        for (int i = 0; i < salidas.size(); i++) {
            FacturaSalida facS= salidas.get(i);
            if (facS.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public boolean actualizar(int codigo, String ruc, FacturaEntrada entrada, Date fechaSalida, double descuento, double total) throws EspacioException, EntradaException {
        FacturaSalida facturaS = this.buscar(codigo);
        if (facturaS != null) {
            facturaS.setDescuento(descuento);
            facturaS.setSalida(fechaSalida);
            validacion(facturaS);
            salidas.set(codigo, facturaS);
            return true;
        }
        return false;
    }

    public static void validacion(FacturaSalida facturaS) throws EspacioException, EntradaException {
        if (facturaS.getSalida().equals("") ) {
            throw new EspacioException();
        }
        if (facturaS.getEntrada() == null) {
            throw new EntradaException();
        }
    }

    
    
    
}
