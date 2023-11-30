/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Categoria;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CategoriaDAO {
     //consultar Categoria
    public Vector<Categoria> listaCategoria(boolean sw, String cad){
        Vector<Categoria> listCat = new Vector<Categoria>();
        DbBean con = new DbBean();
        String sql="";
        
        sql = "select * from Categoria ";
        
        if(sw==true){
            sql+= "where descr like '%" + cad + "%' or  idCategoria like '%" + cad + "%'";
        }
        
        try{
            ResultSet lista = con.resultadoSQL(sql);
            while(lista.next()){
                Categoria c = new Categoria();
                c.setIdCategoria(lista.getInt(1));
                c.setDescr(lista.getString(2));
                c.setEstado(lista.getInt(3));
                listCat.addElement(c);
            }            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listCat;
    }
    
    //insertar y modificar Categoria
    public int procesaRol(Categoria c, String proc){
        int resultado = 0;
        DbBean con = new DbBean();
        String sql="";
        
        if(proc.equals("insertar")){
            sql="insert into Categoria values(" + c.getIdCategoria()+ ", '" + c.getDescr()+ "', " + c.getEstado() +")";
        }else{
            sql="update Categoria set Descr = '" + c.getDescr() + "', estado = " + c.getEstado() +" where IdCategoria = " + c.getIdCategoria();
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
    
    //eliminar Categoria
    public boolean eliminaCategoria(Categoria c){
        boolean sw=true;
        DbBean con = new DbBean();
        String sql="";
        ResultSet lista;
        
        //verificar que no existan registros en tablas dependientes
        try{
            sql = "select * from producto where idCategoria = " + c.getIdCategoria();
            lista=con.resultadoSQL(sql);
            
            if(lista.next()==true){
                sw=false;
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        //eliminar rol
        try{
            if(sw==true){
                sql = "delete from Categoria where idCategoria = " + c.getIdCategoria();
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
