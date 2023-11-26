package BEAN;
public class Ubigeo {
    private String idUbigeo;
    private String dept;
    private String prov;
    private String dist;

    public Ubigeo() {
    }

    public Ubigeo(String idUbigeo, String dept, String prov, String dist) {
        this.idUbigeo = idUbigeo;
        this.dept = dept;
        this.prov = prov;
        this.dist = dist;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    
  
}
