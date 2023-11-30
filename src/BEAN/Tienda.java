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
public class Tienda {
    private int idTienda;
    private String Tienda;
    private String idUbigeo;
    private String descr; 
    private int idEstado;

    public Tienda() {
    }

    public Tienda(int idTienda, String Tienda, String idUbigeo, String descr, int idEstado) {
        this.idTienda = idTienda;
        this.Tienda = Tienda;
        this.idUbigeo = idUbigeo;
        this.descr = descr;
        this.idEstado = idEstado;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getTienda() {
        return Tienda;
    }

    public void setTienda(String Tienda) {
        this.Tienda = Tienda;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
}
