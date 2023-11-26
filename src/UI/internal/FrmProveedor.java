package UI.internal;

import BEAN.Proveedor;
import BEAN.Ubigeo;
import DAO.ProveedorDAO;
import UI.JDUbigeo;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmProveedor extends javax.swing.JFrame {
    ProveedorDAO provDao;
    DefaultTableModel dtm;
    int idProveedor;
    public FrmProveedor() {
        provDao = new ProveedorDAO();
        initComponents();
        dtm = (DefaultTableModel)this.TBLproveedores.getModel();
        llenaTblProveedor(false, "");
        llenaCmbEstado();
    }
    
    private boolean validar(){
        boolean sw = false;
        String sql = "";
        
       if(this.TXTnif.getText().isEmpty()){
           sql += "Debe registrar el NIF ";
       }
       if(this.TXTnombre.getText().isEmpty()){
           sql += "\nDebe registrar el Nombre del proveedor ";
       }
       if(this.TXTcorreo.getText().isEmpty()){
           sql += "\nDebe registrar el correo ";
       }
       if(this.TXTcelular.getText().isEmpty()){
           sql += "\nDebe registrar el Celular ";
       }
       if(this.TXTtelefono.getText().isEmpty()){
           sql += "\nDebe registrar el Telefono ";
       }
       if(this.TXTdireccion.getText().isEmpty()){
           sql += "\nDebe registrar la direccion ";
       }
       if(this.CMBestado.getSelectedItem().toString().isEmpty()){
           sql += "\nDebe seleccionar el estado ";
       }
       if(sql.isEmpty()){
           sw = true;
       }else{
           JOptionPane.showMessageDialog(this, sql);
       }
       return sw;
    }
    
    private void limpia(){
        this.TXTid.setText("");
        this.TXTnif.setText("");
        this.TXTnombre.setText("");
        this.TXTcorreo.setText("");
        this.TXTtelefono.setText("");
        this.TXTcelular.setText("");
        this.TXTdireccion.setText("");
        this.CMBestado.setSelectedItem("");
        this.TXTubigeo1.setText("");
        this.TXTbuscar.setText("");
        
        
        this.BtnGrabar.setText("Grabar");
    }
    private void llenaCmbEstado(){
        this.CMBestado.addItem("");
        this.CMBestado.addItem("Activo");
        this.CMBestado.addItem(("No Activo"));
    }
    
     private void llenaTblProveedor(boolean sw, String str){
        Vector<Proveedor> listaProv;
        listaProv = provDao.listarProveedor(sw, str);
        dtm.setRowCount(0);     
        for(int i=0;i<listaProv.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaProv.get(i).getIdProveedor());
            vec.addElement(listaProv.get(i).getNif());
            vec.addElement(listaProv.get(i).getNombre());
            vec.addElement(listaProv.get(i).getIdUbigeo());
            vec.addElement(listaProv.get(i).getDireccion());
            vec.addElement(listaProv.get(i).getCelular());
            vec.addElement(listaProv.get(i).getTelefono());
            vec.addElement(listaProv.get(i).getCorreo());
            vec.addElement(listaProv.get(i).getEstado());
            dtm.addRow(vec);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBLproveedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXTid = new javax.swing.JTextField();
        TXTnif = new javax.swing.JTextField();
        TXTnombre = new javax.swing.JTextField();
        TXTdireccion = new javax.swing.JTextField();
        TXTubigeo1 = new javax.swing.JTextField();
        TXTtelefono = new javax.swing.JTextField();
        TXTcelular = new javax.swing.JTextField();
        CMBestado = new javax.swing.JComboBox<>();
        BtnEliminar = new javax.swing.JButton();
        BtnGrabar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TXTbuscar = new javax.swing.JTextField();
        TXTcorreo = new javax.swing.JTextField();
        BtnUbigeo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TBLproveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIF", "Nombre", "ID ubigeo", "Direccion", "Celular", "Telefono", "Correo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLproveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLproveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLproveedores);

        jLabel1.setText("Proveedor");

        jLabel2.setText("Id");

        jLabel3.setText("NIF");

        jLabel4.setText("Nombre");

        jLabel5.setText("ID Ubigeo");

        jLabel6.setText("Direccion");

        jLabel7.setText("Celular");

        jLabel8.setText("Telefono");

        jLabel9.setText("Estado");

        jLabel10.setText("Correo");

        TXTid.setEnabled(false);
        TXTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTidActionPerformed(evt);
            }
        });

        TXTnif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTnifActionPerformed(evt);
            }
        });

        TXTnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTnombreActionPerformed(evt);
            }
        });

        TXTdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTdireccionActionPerformed(evt);
            }
        });

        TXTubigeo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTubigeo1ActionPerformed(evt);
            }
        });

        TXTtelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTtelefonoActionPerformed(evt);
            }
        });

        TXTcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTcelularActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnGrabar.setText("Grabar");
        BtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGrabarActionPerformed(evt);
            }
        });

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLimpiarMouseClicked(evt);
            }
        });
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar");

        TXTbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTbuscarActionPerformed(evt);
            }
        });
        TXTbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTbuscarKeyReleased(evt);
            }
        });

        BtnUbigeo.setText("jButton1");
        BtnUbigeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbigeoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)))
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTubigeo1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTnif, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel8))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXTcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CMBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel11)
                        .addGap(37, 37, 37)
                        .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(BtnGrabar)
                .addGap(86, 86, 86)
                .addComponent(BtnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnLimpiar)
                .addGap(60, 60, 60)
                .addComponent(BtnSalir)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(TXTcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTnif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(TXTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TXTcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TXTubigeo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CMBestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TXTdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnUbigeo)
                        .addGap(97, 97, 97)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGrabar)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnSalir)
                    .addComponent(BtnLimpiar))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTidActionPerformed

    private void TXTnifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTnifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTnifActionPerformed

    private void TXTnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTnombreActionPerformed

    private void TXTdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTdireccionActionPerformed

    private void TXTubigeo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTubigeo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTubigeo1ActionPerformed

    private void TXTtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTtelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTtelefonoActionPerformed

    private void TXTcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTcelularActionPerformed

    private void BtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGrabarActionPerformed
        if(this.validar() == true){
            Proveedor prov = new Proveedor();
            Util u = new Util();
            
            prov.setNombre(this.TXTnombre.getText());
            prov.setCorreo(this.TXTcorreo.getText());
            prov.setIdUbigeo(this.TXTubigeo1.getText());
            prov.setDireccion(this.TXTdireccion.getText());
            prov.setNif(this.TXTnif.getText());
            prov.setTelefono(this.TXTtelefono.getText());
            prov.setCelular(this.TXTcelular.getText());
            if(this.CMBestado.getSelectedItem().toString().equals("Activo")){
                prov.setEstado(1);
            }else{
                prov.setEstado(0);
            }
            
            if(this.BtnGrabar.getText().equals("Grabar")){
                this.idProveedor = u.idNext("Proveedor", "IdProveedor");
                prov.setIdProveedor(idProveedor);
                provDao.insertaProveedor(prov);
            }else{
                prov.setIdProveedor(idProveedor);
                provDao.actualizaProveedor(prov);
            }
            this.llenaTblProveedor(false, "");
            limpia();
            JOptionPane.showMessageDialog(this,"Registro procesado correctamente");
            
        }
    }//GEN-LAST:event_BtnGrabarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
     limpia();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void TXTbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTbuscarActionPerformed

    private void TXTbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTbuscarKeyReleased
    if(this.TXTbuscar.getText().isEmpty()){
            this.llenaTblProveedor(false, "");
        }else{
            this.llenaTblProveedor(true, this.TXTbuscar.getText());
        }
    }//GEN-LAST:event_TXTbuscarKeyReleased

    private void BtnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLimpiarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLimpiarMouseClicked

    private void TBLproveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLproveedoresMouseClicked
    int idx;
   
   idx = this.TBLproveedores.getSelectedRow();
   
   this.idProveedor = Integer.parseInt(dtm.getValueAt(idx, 0).toString());
   this.TXTid.setText(dtm.getValueAt(idx, 0).toString());
   this.TXTcelular.setText(dtm.getValueAt(idx, 5).toString());
   this.TXTcorreo.setText(dtm.getValueAt(idx,7).toString());
   this.TXTtelefono.setText(dtm.getValueAt(idx, 6).toString());
   this.TXTnif.setText(dtm.getValueAt(idx, 1).toString());
   this.TXTnombre.setText(dtm.getValueAt(idx, 2).toString());
   this.TXTdireccion.setText(dtm.getValueAt(idx, 4).toString());
   this.TXTubigeo1.setText(dtm.getValueAt(idx, 3).toString());
   if(dtm.getValueAt(idx, 8).toString().equals("1")){
       this.CMBestado.setSelectedItem("Activo");
   }else{
       this.CMBestado.setSelectedItem("No Activo");
   }
   this.BtnGrabar.setText("Actualizar");
    }//GEN-LAST:event_TBLproveedoresMouseClicked

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
     Proveedor t = new Proveedor();
        boolean sw;
        t.setIdProveedor(Integer.parseInt(this.TXTid.getText().toString()));
        sw = provDao.eliminaProveedor(t);
        if(sw=true){
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            this.limpia();
            this.llenaTblProveedor(false, "");
        }else{
            JOptionPane.showMessageDialog(this, "Registro no eliminado por tener dependencias");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnUbigeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbigeoActionPerformed
    Ubigeo U;
     JDUbigeo dialog = new JDUbigeo(new javax.swing.JFrame(), true);
     dialog.setVisible(true);
     U = dialog.devUbigeo();
     
        this.TXTubigeo1.setText(String.valueOf(U.getIdUbigeo()));
    }//GEN-LAST:event_BtnUbigeoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGrabar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnUbigeo;
    private javax.swing.JComboBox<String> CMBestado;
    private javax.swing.JTable TBLproveedores;
    private javax.swing.JTextField TXTbuscar;
    private javax.swing.JTextField TXTcelular;
    private javax.swing.JTextField TXTcorreo;
    private javax.swing.JTextField TXTdireccion;
    private javax.swing.JTextField TXTid;
    private javax.swing.JTextField TXTnif;
    private javax.swing.JTextField TXTnombre;
    private javax.swing.JTextField TXTtelefono;
    private javax.swing.JTextField TXTubigeo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}