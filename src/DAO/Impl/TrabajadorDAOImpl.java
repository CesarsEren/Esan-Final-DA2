/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.Trabajador;
import DAO.Conexion;
import DAO.TrabajadorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author xhesm
 */
public class TrabajadorDAOImpl extends Conexion implements TrabajadorDAO {

    @Override
    public DefaultTableModel llenartabla() {
        /*  Object[][] select2 = select("Area","idArea,descr",null);
        DefaultTableModel defaultTableModel = new DefaultTableModel(); 
        defaultTableModel.setDataVector(select2, new Object[]{"ID","DESCRIPCIÓN"});*/

        Object[][] select = select("Trabajador tr inner join Puesto p on tr.idPuesto = p.idPuesto", "idTrabajador,CAST(p.idPuesto AS VARCHAR(10))+'|'+Puesto as Puesto ,docIdent,nombre,apePat,apeMat,ubigeo,direccion, CASE WHEN genero=1 THEN 'Masculino' ELSE 'Femenino' END as genero ,fecha_nacimiento,celular,telefono,correo, CASE WHEN estado=1 THEN 'Activo' ELSE 'Inactivo' END as estado ", null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"idTrabajador", "Puesto", "Nro Documento", "Nombre", "Apellido Paterno", "Apellido Materno", "Ubigeo", "Direccion", "Genero", "Fecha Nacimiento", "Celular", "Telefono", "Correo", "Estado"});

        return dtm;
    }

    @Override
    public DefaultComboBoxModel llenarcombo() {
        return llenarcombo("Puesto", "idPuesto,Puesto", null);
    }

    @Override
    public Object[][] select() {
        return select("Trabajador tr inner join Puesto p on tr.idPuesto = p.idPuesto", "idTrabajador,p.idPuesto as idPuesto,Puesto,docIdent,nombre,apePat,apeMat,ubigeo,direccion, CASE WHEN genero=1 THEN 'Masculino' ELSE 'Femenino' END as genero ,fecha_nacimiento,celular,telefono,correo, CASE WHEN estado=1 THEN 'Activo' ELSE 'Inactivo' END as estado ", null);
    }

    @Override
    public DefaultTableModel buscarEnTabla(String colm, String data) {
        Object[][] select = select("Trabajador tr inner join Puesto p on tr.idPuesto = p.idPuesto", "idTrabajador,Puesto,docIdent,nombre,apePat,apeMat,ubigeo,direccion, CASE WHEN genero=1 THEN 'Masculino' ELSE 'Femenino' END as genero ,fecha_nacimiento,celular,telefono,correo, CASE WHEN estado=1 THEN 'Activo' ELSE 'Inactivo' END as estado ", colm + " like '%" + data + "%'");
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"idTrabajador", "Puesto", "Nro Documento", "Nombre", "Apellido Paterno", "Apellido Materno", "Ubigeo", "Direccion", "Genero", "Fecha Nacimiento", "Celular", "Telefono", "Correo", "Estado"});

        return dtm;
    }

    @Override
    public boolean save(Trabajador t) {
        StringJoiner registros = new StringJoiner(",");
        if (t.getIdTrabajador() == 0) {
            int lastID = selectSQLMaxId("Trabajador", "idTrabajador", null);
            registros.add((++lastID) + "");
        }
        registros
                .add(t.getIdPuesto() + "")
                .add(comillas(t.getDocIdent()))
                .add(comillas(t.getNombre()))
                .add(comillas(t.getApePat()))
                .add(comillas(t.getApeMat()))
                .add(comillas(t.getUbigeo()))
                .add(comillas(t.getDireccion()))
                .add(t.getGenero() + "")
                .add(comillas(t.getFecha_nacimiento().toString()))
                .add(comillas(t.getCelular()))
                .add(comillas(t.getTelefono()))
                .add(comillas(t.getCorreo()))
                .add(t.getEstado() + "");

        if (t.getIdTrabajador() == 0) {
            String campos = "idTrabajador,idPuesto,docIdent,nombre,apePat,apeMat,ubigeo,direccion,genero,fecha_nacimiento,celular,telefono,correo,estado";

            return insert("Trabajador", campos, registros.toString());
        } else {
            String campos = "idPuesto,docIdent,nombre,apePat,apeMat,ubigeo,direccion,genero,fecha_nacimiento,celular,telefono,correo,estado";

            return actualizar("Trabajador", campos, registros.toString(), "idTrabajador=" + t.getIdTrabajador());
        }

    }

    public String comillas(String str) {
        return "'" + str + "'";
    }

    @Override
    public void ImprimirReporte() {
        try {
            Map<String, Object> map = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/trabajador_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, this.conectardb());
            JasperViewer.viewReport(jasperPrint, false);
            /*
            String pdfFile = "config/temporal-reports/informe.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);*/
        } catch (JRException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean eliminar(int id_trabajador) {
        boolean res = false;
        try {
            ResultSet rs = EjecutarSQL("select count(idUsuario) as cantidad from Usuario where idTrabajador = " + id_trabajador);
            int size = 0;
            if (rs.next()) {
                size = rs.getInt(1);
            }
            // rs = Integer.parseInt(slc[0][0] + "") > 0;
            if (size == 0) {
                res = delete("Trabajador", "idTrabajador=" + id_trabajador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Object[][] findTrabajadorByDNI(String dni) {
        return select("Trabajador", "idTrabajador,docIdent,nombre", "docIdent=" + comillas(dni));
    }

}
