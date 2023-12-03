package BEAN;

public class CabCompra {
    private int idCompra;
    private int idProveedor;
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
    private int estado;

    public CabCompra() {
    }

    public CabCompra(int idCompra, int idProveedor, int idTipComp, String serie, String correlativo, String fecha, double impuesto, double total, int idUsuarioReg, int idUsuarioMod, String fechReg, String fechaMod, int estado) {
        this.idCompra = idCompra;
        this.idProveedor = idProveedor;
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

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
