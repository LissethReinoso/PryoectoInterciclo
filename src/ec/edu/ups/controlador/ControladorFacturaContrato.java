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
public class ControladorFacturaContrato {
    
    
    private List<FacturaContrato> contratosF;

    public ControladorFacturaContrato() {
        contratosF = new ArrayList<FacturaContrato>();
    }

    public List<FacturaContrato> getContratosF() {
        return contratosF;
    }

    public void setContratosF(List<FacturaContrato> contratosF) {
        this.contratosF = contratosF;
    }
    
     public int generarCodigo() {
        if (contratosF.size() > 0) {
            FacturaContrato factura = contratosF.get(contratosF.size() - 1);
            return factura.getCodigo() + 1;
        }
        return 0;
    }

    public boolean crearContratoF(String cedula, Contrato contrato,  Date salida, double descuento,double multa, double total) throws EspacioException, ContratoException {
        FacturaContrato contF = new FacturaContrato(generarCodigo(), cedula, contrato, salida, descuento,multa, total);
        validarCamposC(contF);
        return contratosF.add(contF);
    }
     public FacturaContrato buscarC(int codigo) {
        for (FacturaContrato conF : contratosF) {
            if (conF.getCodigo() == codigo) {
                return conF;
            }
        }
        return null;
    }
    public boolean eliminarC(int codigo) {
        return contratosF.remove(this.buscarC(codigo));
    }
    public int buscarPosicion(int codigo) {
        for (int i = 0; i < contratosF.size(); i++) {
            FacturaContrato f = contratosF.get(i);
            if (f.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
    public boolean actualizarC(int codigo, String cedula, Contrato contrato, Date salida, double descuento,double multa, double total) throws EspacioException, ContratoException {
        FacturaContrato conF = this.buscarC(codigo);
        if (conF != null) {
            conF.setDescuento(descuento);
            conF.setSalida(salida);
            validarCamposC(conF);
            contratosF.set(codigo, conF);
            return true;
        }
        return false;
    }
     public static void validarCamposC(FacturaContrato factura) throws EspacioException, ContratoException {
        if (factura.getSalida().equals("") ) {
            throw new EspacioException();
        }
        if (factura.getContrato() == null) {
            throw new ContratoException();
        }
    }
    
    
}
