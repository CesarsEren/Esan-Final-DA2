/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.TipoComprobante;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author SamCot
 */
public class TipoComprobanteDAO {
    
   //consultar TipoComprobante
    public Vector<TipoComprobante> listaTipoComprobante(boolean sw, String cad){
       Vector<TipoComprobante> listTipComp = new Vector<TipoComprobante>();
       DbBean con = new DbBean();
       String sql="";
       
       sql = "select * from TipoComprobante ";
        
       if(sw==true){
              sql += "where descr like '%" + cad + "%'";
       }
       try{
           ResultSet lista = con.resultadoSQL(sql);
           while(lista.next()){
               TipoComprobante t = new TipoComprobante();
               t.setIdTipComp(lista.getInt(1));
               t.setDescr(lista.getString(2));
               listTipComp.addElement(t);
           }
       }catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       
       try{
           con.desconecta();
       }catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       return listTipComp;
    }
}
