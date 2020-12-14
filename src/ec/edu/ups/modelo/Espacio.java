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
public class Espacio <T> {
    
    private int codigo;
    private int espacio;
    private String disponible;

    public Espacio() {
    }

    public Espacio(int codigo, int espacio, String disponible) {
        this.codigo = codigo;
        this.espacio = espacio;
        this.disponible = disponible;
    }

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    
    @Override
    public String toString() {
        return "Espacio{" + "codigo=" + codigo + ", espacio=" + espacio + ", disponible=" + disponible + '}';
    }

    
    
}
