package BEAN;

public class Categoria {
    private int idCategoria;
    private String descr;
    private int estado;

    public Categoria() {
    }

    public Categoria(int idCategoria, String descr, int estado) {
        this.idCategoria = idCategoria;
        this.descr = descr;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
