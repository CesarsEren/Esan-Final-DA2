package UI;

import BEAN.Ubigeo;
import DAO.UbigeoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class JDUbigeo extends javax.swing.JDialog {

        UbigeoDAO ubiDao;
        DefaultTableModel dtm;
        Ubigeo ubi;

    public JDUbigeo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ubi = new Ubigeo();
        ubiDao = new UbigeoDAO();
        initComponents();
        dtm = (DefaultTableModel)this.TblUbigeo.getModel();
        llenaTblUbigeo(false,"");
    }
    private void llenaTblUbigeo(boolean sw, String cad){
        Vector<Ubigeo> listaUbigeo;
        listaUbigeo = this.ubiDao.listarUbigeo(sw, cad);
        
        dtm.setRowCount(0);
        
        for(int i=0;i<listaUbigeo.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaUbigeo.get(i).getIdUbigeo());
            vec.addElement(listaUbigeo.get(i).getDept());
            vec.addElement(listaUbigeo.get(i).getProv());
            vec.addElement(listaUbigeo.get(i).getDist());
            
            dtm.addRow(vec);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblUbigeo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TXTBusquedaUbigeo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("UBIGEO");

        TblUbigeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdUbigeo", "Departamento", "Provincia", "Distrito"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblUbigeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblUbigeoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblUbigeo);

        jLabel2.setText("Busqueda");

        TXTBusquedaUbigeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTBusquedaUbigeoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(TXTBusquedaUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTBusquedaUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TblUbigeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblUbigeoMouseClicked
      int idx;
        idx = this.TblUbigeo.getSelectedRow();
        
        this.ubi.setIdUbigeo(dtm.getValueAt(idx, 0).toString());
        this.ubi.setDept(dtm.getValueAt(idx, 1).toString());
        this.ubi.setProv(dtm.getValueAt(idx, 2).toString());
        this.ubi.setDist(dtm.getValueAt(idx, 3).toString());
        
        devUbigeo();
        this.dispose();
    }//GEN-LAST:event_TblUbigeoMouseClicked

    private void TXTBusquedaUbigeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTBusquedaUbigeoKeyReleased
    if(this.TXTBusquedaUbigeo.getText().isEmpty()){
            this.llenaTblUbigeo(false, "");
        }else{
            this.llenaTblUbigeo(true, this.TXTBusquedaUbigeo.getText());
        }
    }//GEN-LAST:event_TXTBusquedaUbigeoKeyReleased

    public Ubigeo devUbigeo() {
        return this.ubi;
    }

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
            java.util.logging.Logger.getLogger(JDUbigeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDUbigeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDUbigeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDUbigeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDUbigeo dialog = new JDUbigeo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTBusquedaUbigeo;
    private javax.swing.JTable TblUbigeo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
