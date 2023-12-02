/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.Cliente;
import BEAN.Trabajador;
import DAO.ClienteDAO;
import DAO.Conexion;
import java.util.HashMap;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xhesm
 */
public class ClienteDAOImpl extends Conexion implements ClienteDAO {

    public String comillas(String str) {
        return "'" + str + "'";
    }

    @Override
    public boolean save(Cliente t) {
        StringJoiner registros = new StringJoiner(",");
        if (t.getIdCliente() == 0) {
            int lastID = selectSQLMaxId("Cliente", "idCliente", null);
            registros.add((++lastID) + "");
        }
        registros
                .add(comillas(t.getNif()))
                .add(comillas(t.getNombre()))
                .add(comillas(t.getIdUbigeo()))
                .add(comillas(t.getDireccion()))
                .add(comillas(t.getCelular()))
                .add(comillas(t.getTelefono()))
                .add(comillas(t.getCorreo()))
                .add(t.getEstado() + "");

        if (t.getIdCliente() == 0) {
            String campos = "idCliente,nif,nombre,idUbigeo,direccion,celular,telefono,correo,estado";

            return insert("Cliente", campos, registros.toString());
        } else {
            String campos = "nif,nombre,idUbigeo,direccion,celular,telefono,correo,estado";

            return actualizar("Cliente", campos, registros.toString(), "idCliente=" + t.getIdCliente());
        }
    }

    @Override
    public Object[][] select() {
        return select("Cliente", "idCliente,nif,nombre,idUbigeo,direccion,celular,telefono,correo,case when estado=1 then 'Activo' else 'Inactivo' end as estado ", null);
    }

    @Override
    public DefaultTableModel llenartabla() {
        Object[][] select = select("Cliente", "idCliente,nif,nombre,idUbigeo,direccion,celular,telefono,correo,case when estado=1 then 'Activo' else 'Inactivo' end as estado ", null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"idCliente", "Dni", "Nombre", "Ubigeo", "Direccion", "Celular", "Telefono", "Correo", "Estado"});
        return dtm;
    }

    @Override
    public DefaultTableModel buscarEnTabla(String colm, String data) {
        Object[][] select = select("Cliente", "idCliente,nif,nombre,idUbigeo,direccion,celular,telefono,correo,case when estado=1 then 'Activo' else 'Inactivo' end as estado ", colm + " like '%" + data + "%'");
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(select, new Object[]{"idCliente", "Dni", "Nombre", "Ubigeo", "Direccion", "Celular", "Telefono", "Correo", "Estado"});
        return dtm;
    }

    @Override
    public void ImprimirReporte() {

        try {
            Map<String, Object> map = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport("config/reports/CLIENTE_report.jrxml");
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
    public boolean eliminar(int id_cliente) {
        boolean rs = false;
        Object[][] slc = select("CabVenta", "count(idVenta) as cantidad", "idCliente=" + id_cliente);
        rs = Integer.parseInt(slc[0][0] + "") > 0;

        if (!rs) {
            rs = delete("Cliente", "idCliente" + id_cliente);
        }
        return rs;
    }

}
