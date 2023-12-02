/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import DAO.Conexion;
import DAO.UtilComprasDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xhesm
 */
public class UtilComprasDAOImpl extends Conexion implements UtilComprasDAO {

    @Override
    public void ImprimirReporte() {
        try {
            Map<String, Object> map = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/ReporteCompras.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public DefaultTableModel llenartabla() {
        Object[][] select = select("CabCompra as cc inner join Proveedor pr on cc.idProveedor = pr.idProveedor", "pr.nif,pr.nombre,serie+'-'+correlativo as doc,fechReg,total", null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"Nro doc", "Documento", "Fecha Registro", "Total"});
        return dtm;
    }

    @Override
    public void guardarReporte() {
        try {
            Map<String, Object> map = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/ReporteCompras.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            JasperViewer.viewReport(jasperPrint, false); 
            String pdfFile = "config/temporal-reports/ReporteCompras.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
