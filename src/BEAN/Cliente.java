/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;

/**
 *
 * @author xhesm
 */
public class Cliente {

    private int idCliente;
    private String nif;
    private String nombre;
    private String idUbigeo;
    private String direccion;
    private String celular;
    private String telefono;
    private String correo;
    private short estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String nif, String nombre, String idUbigeo, String direccion, String celular, String telefono, String correo, short estado) {
        this.idCliente = idCliente;
        this.nif = nif;
        this.nombre = nombre;
        this.idUbigeo = idUbigeo;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

}
