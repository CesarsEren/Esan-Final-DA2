/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import BEAN.Tienda;
import BEAN.Trabajador;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public interface TiendaDAO {

//    Conexion c = new Conexion("");
    public boolean save(Tienda t);

    public Object[][] select();

    public DefaultTableModel llenartabla();

    public DefaultTableModel buscarEnTabla(String colm, String data);

    public DefaultComboBoxModel llenarcombo();

}
