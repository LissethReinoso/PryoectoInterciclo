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
public class ControladorContrato {
    
    
     private List<Contrato> contratos;

    public ControladorContrato() {
        contratos = new ArrayList<Contrato>();
    }

    public ControladorContrato(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public int generarCodigo() {
        if (contratos.size() > 0) {
            Contrato contrato = contratos.get(contratos.size() - 1);
            return contrato.getCodigo() + 1;
        }
        return 0;
    }

    public boolean crear(Cliente cliente,Vehiculo vehiculo, Date fechaEntrada) throws EspacioException, ClienteException, VehiculoException {
        Contrato contrato = new Contrato(generarCodigo(),cliente,  vehiculo, fechaEntrada);
        validarCampos(contrato);
        return contratos.add(contrato);
    }

    public Contrato buscar(int codigo) {
        for (Contrato cont : contratos) {
            if (cont.getCodigo() == codigo) {
                return cont;
            }
        }
        return null;
    }

    public boolean eliminar(int codigo) {
        return contratos.remove(this.buscar(codigo));
    }

    public int buscarPosicion(int codigo) {
        for (int i = 0; i < contratos.size(); i++) {
            Contrato c = contratos.get(i);
            if (c.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public boolean actualizar(int codigo,Cliente cliente, Vehiculo vehiculo, Date Entrada) throws EspacioException, ClienteException, VehiculoException {
        Contrato cont = this.buscar(codigo);
        if (cont != null) {
            cont.setEntrada(Entrada);
            cont.setCliente(cliente);
            cont.setVehiculo(vehiculo);
            validarCampos(cont);
            contratos.set(codigo, cont);
            return true;
        }
        return false;
    }
    public static void validarCampos(Contrato contrato) throws EspacioException, ClienteException, VehiculoException {
        if (contrato.getEntrada().equals("")) {
            throw new EspacioException();
        }
        if (contrato.getCliente() == null) {
            throw new ClienteException();
        }if(contrato.getVehiculo() == null){
            throw new VehiculoException();
        }   
    }

}
