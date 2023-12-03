/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public interface UtilComprasDAO {

    public void ImprimirReporte();
    
    public void guardarReporte();
    
    public DefaultTableModel llenartabla();
}
