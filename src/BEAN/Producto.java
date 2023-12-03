package BEAN;

public class Producto {
    private int idProducto;
    private String descr;
    private int idCategoria;
    private double precVta;
    private int estado;

    public Producto() {
    }

    public Producto(int idProducto, String descr, int idCategoria, double precVta, int estado) {
        this.idProducto = idProducto;
        this.descr = descr;
        this.idCategoria = idCategoria;
        this.precVta = precVta;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecVta() {
        return precVta;
    }

    public void setPrecVta(double precVta) {
        this.precVta = precVta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
            
}