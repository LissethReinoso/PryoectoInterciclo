/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Lisseth 
 */
public class Usuario extends Persona {
    
    private int codigo;
    private String nick;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(int codigo, String nick, String contrasenia, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.codigo = codigo;
        this.nick = nick;
        this.contrasenia = contrasenia;
    }

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", usuario=" + nick + ", contraseña=" + contrasenia + '}';
    }
    
    
    
    
    
    
}
