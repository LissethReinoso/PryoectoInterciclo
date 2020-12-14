/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.Administrador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class ControladorAdministrador {
 
    
    private List<Administrador> administradores;

    public ControladorAdministrador(List<Administrador> administradores) {
        this.administradores =administradores;
    }

    public ControladorAdministrador() {
        administradores = new ArrayList<Administrador>();
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    

    public int generarCodigo() {
        if (administradores.size() > 0) {
            return administradores.get(administradores.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public boolean crearAdministrador(String cedula, String nombre, String apellido, String telefono, String direccion, String correo,String usuario, String contraseña) throws EspacioException, CedulaException{
        Administrador ad = new Administrador( cedula, nombre, apellido, telefono, direccion,generarCodigo(), correo,usuario, contraseña);
        validacion(ad);
        return administradores.add(ad);
    }

    
    
    public boolean eliminarAdministrador(int codigo) {
        Administrador a= this.buscarCodigo(codigo);
        if (a != null) {
            return administradores.remove(a);
        }
        return false;

    }

    public int posicion(int codigo) {
        for (int i = 0; i < administradores.size(); i++) {
            Administrador p = administradores.get(i);
            if (p.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public Administrador buscarCedula(String cedula) {
        for (Administrador a : administradores) {
            if (a.getCedula().equals(cedula)) {
                return a;
            }
        }
        return null;
    }

    public Administrador buscarCodigo(int codigo) {
        for (Administrador a : administradores) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }

    public boolean actualizarAdministrador(int codigo, String usuario, String contraseña, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) throws EspacioException {
        Administrador a = this.buscarCodigo(codigo);
        if (a != null) {
            a.setApellido(apellido);
            a.setContrasenia(contraseña);
            a.setCorreo(correo);
            a.setDireccion(direccion);
            a.setNombre(nombre);
            a.setTelefono(telefono);
            a.setUsuario(usuario);
            validacion(a);
            administradores.set(this.posicion(codigo), a);
            return true;
        }
        return false;
    }
    
    
    
        public static void validacion(Administrador administrador)throws EspacioException{
        if(administrador.getApellido().equals("")||administrador.getContrasenia().equals("")||administrador.getCorreo().equals("")||administrador.getDireccion().equals("")||administrador.getNombre().equals("")||administrador.getTelefono().equals("")){
            throw new EspacioException();
        }if(administrador.getCedula().length()!=10||validarCedula(administrador.getCedula())==false||administrador.getCedula().contains("-")==true){
            try {
                throw new CedulaException();
            } catch (CedulaException ex) {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        //REGEX
    public static boolean validarCedula(String cedula) {
        
        
        char digito[] = cedula.toCharArray();
        int total = 0;
        for (int i = 0; i < digito.length-1; i++) {
            int dato = Integer.parseInt(digito[i]+"");
            if(i % 2 == 0) {
                if(dato * 2 > 9) {
                    dato = (dato * 2) - 9;
                } else {
                    dato = dato * 2;
                }
            }
            total += dato;
        }
        int ultimo = Integer.parseInt(digito[digito.length-1]+"");
        if(total % 10 == 0 && 0 == ultimo ) {
            return true;
        }else {
            total = 10 - total % 10;
            if( total == ultimo) {
                return true;
            }
        }
        return false;
    }
    
    
    public static boolean validacionCedula(String cedula) {
        return cedula.matches("^[0-9]$");
    }

}
