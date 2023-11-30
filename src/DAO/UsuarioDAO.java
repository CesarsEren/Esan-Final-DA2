package DAO;

import BEAN.Usuario;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class UsuarioDAO {
     //consultar Usuario
    public Vector<Usuario> listaUsuario(boolean sw, String cad){
        Vector<Usuario> listUsu = new Vector<Usuario>();
        DbBean con = new DbBean();
        String sql="";
        
        sql = "select * from usuario ";
        
        if(sw==true){
            sql+= "where usuario like '%" + cad + "%'";
        }
        
        try{
            ResultSet lista = con.resultadoSQL(sql);
            while(lista.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(lista.getInt(1));
                u.setUsuario(lista.getString(2));
                u.setContrasenia(lista.getString(3));
                u.setIdTrabajador(lista.getInt(4));
                u.setIdTienda(lista.getInt(5));
                u.setIdRol(lista.getInt(6));
                u.setEstado(lista.getInt(7));
                listUsu.addElement(u);
            }            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listUsu;
    }
    
    //insertar y modificar Usuario
    public int procesaUsuario(Usuario u, String proc){
        int resultado = 0;
        DbBean con = new DbBean();
        String sql="";
        
        if(proc.equals("insertar")){
            sql="insert into Usuario values(" + u.getIdUsuario()+ ", '" + u.getUsuario() + "', '" + u.getContrasenia() ;
            sql += "', " + u.getIdTrabajador() + ", " + u.getIdTienda() + ", " + u.getIdRol() + ", " + u.getEstado() + ")";
        }else{
            sql="update Usuario set usuario = '" + u.getUsuario() + "', contrasenia = '" + u.getContrasenia();
            sql += "', idTrabajador = " + u.getIdTrabajador() + ", idTienda = " + u.getIdTienda() + ", idRol = " + u.getIdRol() + ", estado = " + u.getEstado();
            sql += " where idUsuario = " + u.getIdUsuario();
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
    
    //eliminar Usuario
    public boolean eliminaUsuario(Usuario u){
        boolean sw=true;
        DbBean con = new DbBean();
        String sql="";
        ResultSet lista;
        
        //verificar que no existan registros en tablas dependientes
        try{
            sql = "select * from CabVenta where idUsuario = " + u.getIdUsuario();
            lista=con.resultadoSQL(sql);
            
            if(lista.next()==true){
                sw=false;
            }
            
            sql = "select * from CabCompra where idUsuario = " + u.getIdUsuario();
            lista=con.resultadoSQL(sql);
            
            if(lista.next()==true){
                sw=false;
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        //eliminar usuario
        try{
            if(sw==true){
                sql = "delete from Usuario where idUsuario = " + u.getIdUsuario();
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
