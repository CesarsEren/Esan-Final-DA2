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
public class DetCompra {
    private int idCompra;
    private int idDetCompra;
    private int idProducto;
    private double cantidad;
    private double importe;
    private double descuento;

    public DetCompra(int idCompra, int idDetCompra, int idProducto, double cantidad, double importe, double descuento) {
        this.idCompra = idCompra;
        this.idDetCompra = idDetCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.descuento = descuento;
    }

    public DetCompra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdDetCompra() {
        return idDetCompra;
    }

    public void setIdDetCompra(int idDetCompra) {
        this.idDetCompra = idDetCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
    
}
