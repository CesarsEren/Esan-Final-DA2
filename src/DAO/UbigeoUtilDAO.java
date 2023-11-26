/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author xhesm
 */
public interface UbigeoUtilDAO {

    public DefaultComboBoxModel llenarcomboDep();

    public DefaultComboBoxModel llenarcomboProv(String dep);

    public DefaultComboBoxModel llenarcomboDist(String prov);
}
