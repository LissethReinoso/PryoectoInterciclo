/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.*;
import ec.edu.ups.modelo.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lisseth
 */
public class ControladorParqueadero {
    
    private ControladorAdministrador administradorC;
    private ControladorUsuario usuarioC;
    private ControladorCliente clienteC;
    private ControladorVehiculo vehiculoC;
    private ControladorEspacio espacioC;
    private ControladorFacturaEntrada entradaC;
    private ControladorContrato contratoC;
    private ControladorFacturaSalida salidaC;
    private ControladorFacturaContrato contratoFC;
    
    
    public ControladorParqueadero() {
        administradorC = new ControladorAdministrador();
        usuarioC = new ControladorUsuario();
        clienteC = new ControladorCliente();
        vehiculoC = new ControladorVehiculo();
        espacioC = new ControladorEspacio();
        entradaC = new ControladorFacturaEntrada();
        contratoC = new ControladorContrato();
        salidaC = new ControladorFacturaSalida();
        contratoFC = new ControladorFacturaContrato();
    }

    public ControladorParqueadero(ControladorAdministrador administradorC, ControladorUsuario usuarioC, ControladorCliente clienteC, ControladorVehiculo vehiculoC, ControladorEspacio espacioC, ControladorFacturaEntrada entradaC, ControladorContrato contratoC, ControladorFacturaSalida salidaC, ControladorFacturaContrato contratoFC) {
        this.administradorC = administradorC;
        this.usuarioC = usuarioC;
        this.clienteC = clienteC;
        this.vehiculoC = vehiculoC;
        this.espacioC = espacioC;
        this.entradaC = entradaC;
        this.contratoC = contratoC;
        this.salidaC = salidaC;
        this.contratoFC = contratoFC;
    }

    public ControladorAdministrador getAdministradorC() {
        return administradorC;
    }

    public void setAdministradorC(ControladorAdministrador administradorC) {
        this.administradorC = administradorC;
    }

    public ControladorUsuario getUsuarioC() {
        return usuarioC;
    }

    public void setUsuarioC(ControladorUsuario usuarioC) {
        this.usuarioC = usuarioC;
    }

    public ControladorCliente getClienteC() {
        return clienteC;
    }

    public void setClienteC(ControladorCliente clienteC) {
        this.clienteC = clienteC;
    }

    public ControladorVehiculo getVehiculoC() {
        return vehiculoC;
    }

    public void setVehiculoC(ControladorVehiculo vehiculoC) {
        this.vehiculoC = vehiculoC;
    }

    public ControladorEspacio getEspacioC() {
        return espacioC;
    }

    public void setEspacioC(ControladorEspacio espacioC) {
        this.espacioC = espacioC;
    }

    public ControladorFacturaEntrada getEntradaC() {
        return entradaC;
    }

    public void setEntradaC(ControladorFacturaEntrada entradaC) {
        this.entradaC = entradaC;
    }

    public ControladorContrato getContratoC() {
        return contratoC;
    }

    public void setContratoC(ControladorContrato contratoC) {
        this.contratoC = contratoC;
    }

    public ControladorFacturaSalida getSalidaC() {
        return salidaC;
    }

    public void setSalidaC(ControladorFacturaSalida salidaC) {
        this.salidaC = salidaC;
    }

    public ControladorFacturaContrato getContratoFC() {
        return contratoFC;
    }

    public void setContratoFC(ControladorFacturaContrato contratoFC) {
        this.contratoFC = contratoFC;
    }
    
    
    public List<Administrador> administradores() {
        return administradorC.getAdministradores();
    }

    public List<Usuario> usuarios() {
        return usuarioC.getUsuarios();
    }

    public List<Cliente> clientes() {
        return clienteC.getClientes();
    }

    public List<Vehiculo> vehiculos() {
        return vehiculoC.getVehiculos();
    }
    
    
    public List<Espacio>espacios() {
        return espacioC.getEspacios();
    }

    public List<FacturaEntrada> entradas() {
        return entradaC.getEntradas();
    }

    public List<FacturaSalida> salidas() {
        return salidaC.getSalidas();
    }

    public List<Contrato> contratos() {
        return contratoC.getContratos();
    }

    public List<FacturaContrato> facturasC() {
        return contratoFC.getContratosF();
    }
    
    
    public String almacenarAdministrador(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String usuario, String contraseña) throws EspacioException, CedulaException {
        boolean resultado = administradorC.crearAdministrador(cedula, nombre, apellido, telefono, direccion, correo, usuario, contraseña);
        if (resultado == true) {
            return "¡Administrador creado con éxito!";
        }
        return "Error al crear administrador ";
    }

    public String eliminiarAdministrador(int codigo) {
        boolean resultado = administradorC.eliminarAdministrador(codigo);
        if (resultado) {
            return "¡Administrador eliminado con éxito!";
        }
        return "Error al eliminar el Administrador";
    }

    public Administrador buscarAdministrador(String cedula) {
        return administradorC.buscarCedula(cedula);
    }

    public String actualizarAdministrador(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String usuario, String contraseña, Date Fecha) throws EspacioException, CedulaException {
        boolean resultado = this.administradorC.actualizarAdministrador(codigo, usuario, contraseña, cedula, nombre, apellido, telefono, direccion, correo);
        if (resultado == true) {
            return "¡Administrador actualizado con éxito!";
        }
        return "Error al Actulizar el Administrador";
    }

    public String guardarUsuario(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String usuarioD, String contraseña) throws EspacioException, CedulaException {
        boolean resultado = usuarioC.crear(cedula, nombre, apellido, telefono, direccion, correo, usuarioD, contraseña);
        if (resultado == true) {
            return "¡Usuario creado con éxito!";
        }
        return "Error al crear el usuario";
    }

    public String eliminiarUsuario(int codigo) {
        boolean resultado = usuarioC.eliminar(codigo);
        if (resultado) {
            return "¡Usuario climinado con éxito!";
        }
        return "Error al eliminar el Usuario";
    }

    public Usuario buscarUsuario(int codigo) {
        return usuarioC.buscar(codigo);
    }
     public Usuario buscarUsuario(String cedula) {
        return usuarioC.buscarPorCedula(cedula);
    }

    public String actualizarUsuario(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String usuarioD, String contraseña) throws EspacioException, CedulaException {

        boolean usuario = usuarioC.actualizar(codigo, cedula, nombre, apellido, telefono, direccion, correo, usuarioD, contraseña);
        if (usuario == true) {
            return "¡Usuario actualizado con éxito!";
        }
        return "Error al actulizar el Usuario";
    }

    public String guardarCliente(String cedula, String nombre, String apellido, String telefono, String direccion, String correo) throws EspacioException, CedulaException {
        boolean resultado;
        resultado = clienteC.crear(cedula, nombre, apellido, telefono, direccion, correo);
        if (resultado == true) {
            return "¡Cliente Creado con éxito!";
        }
        return "Error al Crear Cliente";
    }

    public String eliminiarCliente(int codigo) {
        boolean resultado = clienteC.eliminar(codigo);
        if (resultado) {
            return "¡Cliente eliminado con éxito!";
        }
        return "Error al eliminar el Cliente";
    }

    public Cliente buscarCliente(int codigo) {
        return clienteC.buscar(codigo);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        return clienteC.buscarCedula(cedula);
    }

    public String actualizarCliente(int codigo, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) throws EspacioException, CedulaException {
        Cliente cliente;
        cliente = clienteC.actualizar(codigo, cedula, nombre, apellido, telefono, direccion, correo);
        if (cliente != null) {
            return "¡Cliente actualizado con éxito!";
        }
        return "Error al actulizar al Cliente";
    }

    public String guardarVehiculo(String placa, String modelo,String marca, Espacio espacio, Cliente cliente) throws EspacioException, PlacaException{
        boolean resultado = vehiculoC.crear(placa, modelo, espacio, cliente, marca);
        if (resultado == true) {
            return "¡Vehiculo Creado con éxito!";
        }
        return "Error al crear  el Vehiculo";
    }

    public String eliminiarVehiculo(int codigo) {
        boolean ban = vehiculoC.eliminar(codigo);
        if (ban) {
            return "Cliente Eliminado con éxito";
        }
        return "Error al eliminar el Cliente";
    }

    public Vehiculo buscarVehiculo(int codigo) {
        return vehiculoC.buscar(codigo);
    }

    public Vehiculo buscarPlaca(String placa) {
        return vehiculoC.buscarAuto(placa);
    }

    public String actualizarVehiculo(int codigo, String placa, String modelo,String marca, Espacio espacio, Cliente cliente) throws EspacioException, PlacaException{
        boolean resultado = vehiculoC.actualizar(codigo, placa, modelo, marca, espacio, cliente);
        if (resultado == true) {
            return "Cliente Actualizado";
        }
        return "Error al Actulizar Cliente";
    }

    public String guardarSitio(int lugar, String estado) throws EspacioException, DisponibilidadException {
        boolean ban = this.espacioC.crear(lugar, estado);
        if (ban == true) {
            return "¡Espacio guardado con éxito!";
        }
        return "Error al guardar en el espacio";
    }

    public String actualizarSitio(int id, int lugar, String estado) throws EspacioException, DisponibilidadException {
        boolean resultado = this.espacioC.actualizar(id, lugar, estado);
        if (resultado == true) {
            return "¡Espacio actualizado con éxito!";
        }
        return "Error de reserva";
    }

    public Espacio buscarEspacio(int posicion) {
        return espacioC.buscar(posicion);
    }

    public Espacio buscarLugar(int lugar) {
        return espacioC.buscarLugar(lugar);
    }

    public String eliminarSitio(int posicion) {
        boolean ban = this.espacioC.eliminar(posicion);
        if (ban == true) {
            return "¡Espacio eliminado con éxito!";
        }
        return "Error al eliminar el espacio";
    }

    public String guardarOrden(Date fechaEntrada, Vehiculo vehiculo) throws EspacioException, VehiculoException {
        boolean ban = entradaC.crear(fechaEntrada, vehiculo);
        if (ban == true) {
            return "Factura de entrada creada con éxito ";
        }
        return "Factura de entrada no ha sido creada";
    }

    public String eliminiarOrden(int codigo) {
        boolean ban = entradaC.eliminar(codigo);
        if (ban) {
            return "¡Factura de entrada eliminada con éxito!";
        }
        return "Error al Eliminar la Factura de Entrada";
    }

    public FacturaEntrada buscarFacturaEntrada(int codigo) {
        return entradaC.buscarOrden(codigo);
    }

    public String actualizarFacturaEntrada(int codigo, Date entrada, Vehiculo vehiculo) throws EspacioException, VehiculoException {
        boolean ban = entradaC.actualizar(codigo, entrada, vehiculo);
        if (ban == true) {
            return "¡Factura de entrada actualizada con éxito!";
        }
        return "Error al actulizar la Factura de Entrada";
    }

    public String almacenarContrato(Cliente cliente, Vehiculo vehiculo, Date fechaEntrada) throws EspacioException, ClienteException, VehiculoException {
        boolean ban = contratoC.crear(cliente, vehiculo, fechaEntrada);
        if (ban == true) {
            return "¡Contrato Creado con éxito!";
        }
        return "No se ha podido realizar el contrato";
    }

    public String eliminarContrato(int codigo) {
        boolean ban = contratoC.eliminar(codigo);
        if (ban) {
            return "¡Contrato eliminado con éxito!";
        }
        return "¡Error al Eliminar el Contrato!";
    }

    public Contrato buscarContrato(int codigo) {
        return contratoC.buscar(codigo);
    }

    public String actualizarContrato(int codigo, Cliente cliente, Vehiculo vehiculo, Date fechaEntrada) throws EspacioException, ClienteException, VehiculoException {
        boolean resultado = contratoC.actualizar(codigo, cliente, vehiculo, fechaEntrada);
        if (resultado == true) {
            return "Contrato Actualizado";
        }
        return "Error al Actualizar Contrato";
    }

    public String guardarFacturaSalida(String cedula, FacturaEntrada entrada, Date Salida, double descuento, double total) throws DisponibilidadException, EspacioException, EntradaException {
        boolean ban = salidaC.crearFacturaSalida(cedula, entrada, Salida, descuento, total);
       
        if (ban == true) {
            return "Factura final creada con éxito";
        }
        return "La factura final no se pudo crear";
    }

    public String guardarFacturaContrato(String cedula, Contrato contrato, Date salida, double descuento,double multa, double total) throws ContratoException, EspacioException {
        boolean ban = contratoFC.crearContratoF(cedula, contrato, salida, descuento, multa, total);
  
        if (ban == true) {
            return "¡Factura de Contrato creada con éxito!";
        }
        return "La factura de Contrato no a podido ser creada";
    }

    public String eliminarFacturaDeContrato(int codigo) {
        boolean ban = contratoFC.eliminarC(codigo);
        if (ban) {
            return "¡Factura de Contrato eliminada con éxito!";
        }
        return "Error al Eliminar el Factura Contrato";
    }

    public String eliminiarFacturaDeEntrada(int codigo) {
        boolean ban = entradaC.eliminar(codigo);
        if (ban) {
            return "Factura de entrada eliminada con éxito";
        }
        return "Error al Eliminar el Factura Orden";
    }

    public FacturaSalida buscaFactura(int codigo) {
        return salidaC.buscar(codigo);
    }

    public FacturaContrato buscaFacturaContrato(int codigo) {
        return contratoFC.buscarC(codigo);
    }

    public String actualizarFacturaSalida(int codigo, String cedula, FacturaEntrada entrada, Date Salida, double descuento, double total) throws DisponibilidadException, EspacioException, EntradaException {
        boolean ban =salidaC.actualizar(codigo, cedula, entrada, Salida, descuento, total);
                
        if (ban == true) {
            return "Factura actualizada con éxito";
        }
        return "Error al Actualizar  la factura";
    }

    public String actualizarFacturaDeContrato(int codigo, String cedula, Contrato contrato, Date salida, double descuento,double multa, double total) throws ContratoException, EspacioException {
        boolean resultado = contratoFC.actualizarC(codigo, cedula, contrato, salida, descuento,multa, total);
        if (resultado == true) {
            return "¡Factura actualizada con éxito!";
        }
        return "Error al Actualizar la factura";
    }
    
    
    
}
