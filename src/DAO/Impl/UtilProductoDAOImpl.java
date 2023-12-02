/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import DAO.Conexion;
import DAO.UtilProductoDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public class UtilProductoDAOImpl extends Conexion implements UtilProductoDAO {

    @Override
    public DefaultTableModel llenartabla() {
        Object[][] select = select("Producto", "idProducto,descr", "estado=1");
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"Id", "Descripcion"});
        return dtm;
    }

    @Override
    public DefaultTableModel buscarEnTabla(String data) {

        String where = "estado=1 " + (data.isEmpty() ? "" : "and descr like '%" + data + "%'");
        Object[][] select = select("Producto", "idProducto,descr", where);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"Id", "Descripcion"});
        return dtm;
    }

    @Override
    public Object[][] buscarProductoById(int id) {
        return select("Producto", "idProducto,descr,precVta", "idProducto=" + id);
    }

}
