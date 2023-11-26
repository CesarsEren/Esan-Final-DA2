package DAO;

import BEAN.Proveedor;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProveedorDAO {
    public ProveedorDAO(){
    
    }

    //Read (Select)
    public Vector<Proveedor> listarProveedor(boolean sw, String str){
        DbBean con = new DbBean();
        Vector<Proveedor> listaProv = new Vector<Proveedor>();
        String sql = "Select * from Proveedor";
      
        
        if(sw == true){
            sql = sql + " WHERE nombre LIKE '"+ str +"%'";
        }
        
        try {
        ResultSet listaResult;     //aqui el resulset se importa de la libreria de java
        listaResult = con.resultadoSQL(sql);
        while(listaResult.next()){
            Proveedor prov = new Proveedor();
            prov.setIdProveedor(listaResult.getInt(1));
            prov.setNif(listaResult.getString(2));
            prov.setNombre(listaResult.getString(3));
            prov.setIdUbigeo(listaResult.getString(4));
            prov.setDireccion(listaResult.getString(5));
            prov.setCelular(listaResult.getString(6));
            prov.setTelefono(listaResult.getString(7));
            prov.setCorreo(listaResult.getString(8));
            prov.setEstado(listaResult.getInt(9));
            listaProv.addElement(prov);
        } 
    } catch (java.sql.SQLException e){
            e.printStackTrace();
    }
    try {
         con.desconecta();
    }catch(java.sql.SQLException e){
        e.printStackTrace();
        }
        return listaProv;
    }
    
    //Insertar Proveedor(insert)
    
    public void insertaProveedor(Proveedor p){
        DbBean con = new DbBean();
        String sql = "";
        try{
            sql = "insert into Proveedor values(";
            sql = sql + " "+ p.getIdProveedor() +", '"+ p.getNif() +"', ";
            sql = sql + " '"+ p.getNombre() +"', '"+ p.getIdUbigeo() +"', '"+ p.getDireccion() +"', ";
            sql = sql + " '"+ p.getCelular() +"', '"+ p.getTelefono() +"', '"+ p.getCorreo() +"', ";
            sql = sql + " "+ p.getEstado() +")";
            
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    //Actualizar (Update)
    
    public void actualizaProveedor(Proveedor p){
        DbBean con = new DbBean();
        String sql = "";
        
        try{
            sql = "update Proveedor set nif = '"+ p.getNif()+"', ";
            sql += " nombre = '"+ p.getNombre()+"', idUbigeo = '"+ p.getIdUbigeo()+"', ";
            sql += " direccion = '"+ p.getDireccion()+"', celular = '"+ p.getCelular()+"', ";
            sql += " telefono = '"+ p.getTelefono()+"', ";
            sql += " correo = '"+ p.getCorreo()+"', estado = "+ p.getEstado();
            sql += " where idProveedor = "+ p.getIdProveedor() +"";
            
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    //eliminar Tienda
    public boolean eliminaProveedor(Proveedor t){
        boolean sw = true;
        DbBean con = new DbBean();
        String sql;
        
        //verificar que no existan registros en tablas dependientes
        try{
                sql= "select * from CabCompra where idProveedor = " + t.getIdProveedor();
                ResultSet result = con.resultadoSQL(sql);
                if(result.next()==true){
                    sw=false;
                }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        //eliminar Proveedor
        try{
                if(sw = true){
                    sql = "delete from Proveedor where idProveedor = " + t.getIdProveedor();
                    con.ejecutaSQL(sql);
                    }    
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
                con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return sw;
    }
         
}
