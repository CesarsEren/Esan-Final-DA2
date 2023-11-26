/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;

/**
 *
 * @author xhesm
 */
public class Tienda {

    private int idTienda;
    private String Tienda;
    private String idUbigeo;
    private String descr;
    private short idEstado;

    public Tienda() {
    }

    public Tienda(int idTienda, String Tienda, String idUbigeo, String descr, short idEstado) {
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

    public short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(short idEstado) {
        this.idEstado = idEstado;
    }

}
