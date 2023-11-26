/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import BEAN.ComboData;
import DAO.Conexion;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import DAO.UbigeoUtilDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhesm
 */
public class UbigeoUtilDAOImpl extends Conexion implements UbigeoUtilDAO {

    @Override
    public DefaultComboBoxModel llenarcomboDep() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            ResultSet resultSet = EjecutarSQL("Select distinct(dept) as dept from Ubigeo");
            Object[][] ob = new Object[resultSet.getRow()][resultSet.getMetaData().getColumnCount()];
            int i = 0;
            int j = 0;
            while (resultSet.next()) {
                ComboData cd = new ComboData(0, resultSet.getString(1));
                modelo.addElement(cd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UbigeoUtilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    @Override
    public DefaultComboBoxModel llenarcomboProv(String dep) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            ResultSet resultSet = EjecutarSQL("Select distinct(prov) as dept from Ubigeo where dept = '" + dep + "'");
            Object[][] ob = new Object[resultSet.getRow()][resultSet.getMetaData().getColumnCount()];
            int i = 0;
            int j = 0;
            while (resultSet.next()) {
                ComboData cd = new ComboData(0, resultSet.getString(1));
                modelo.addElement(cd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UbigeoUtilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    @Override
    public DefaultComboBoxModel llenarcomboDist(String prov) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            ResultSet resultSet = EjecutarSQL("Select distinct(dist) as dept from Ubigeo where prov = '" + prov + "'");
            Object[][] ob = new Object[resultSet.getRow()][resultSet.getMetaData().getColumnCount()];
            int i = 0;
            int j = 0;
            while (resultSet.next()) {
                ComboData cd = new ComboData(0, resultSet.getString(1));
                modelo.addElement(cd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UbigeoUtilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

}
