package BEAN;
public class Proveedor {
    private int idProveedor;
    private String nif;
    private String nombre;
    private String idUbigeo;
    private String direccion;
    private String celular;
    private String telefono;
    private String correo;
    private int estado;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nif, String nombre, String idUbigeo, String direccion, String celular, String telefono, String correo, int estado) {
        this.idProveedor = idProveedor;
        this.nif = nif;
        this.nombre = nombre;
        this.idUbigeo = idUbigeo;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}