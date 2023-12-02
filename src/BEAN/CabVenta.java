/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;

/**
 *
 * @author xhesm
 */
public class CabVenta {

    private int idVenta;
    private int idCliente;
    private int idTipComp;
    private String serie;
    private String correlativo;
    private String fecha;
    private double impuesto;
    private double total;
    private int idUsuarioReg;
    private int idUsuarioMod;
    private String fechReg;
    private String fechaMod;
    private boolean estado;

    public CabVenta(int idVenta, int idCliente, int idTipComp, String serie, String correlativo, String fecha, double impuesto, double total, int idUsuarioReg, int idUsuarioMod, String fechReg, String fechaMod, boolean estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idTipComp = idTipComp;
        this.serie = serie;
        this.correlativo = correlativo;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.total = total;
        this.idUsuarioReg = idUsuarioReg;
        this.idUsuarioMod = idUsuarioMod;
        this.fechReg = fechReg;
        this.fechaMod = fechaMod;
        this.estado = estado;
    }

    public CabVenta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipComp() {
        return idTipComp;
    }

    public void setIdTipComp(int idTipComp) {
        this.idTipComp = idTipComp;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdUsuarioReg() {
        return idUsuarioReg;
    }

    public void setIdUsuarioReg(int idUsuarioReg) {
        this.idUsuarioReg = idUsuarioReg;
    }

    public int getIdUsuarioMod() {
        return idUsuarioMod;
    }

    public void setIdUsuarioMod(int idUsuarioMod) {
        this.idUsuarioMod = idUsuarioMod;
    }

    public String getFechReg() {
        return fechReg;
    }

    public void setFechReg(String fechReg) {
        this.fechReg = fechReg;
    }

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
