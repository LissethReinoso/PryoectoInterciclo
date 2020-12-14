/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;

import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lisseth
 */
public class ControladorUsuario {
    
    
    public List<Usuario> usuarios;

    public ControladorUsuario() {
         usuarios = new ArrayList<Usuario>();
    }

    public ControladorUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

    public boolean crear(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String usuarioD, String contraseña) throws EspacioException, CedulaException {
        Usuario usuario = new Usuario(generarCodigo(), cedula, nombre, apellido, telefono, direccion, correo, usuarioD, contraseña);
        validarCampos(usuario);
        return usuarios.add(usuario);
    }
    
    public boolean eliminar(int codigo) {
        return usuarios.remove(this.buscar(codigo));
    }
    
    public Usuario buscar(int codigo) {
        for (Usuario us : usuarios) {
            if (us.getCodigo() == codigo) {
                return us;
            }
        }
        return null;
    }
    
    public Usuario buscarU(String nick) {
        for (Usuario us : usuarios) {
            if (us.getNick().equals(nick)) {
                return us;
            }
        }
        return null;
    }
    
     public int generarCodigo() {
        if (usuarios.size() > 0) {
            Usuario usuario = usuarios.get(usuarios.size() - 1);
            return usuario.getCodigo() + 1;
        }
        return 0;
    }
    
    public Usuario buscarPorCedula(String cedula) {
        for (Usuario us : usuarios) {
            if (us.getCedula().equals(cedula)) {
                return us;
            }
        }
        return null;
    }
    public int buscarPorPosicion(int codigo) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario us = usuarios.get(i);
            if (us.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean actualizar(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String nick, String contrasenia) throws EspacioException, CedulaException {
        Usuario usuario = this.buscar(codigo);
        if (usuario != null) {
            usuario.setApellido(apellido);
            usuario.setContrasenia(contrasenia);
            usuario.setCorreo(correo);
            usuario.setDireccion(direccion);
            usuario.setNombre(nombre);
            usuario.setTelefono(telefono);
            usuario.setNick(nick);
            validarCampos(usuario);
            usuarios.set(codigo, usuario);
            return true;
        }
        return false;
    }

    public static void validarCampos(Usuario usuario) throws EspacioException, CedulaException {
        if (usuario.getApellido().equals("") || usuario.getContrasenia().equals("") || usuario.getCorreo().equals("") || usuario.getDireccion().equals("") || usuario.getNombre().equals("") || usuario.getTelefono().equals("") || usuario.getNick().equals("")) {
            throw new EspacioException();
        }
        if (usuario.getCedula().length() != 10 || validarCedula(usuario.getCedula()) == false || usuario.getCedula().contains("-") == true) {
            throw new CedulaException();
        }
    }

    public static boolean validarCedula(String cedula) {
        char digito[] = cedula.toCharArray();
        int total = 0;
        for (int i = 0; i < digito.length - 1; i++) {
            int dato = Integer.parseInt(digito[i] + "");
            if (i % 2 == 0) {
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
