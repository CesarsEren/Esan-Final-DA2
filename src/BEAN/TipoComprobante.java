package BEAN;

public class TipoComprobante {
    private int idTipComp;
    private String descr;

    public TipoComprobante() {
    }

    public TipoComprobante(int idTipComp, String descr) {
        this.idTipComp = idTipComp;
        this.descr = descr;
    }

    public int getIdTipComp() {
        return idTipComp;
    }

    public void setIdTipComp(int idTipComp) {
        this.idTipComp = idTipComp;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

}