/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author Usuario
 */

//AGREGO CLASE GENÉRICA
public class Administrador <T> extends Persona {
    
    private int codigo;
    private String usuario;
    private String contrasenia;

    public Administrador() {
    }

    public Administrador( String cedula, String nombre, String apellido, String telefono, String direccion,int codigo, String correo,String usuario, String contrasenia) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.codigo = codigo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
        final Administrador<?> other = (Administrador<?>) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "codigo=" + codigo + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }

   

    
    
    
    
    
    
    
    
    
}
