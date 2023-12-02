/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import DAO.ClienteDAO;
import DAO.Conexion;

/**
 *
 * @author xhesm
 */
public class ClienteDAOImpl extends Conexion implements ClienteDAO {
    
    @Override
    public Object[][] select(String usuario, String password) {
        return select("Usuario us inner join Rol rl on us.idRol = rl.idRol inner join Trabajador tr on us.idTrabajador = tr.idTrabajador", "idUsuario,usuario,apePat,rol", "usuario=" + comillas(usuario) + " and contrasenia=" + comillas(password));
    }
    
    public String comillas(String str) {
        return "'" + str + "'";
    }
    
}
