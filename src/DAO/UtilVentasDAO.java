/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BEAN.CabVenta;
import BEAN.DetVenta;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public interface UtilVentasDAO {

    public void ImprimirReporte();

    public void guardarReporte();

    public void mostrarCpe(Map<String, Object> map);

    public DefaultTableModel llenartabla();

    public boolean guardarVenta(CabVenta cabVenta, List<DetVenta> lsDetVenta);

    public Object[][] buscarSerieAndNumeroReply(String serie, String correlativo);
}
