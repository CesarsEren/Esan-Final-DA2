/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Producto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author SamCot
 */
public class ProductoDAO {
        
    //consultar Producto
    public Vector<Producto> listaProducto(boolean sw, String cad){
       Vector<Producto> listProd = new Vector<Producto>();
       DbBean con = new DbBean();
       String sql="";
       
       sql = "select * from producto ";
        
       if(sw==true){
              sql += "where descr like '%" + cad + "%'";
       }
       try{
           ResultSet lista = con.resultadoSQL(sql);
           while(lista.next()){
               Producto p = new Producto();
               p.setIdProducto(lista.getInt(1));
               p.setDescr(lista.getString(2));
               p.setIdCategoria(lista.getInt(3));
               p.setPrecVta(lista.getDouble(4));
               p.setEstado(lista.getInt(5));
               listProd.addElement(p);
           }
       }catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       
       try{
           con.desconecta();
       }catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       return listProd;
    }
    
    //insertar y modificar Producto
    public int procesaProducto(Producto p, String proc){
        int resultado=0;
        DbBean con = new DbBean();
        String sql="";
        
        if(proc.equals("insertar")){
            sql = "insert into producto values(" + p.getIdProducto() + ", '" + p.getDescr() + "', " + p.getIdCategoria();
            sql += ", " + p.getPrecVta() + ", " + p.getEstado() + ")";
        } else {
            sql = "update producto set descr = '" + p.getDescr() + "', idCategoria = " + p.getIdCategoria();
            sql += ", precVta = " + p.getPrecVta() + ", estado = " + p.getEstado() + " where idProducto = " + p.getIdProducto();
        } 
        
        try{
            resultado = con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    //eliminar Producto
    public boolean eliminaProducto(Producto p){
        DbBean con = new DbBean();
        String sql="";
        Boolean sw=true;
        ResultSet lista;
        
        //Verificar que no existan registros en tablas dependientes
        try{
            sql = "select * from DetVenta where idProducto = " + p.getIdProducto();
            lista = con.resultadoSQL(sql);
            if(lista.next()==true){
                sw=false;
            }
            
            sql = "select * from DetCompra where idProducto = " + p.getIdProducto();
            lista = con.resultadoSQL(sql);
            if(lista.next()==true){
                sw=false;
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        //eliminar producto
        try{
            if(sw==true){
                sql = "delete from Producto where idProducto = " + p.getIdProducto();
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
