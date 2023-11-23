/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;

import java.time.LocalDate;

/**
 *
 * @author xhesm
 */
public class Trabajador {

    private int idTrabajador;
    private int idPuesto;
    private String docIdent;
    private String nombre;
    private String apePat;
    private String apeMat;
    private String ubigeo;
    private String direccion;

    private int genero;
    private LocalDate fecha_nacimiento;
    private String celular;
    private String telefono;
    private String correo;
    private short estado;

    public Trabajador() {
    }

    public Trabajador(int idTrabajador, int idPuesto, String docIdent, String nombre, String apePat, String apeMat, String ubigeo, String direccion, int genero, LocalDate fecha_nacimiento, String celular, String telefono, String correo, short estado) {
        this.idTrabajador = idTrabajador;
        this.idPuesto = idPuesto;
        this.docIdent = docIdent;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.ubigeo = ubigeo;
        this.direccion = direccion;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }
    
    

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getDocIdent() {
        return docIdent;
    }

    public void setDocIdent(String docIdent) {
        this.docIdent = docIdent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trabajador{");
        sb.append("idTrabajador=").append(idTrabajador);
        sb.append(", idPuesto=").append(idPuesto);
        sb.append(", docIdent=").append(docIdent);
        sb.append(", nombre=").append(nombre);
        sb.append(", apePat=").append(apePat);
        sb.append(", apeMat=").append(apeMat);
        sb.append(", ubigeo=").append(ubigeo);
        sb.append(", direccion=").append(direccion);
        sb.append(", genero=").append(genero);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", celular=").append(celular);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    
}
