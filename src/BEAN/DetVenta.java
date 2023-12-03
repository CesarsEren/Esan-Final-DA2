/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;

/**
 *
 * @author xhesm
 */
public class DetVenta {

    private int idVenta;
    private int idDetVenta;
    private int idProducto;
    private int cantidad;
    private double importe;
    private int descuento;

    public DetVenta() {
    }

    public DetVenta(int idVenta, int idDetVenta, int idProducto, int cantidad, double importe, int descuento) {
        this.idVenta = idVenta;
        this.idDetVenta = idDetVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.descuento = descuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdDetVenta() {
        return idDetVenta;
    }

    public void setIdDetVenta(int idDetVenta) {
        this.idDetVenta = idDetVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
