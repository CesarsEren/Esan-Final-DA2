
package DAO;

import BEAN.Ubigeo;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class UbigeoDAO {
    public UbigeoDAO(){
    
    }
    //Read (Select)
    public Vector<Ubigeo> listarUbigeo(boolean sw, String str){
        DbBean con = new DbBean();
        Vector<Ubigeo> listaUbig = new Vector<Ubigeo>();
        String sql = "Select * from Ubigeo";
      
        
        if(sw == true){
            sql = sql + " WHERE dept LIKE '%"+ str +"%' or prov LIKE '%"+ str +"%' or dist LIKE '%"+ str +"%'";
            
        }
        
        try {
        ResultSet listaResult;     //aqui el resulset se importa de la libreria de java
        listaResult = con.resultadoSQL(sql);
        while(listaResult.next()){
            Ubigeo Ubig = new Ubigeo();
            Ubig.setIdUbigeo(listaResult.getString(1));
            Ubig.setDept(listaResult.getString(2));
            Ubig.setProv(listaResult.getString(3));
            Ubig.setDist(listaResult.getString(4));
            listaUbig.addElement(Ubig);
        } 
    } catch (java.sql.SQLException e){
            e.printStackTrace();
    }
    try {
         con.desconecta();
    }catch(java.sql.SQLException e){
        e.printStackTrace();
        }
        return listaUbig;
    }

}
