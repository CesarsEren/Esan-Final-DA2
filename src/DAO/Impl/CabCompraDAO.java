package DAO.Impl;

import BEAN.CabCompra;
import DAO.Conexion;
//import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CabCompraDAO extends Conexion {

    //consultar CabCompra
    public Vector<CabCompra> listaCabCompra(boolean sw, String cad) {
        Vector<CabCompra> listCabComp = new Vector<CabCompra>();
        // DbBean con = new DbBean();
        String sql = "";

        sql = "select * from CabCompra ";

        if (sw == true) {
            sql += "where idCompra like '%" + cad + "%'";
        }

        try {
            ResultSet lista = resultadoSQL(sql);
            while (lista.next()) {
                CabCompra c = new CabCompra();
                c.setIdCompra(lista.getInt(1));
                c.setIdProveedor(lista.getInt(2));
                c.setIdTipComp(lista.getInt(3));
                c.setSerie(lista.getString(4));
                c.setCorrelativo(lista.getString(5));
                c.setFecha(lista.getString(6));
                c.setImpuesto(lista.getDouble(7));
                c.setTotal(lista.getDouble(8));
                c.setIdUsuarioReg(lista.getInt(9));
                c.setIdUsuarioMod(lista.getInt(10));
                c.setFechReg(lista.getString(11));
                c.setFechaMod(lista.getString(12));
                c.setEstado(lista.getInt(13));
                listCabComp.addElement(c);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return listCabComp;
    }

    //insertar y modificar CabCompra
    public int procesaCabCompra(CabCompra c, String proc) {
        int resultado = 0;
        String sql = "";

        if (proc.equals("insertar")) {
            sql = "insert into CabCompra values (" + c.getIdCompra() + ", " + c.getIdProveedor() + ", " + c.getIdTipComp() + ", '" + c.getSerie() + "', '" + c.getCorrelativo() + "', '";
            sql += c.getFecha() + "', " + c.getImpuesto() + ", " + c.getTotal() + ", " + c.getIdUsuarioReg() + ", " + c.getIdUsuarioMod() + ", '";
            sql += c.getFechReg() + "', '" + c.getFechaMod() + "', " + c.getEstado() + ")";
        } else {
            sql = "update CabCompra set idProveedor = " + c.getIdProveedor() + ", IdTipComp = " + c.getIdTipComp() + ", serie= '" + c.getSerie() + "', correlativo = '";
            sql += c.getCorrelativo() + "', fecha = '" + c.getFecha() + "', impuesto= " + c.getImpuesto() + ", total = " + c.getTotal() + ", idUsuarioReg = " + c.getIdUsuarioReg();
            sql += ", idUsuarioMod = " + c.getIdUsuarioMod() + ", fechReg = '" + c.getFechReg() + "', fechaMod= '" + c.getFechaMod() + "', estado = " + c.getEstado();
            sql += " where IdCompra = " + c.getIdCompra();
        }

        try {
            resultado = ejecutaSQL(sql);

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    //eliminar CabCompra
    public boolean eliminaCabCompra(CabCompra c) {
        boolean sw = true;
        String sql;
        //verificar que no existan registros en tablas dependientes
        try {
            sql = "select * from DetCompra where idCompra = " + c.getIdCompra();
            ResultSet result = resultadoSQL(sql);
            if (result.next() == true) {
                sw = false;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        //eliminar CabCompra
        try {
            if (sw = true) {
                sql = "delete from CabCompra where idCompra = " + c.getIdCompra();
                ejecutaSQL(sql);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return sw;
    }
}
