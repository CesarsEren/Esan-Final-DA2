/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Impl;

import DAO.Conexion;
import DAO.UsuarioDAO;

/**
 *
 * @author xhesm
 */
public class UsuarioDAOImpl extends Conexion implements UsuarioDAO {

    public String comillas(String str) {
        return "'" + str + "'";
    }

    @Override
    public Object[][] select(String usuario, String password) {
        return select("Usuario us inner join Rol rl on us.idRol = rl.idRol inner join Trabajador tr on us.idTrabajador = tr.idTrabajador", "idUsuario,usuario,apePat,rol", "usuario=" + comillas(usuario) + " and contrasenia=" + comillas(password));
    }
}
