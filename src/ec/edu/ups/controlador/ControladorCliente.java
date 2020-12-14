/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lisseth
 */
public class ControladorCliente {
    
    private List<Cliente> clientes;

    public ControladorCliente() {
        clientes = new ArrayList<Cliente>();
    }

    public ControladorCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

   

    

    public int generarCodigo() {
        if (clientes.size() > 0) {
            Cliente cliente = clientes.get(clientes.size() - 1);
            return cliente.getCodigo() + 1;
        }
        return 0;
    }

    public boolean crear(String cedula, String nombre, String apellido, String telefono, String direccion, String correo) throws EspacioException, CedulaException {
        Cliente cliente = new Cliente(generarCodigo(), cedula, nombre, apellido, telefono, direccion, correo);
        validarCampos(cliente);
        return clientes.add(cliente);
    }

    public Cliente buscar(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminar(int codigo) {
        return clientes.remove(this.buscar(codigo));
    }

    public int buscarPosicion(int codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public Cliente actualizar(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) throws EspacioException, CedulaException {
        Cliente cliente = this.buscar(codigo);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        validarCampos(cliente);
        return clientes.set(codigo, cliente);
    }

    public static void validarCampos(Cliente cliente) throws EspacioException, CedulaException {
        if (cliente.getApellido().equals("") || cliente.getCorreo().equals("") || cliente.getDireccion().equals("") || cliente.getNombre().equals("") || cliente.getTelefono().equals("")) {
            throw new EspacioException();
        }
        if (cliente.getCedula().length() != 10 || validarCedula(cliente.getCedula()) == false || cliente.getCedula().contains("-") == true) {
            throw new CedulaException();
        }
    }

    
    //REGEX
    public static boolean validarCedula(String cedula) {
        char digito[] = cedula.toCharArray();
        int total = 0;
        for (int i = 0; i < digito.length - 1; i++) {
            int dato = Integer.parseInt(digito[i] + "");
            if (i % 2 == 0) {
                //dato = dato*2 > 9 ? dato*2 - 9 : dato*2;
                if (dato * 2 > 9) {
                    dato = (dato * 2) - 9;
                } else {
                    dato = dato * 2;
                }
            }
            total += dato;
        }
        int ultimo = Integer.parseInt(digito[digito.length - 1] + "");
        if (total % 10 == 0 && 0 == ultimo) {
            return true;
        } else {
            total = 10 - total % 10;
            if (total == ultimo) {
                return true;
            }
        }
        return false;
    }
    
    
}
