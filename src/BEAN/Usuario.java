/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

/**
 *
 * @author SamCot
 */
public class Usuario {
     private int idUsuario;
    private String Usuario;
    private String contrasenia;
    private int idTrabajador;
    private int idTienda;
    private int idRol;
    private int estado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String Usuario, String contrasenia, int idTrabajador, int idTienda, int idRol, int estado) {
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.contrasenia = contrasenia;
        this.idTrabajador = idTrabajador;
        this.idTienda = idTienda;
        this.idRol = idRol;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
