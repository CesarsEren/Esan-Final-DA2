/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.Conexion;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xhesm
 */
public class FrmConfig extends javax.swing.JFrame {

    Conexion dbCo = new Conexion();

    /**
     * Creates new form FrmConfig
     */
    public FrmConfig() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdbname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtport = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtALog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexión"));

        jLabel1.setText("Ip :");

        jLabel2.setText("Usuario :");

        jLabel3.setText("Contraseña :");

        jLabel4.setText("BD nombre :");

        jButton1.setText("Testear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Base de Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Port:");

        txtALog.setColumns(20);
        txtALog.setRows(5);
        txtALog.setEnabled(false);
        jScrollPane1.setViewportView(txtALog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtip, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpass)
                            .addComponent(txtuser)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdbname)))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdbname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Conexion.url = "jdbc:sqlserver://" + txtip.getText() + ":" + txtport.getText() + ";databaseName=" + txtdbname.getText();
        Conexion.user = txtuser.getText();
        Conexion.password = txtpass.getText();
        try {
            if (dbCo.TestearConexion()) {
                txtALog.setText("Conexión realizada con éxito");
                int opcion = JOptionPane.showConfirmDialog(this, "Conexión Correcta, ¿guardamos la configuración?");
                if (opcion == JOptionPane.YES_OPTION) {
                    // El usuario seleccionó "Sí"
                    Properties properties = new Properties();
                    String filePath = "config/app.properties";

                    properties.setProperty("database.url", Conexion.url);
                    properties.setProperty("database.username", Conexion.user);
                    properties.setProperty("database.password", Conexion.password);

                    try ( FileOutputStream fileOutput = new FileOutputStream(filePath)) {
                        // Guardar los valores en el archivo
                        properties.store(fileOutput, "Comentarios opcionales");
                        System.out.println("Valores guardados exitosamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                    //System.out.println("Usuario seleccionó Sí");
                    // Aquí puedes poner el código que quieres ejecutar cuando el usuario selecciona "Sí"
                } else {
                    // El usuario seleccionó "No" o cerró el cuadro de diálogo
                    System.out.println("Usuario seleccionó No o cerró el cuadro de diálogo");
                    // Aquí puedes poner el código que quieres ejecutar cuando el usuario selecciona "No" o cierra el cuadro de diálogo
                }
            } else {
                txtALog.setText("No se pudo realizar Conexión");
            }
        } catch (ClassNotFoundException ex) {
            txtALog.setText("No se pudo realizar Conexión " + ex);
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            txtALog.setText("No se pudo realizar Conexión " + ex);
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Conexion.url = "jdbc:sqlserver://" + txtip.getText() + ":" + txtport.getText() + ";databaseName=master";
        Statement statement = null;
        txtALog.setText("");
        try {
            statement = dbCo.conectardb().createStatement();
            statement.execute(leerContenidoScript("config/script.txt"));
            txtALog.setText(txtALog.getText() + "\nCREANDO BASE DE DATOS " + txtdbname.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.url = "jdbc:sqlserver://" + txtip.getText() + ":" + txtport.getText() + ";databaseName=" + txtdbname.getText();
        statement = null;
        try {
            statement = dbCo.conectardb().createStatement();
            statement.execute(leerContenidoScript("config/script_1.txt"));
            txtALog.setText(txtALog.getText() + "\nCREANDO TABLAS DE " + txtdbname.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.url = "jdbc:sqlserver://" + txtip.getText() + ":" + txtport.getText() + ";databaseName=" + txtdbname.getText();
        statement = null;
        try {
            statement = dbCo.conectardb().createStatement();
            statement.execute(leerContenidoScript("config/script_2.txt"));
            txtALog.setText(txtALog.getText() + "\nINSERTANDO REGISTROS A LAS TABLAS DE " + txtdbname.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.url = "jdbc:sqlserver://" + txtip.getText() + ":" + txtport.getText() + ";databaseName=" + txtdbname.getText();
        statement = null;
        try {
            statement = dbCo.conectardb().createStatement();
            statement.execute(leerContenidoScript("config/script_3.txt"));
            txtALog.setText(txtALog.getText() + "\nCREANDO LLAVES FORANEAS DE " + txtdbname.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FrmConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private static String leerContenidoScript(String filePath) {
        StringBuilder scriptContent = new StringBuilder();

        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                scriptContent.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        return scriptContent.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtALog;
    private javax.swing.JTextField txtdbname;
    private javax.swing.JTextField txtip;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtport;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}