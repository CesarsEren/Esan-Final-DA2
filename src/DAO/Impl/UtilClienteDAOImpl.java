/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import DAO.Conexion;
import DAO.UtilClienteDAO;

/**
 *
 * @author xhesm
 */
public class UtilClienteDAOImpl extends Conexion implements UtilClienteDAO {

    @Override
    public Object[][] buscarClienteByNdif(String ndif) {
        return select("Cliente", "idCliente,nif,nombre", "nif=" + comillas(ndif));
    }

    public String comillas(String str) {
        return "'" + str + "'";
    }

}
