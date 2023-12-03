package DAO.Impl;

import BEAN.DetCompra;
import DAO.Conexion;
import java.sql.ResultSet;
import java.util.Vector;

public class DetCompraDAO extends Conexion {

    public Vector<DetCompra> listaDetCompra(boolean sw, String cad) {
        Vector<DetCompra> listDetComp = new Vector<DetCompra>();
        String sql = "";
        sql = "select * from DetCompra ";
        if (sw == true) {
            sql += "where idCompra like '%" + cad + "%'";
        }
        try {
            ResultSet lista = resultadoSQL(sql);
            while (lista.next()) {
                DetCompra d = new DetCompra();
                d.setIdCompra(lista.getInt(1));
                d.setIdDetCompra(lista.getInt(2));
                d.setIdProducto(lista.getInt(3));
                d.setCantidad(lista.getDouble(4));
                d.setImporte(lista.getDouble(5));
                d.setDescuento(lista.getDouble(6));
                listDetComp.addElement(d);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return listDetComp;
    }

    //insertar y modificar DetCompra
    public int procesaDetCompra(DetCompra d, String proc) {
        int resultado = 0;
        String sql = "";
        if (proc.equals("insertar")) {
            sql = "insert into DetCompra values (" + d.getIdCompra() + ", " + d.getIdDetCompra() + ", " + d.getIdProducto() + ", " + d.getCantidad() + ", ";
            sql += d.getImporte() + ", " + d.getDescuento() + ")";
        } else {
            sql = "update DetCompra set idProducto = " + d.getIdProducto() + ", cantidad = " + d.getCantidad() + ", importe= " + d.getImporte() + ", descuento = ";
            sql += d.getDescuento() + " where idCompra = " + d.getIdCompra() + " and idDetCompra = " + d.getIdDetCompra();
        }
        try {
            resultado = ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    //eliminar DetCompra
    public void eliminaDetVenta(DetCompra d) {
        String sql;
        //eliminar DetCompra
        try {
            sql = "delete from DetCompra where idDetCompra = " + d.getIdDetCompra() + " and idCompra = " + d.getIdCompra();
            ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }
}
