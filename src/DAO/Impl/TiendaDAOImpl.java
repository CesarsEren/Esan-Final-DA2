/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.Tienda;
import DAO.Conexion;
import DAO.TiendaDAO;
import java.util.StringJoiner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public class TiendaDAOImpl extends Conexion implements TiendaDAO {

    @Override
    public boolean save(Tienda t) {
        StringJoiner registros = new StringJoiner(",");
        if (t.getIdTienda() == 0) {
            Object[][] objs = select("Tienda", "max(idTienda) as idTienda", null);
            int lastID = Integer.parseInt(objs[0][0] + "");
            registros.add((++lastID) + "");
        }
        registros
                .add(comillas(t.getTienda()))
                .add(comillas(t.getIdUbigeo()))
                .add(comillas(t.getDescr()))
                .add(t.getIdEstado() + "");

        if (t.getIdTienda() == 0) {
            String campos = "idTienda,Tienda,idUbigeo,descr,idEstado";
            return insert("Trabajador", campos, registros.toString());
        } else {
            String campos = "Tienda,idUbigeo,descr,idEstado";
            return actualizar("Tienda", campos, registros.toString(), "idTienda=" + t.getIdTienda());
        }
    }

    @Override
    public Object[][] select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel llenartabla() {
        Object[][] select = select("Tienda", "idTienda,Tienda,idUbigeo,descr,CASE WHEN idEstado=1 THEN 'Activo' ELSE 'Inactivo' END as idEstado", null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"ID", "NOMBRE", "UBIGEO", "DESCRIPCION", "ESTADO"});
        return dtm;
    }

    @Override
    public DefaultTableModel buscarEnTabla(String colm, String data) {
        Object[][] select = select("Tienda", "idTienda,Tienda,idUbigeo,descr,CASE WHEN idEstado=1 THEN 'Activo' ELSE 'Inactivo' END as idEstado", colm + " like '%" + data + "%'");
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"ID", "NOMBRE", "UBIGEO", "DESCRIPCION", "ESTADO"});
        return dtm;
    }

    @Override
    public DefaultComboBoxModel llenarcombo() {
        return llenarcombo("Tienda", "idTienda,Tienda", null);
    }

    public String comillas(String str) {
        return "'" + str + "'";
    }

}
