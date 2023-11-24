/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import DAO.Conexion;
import UI.FrmConfig;
import UI.FrmLogin;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xhesm
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Properties properties = new Properties();
                String filePath = "config/app.properties";

                try ( FileInputStream fileInput = new FileInputStream(filePath)) {
                    // Cargar el archivo de propiedades
                    properties.load(fileInput);
                } catch (IOException e) {
                    //  JOptionPane.showConfirmDialog(null, "Falta configurar la base de datos");
                    e.printStackTrace();
                    new FrmConfig().setVisible(true);
                }

                Conexion.url = properties.getProperty("database.url");
                Conexion.user = properties.getProperty("database.username");
                Conexion.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Conexion.password = properties.getProperty("database.password");
                if (Conexion.url == null || Conexion.user == null || Conexion.password == null || Conexion.url.isEmpty() || Conexion.user.isEmpty() || Conexion.password.isEmpty()) {
                    new FrmConfig().setVisible(true);
                } else {
                    Conexion dbCo = new Conexion();
                    try {
                        dbCo.TestearConexion();
                        new FrmLogin().setVisible(true);
                    } catch (ClassNotFoundException | SQLException ex) {
                        new FrmConfig().setVisible(true);
                        Logger.getLogger(ProyectoFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    }

}
