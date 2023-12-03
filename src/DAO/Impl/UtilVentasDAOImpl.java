/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.CabVenta;
import BEAN.DetVenta;
import DAO.Conexion;
import DAO.UtilVentasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
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
public class UtilVentasDAOImpl extends Conexion implements UtilVentasDAO {

    @Override
    public void ImprimirReporte(int id_trabajador) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("id_trabajador", id_trabajador);
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/VentasXTrabajador.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel llenartabla() {
        Object[][] select = select("CabVenta as cc inner join Proveedor pr on cc.idProveedor = pr.idProveedor", "pr.nif,pr.nombre,serie+'-'+correlativo as doc,fechReg,total", null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"Nro doc", "Documento", "Fecha Registro", "Total"});
        return dtm;
    }

    @Override
    public void guardarReporte() {
        try {
            Map<String, Object> map = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/VentasXTrabajador.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            //JasperViewer.viewReport(jasperPrint, false);
            String pdfFile = "config/temporal-reports/VentasXTrabajador.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean guardarVenta(CabVenta cabVenta, List<DetVenta> lsDetVenta) {

        int last_id_venta = selectSQLMaxId("CabVenta", "idVenta", null);
        cabVenta.setIdVenta(++last_id_venta);
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(cabVenta.getIdVenta() + "")
                .add(cabVenta.getIdCliente() + "")
                .add(cabVenta.getIdTipComp() + "")
                .add(comillas(cabVenta.getSerie()))
                .add(comillas(cabVenta.getCorrelativo()))
                .add("GETDATE()")
                .add(cabVenta.getImpuesto() + "")
                .add(cabVenta.getTotal() + "")
                .add(cabVenta.getIdUsuarioReg() + "")
                .add("GETDATE()")
                .add("1");

        boolean insert_int = insert("CabVenta", "idVenta,idCliente,idTipComp,serie,correlativo,fecha,impuesto,total,idUsuarioReg,fechReg,estado", joiner.toString());
        if (insert_int) {
            int idnext = selectSQLMaxId("DetVenta", "idDetVenta", null);

            for (DetVenta detVenta : lsDetVenta) {
                StringJoiner detV = new StringJoiner(",");
                //int detVentaId = Integer.parseInt("" + idnext);
                detVenta.setIdDetVenta(idnext++);
                detVenta.setIdVenta(last_id_venta);
                detV.add(detVenta.getIdVenta() + "")
                        .add(detVenta.getIdDetVenta() + "")
                        .add(detVenta.getIdProducto() + "")
                        .add(detVenta.getCantidad() + "")
                        .add(detVenta.getImporte() + "")
                        .add(detVenta.getDescuento() + "");
                insert("DetVenta", "idVenta,idDetVenta,idProducto,cantidad,importe,descuento", detV.toString());
            }
        }

        return insert_int;
    }

    public String comillas(String str) {
        return "'" + str + "'";
    }

    @Override
    public void mostrarCpe(Map<String, Object> map) {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/cpe.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean buscarSerieAndNumeroReply(String serie, String correlativo) {

        ResultSet resultSet = EjecutarSQL("select count(idVenta) as idVenta from CabVenta where serie=" + comillas(serie) + " and correlativo=" + comillas(correlativo));
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilVentasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count > 0;
    }

    @Override
    public DefaultTableModel llenartablaBy(int idTrabajador) {

        Object[][] select = null;
        if (idTrabajador == 0) {
            select = select("CabVenta cv inner join Usuario us on cv.idUsuarioReg = us.idUsuario inner join Trabajador tr on us.idTrabajador = tr.idTrabajador", "tr.nombre+' '+tr.apePat+' '+tr.apeMat as vendedor,fechReg,serie+'-'+correlativo as Doc,impuesto,total", null);
        } else {
            select = select("CabVenta cv inner join Usuario us on cv.idUsuarioReg = us.idUsuario inner join Trabajador tr on us.idTrabajador = tr.idTrabajador", "tr.nombre+' '+tr.apePat+' '+tr.apeMat as vendedor,fechReg,serie+'-'+correlativo as Doc,impuesto,total", "tr.idTrabajador = " + idTrabajador);
        }
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"Vendedor", "Fecha Registro", "Documento", "Impuesto", "Total"});
        return dtm;
    }

}
