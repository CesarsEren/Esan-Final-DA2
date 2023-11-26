/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.Trabajador;
import DAO.Conexion;
import DAO.TrabajadorDAO;
import java.sql.Connection;
import java.util.StringJoiner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhesm
 */
public class TrabajadorDAOImpl extends Conexion implements TrabajadorDAO {

    public TrabajadorDAOImpl() {
    }

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
            Object[][] objs = select("Trabajador", "max(idTrabajador) as idTrabajador", null);
            int lastID = Integer.parseInt(objs[0][0] + "");
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

}
