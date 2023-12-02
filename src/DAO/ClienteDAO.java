/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import BEAN.Cliente;
import BEAN.Trabajador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public interface ClienteDAO {

    public boolean save(Cliente t);

    public Object[][] select();

    public DefaultTableModel llenartabla();

    public DefaultTableModel buscarEnTabla(String colm, String data);

    public void ImprimirReporte();

    public boolean eliminar(int id_cliente);

}
