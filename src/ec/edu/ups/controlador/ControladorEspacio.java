/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.Espacio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lisseth
 */
public class ControladorEspacio {

    private static List<Espacio> espacios;


    public ControladorEspacio() {
        espacios = new ArrayList<Espacio>();

    }

    public ControladorEspacio(List<Espacio> espacios) {
        this.espacios = espacios;
    }

    public static List<Espacio> getEspacios() {
        return espacios;
    }

    public static void setEspacios(List<Espacio> espacios) {
        ControladorEspacio.espacios = espacios;
    }

    

    public boolean crear(int espacio, String disponible) throws EspacioException, DisponibilidadException {
        Espacio esp = new Espacio(generarCodigo(), espacio, disponible);
        validarEspacio(esp);
        return espacios.add(esp);
    }

    public Espacio buscar(int codigo) {
        for (Espacio esp : espacios) {
            if (esp.getCodigo() == codigo) {
                return esp;
            }
        }
        return null;
    }
    
    
    public boolean actualizar(int codigo, int espacio, String disponibilidad) throws EspacioException, DisponibilidadException {
        Espacio esp = this.buscar(codigo);
        if (esp != null) {
            esp.setDisponible(disponibilidad);
            esp.setEspacio(espacio);
           
            validarEspacio(esp);
            espacios.set(codigo, esp);
            return true;
        }
        return false;
    }

    public Espacio buscarLugar(int lugar) {
        for (Espacio esp : espacios) {
            if (esp.getEspacio() == lugar) {
                return esp;
            }
        }
        return null;
    }

    public boolean eliminar(int codigo) {
        return espacios.remove(this.buscar(codigo));
    }

    public int generarCodigo() {
        if (espacios.size() > 0) {
            Espacio esp = espacios.get(espacios.size() - 1);
            return esp.getCodigo() + 1;
        }
        return 0;
    }
    
    
    public int buscarPosicion(int codigo) {
        for (int i = 0; i < espacios.size(); i++) {
            Espacio espacio = espacios.get(i);
            if (espacio.getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    

    public static void validarEspacio(Espacio esp) throws EspacioException, DisponibilidadException {
        if (esp.getEspacio() < 0 || esp.getEspacio() > 50) {
            throw new EspacioException();
        }
        if (estado(esp.getEspacio()) != null) {
           throw  new DisponibilidadException();
        }
        }
    
    
    private static Espacio estado(int e) {
        for (Espacio esp : espacios) {
            if(esp.getEspacio()==e && esp.getDisponible().equalsIgnoreCase("Ocupado")||esp.getEspacio()==e && esp.getDisponible().equalsIgnoreCase("Contratado")){
                return esp;
            }
        }
        return null;
    }
    
    
    }



