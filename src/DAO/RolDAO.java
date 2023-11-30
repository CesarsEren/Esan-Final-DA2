/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Rol;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author SamCot
 */
public class RolDAO {
   //consultar Rol
    public Vector<Rol> listaRol(boolean sw, String cad){
        Vector<Rol> listRol = new Vector<Rol>();
        DbBean con = new DbBean();
        String sql="";
        
        sql = "select * from rol ";
        
        if(sw==true){
            sql+= "where rol like '%" + cad + "%' or idrol like '%" + cad + "%'";
        }
        
        try{
            ResultSet lista = con.resultadoSQL(sql);
            while(lista.next()){
                Rol r = new Rol();
                r.setIdRol(lista.getInt(1));
                r.setRol(lista.getString(2));
                listRol.addElement(r);
            }            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listRol;
    }
    
    //insertar y modificar Rol
    public int procesaRol(Rol r, String proc){
        int resultado = 0;
        DbBean con = new DbBean();
        String sql="";
        
        if(proc.equals("insertar")){
            sql="insert into Rol values(" + r.getIdRol() + ", '" + r.getRol()+"')";
        }else{
            sql="update Rol set Rol = " + r.getRol() + " where idRol = " + r.getIdRol();
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
    
    //eliminar Rol
    public boolean eliminaRol(Rol r){
        boolean sw=true;
        DbBean con = new DbBean();
        String sql="";
        ResultSet lista;
        
        //verificar que no existan registros en tablas dependientes
        try{
            sql = "select * from Usuario where idRol = " + r.getIdRol();
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
                sql = "delete from Rol where idRol = " + r.getIdRol();
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
