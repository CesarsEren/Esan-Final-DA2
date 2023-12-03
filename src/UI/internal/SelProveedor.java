package UI.internal;

import BEAN.Proveedor;
import DAO.Impl.ProveedorDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelProveedor extends javax.swing.JDialog {

    DefaultTableModel dtm;
    Proveedor prov;
    ProveedorDAO provDAO;

    public SelProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        provDAO = new ProveedorDAO();
        dtm = (DefaultTableModel) this.tblProveedor.getModel();
        this.llenaProveedor(false, "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONE PROVEEDOR");

        jLabel2.setText("Busqueda");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Proveedor", "NIF", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        tblProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProveedorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBusqueda)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Proveedor devProv() {
        return this.prov;
    }

    private void tblProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProveedorKeyReleased

    }//GEN-LAST:event_tblProveedorKeyReleased

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int fila;
        fila = this.tblProveedor.getSelectedRow();
        prov = new Proveedor();
        prov.setIdProveedor(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        prov.setNif(dtm.getValueAt(fila, 1).toString());
        prov.setNombre(dtm.getValueAt(fila, 2).toString());
        this.dispose();
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        if (this.txtBusqueda.getText().isEmpty()) {
            this.llenaProveedor(false, "");
        } else {
            this.llenaProveedor(true, this.txtBusqueda.getText());
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    public void llenaProveedor(boolean sw, String cad) {
        if (dtm.getRowCount() > 0) {
            dtm.setRowCount(0);
        }
        Vector<Proveedor> lista = provDAO.listarProveedor(sw, cad);
        for (int i = 0; i < lista.size(); i++) {
            Vector vProv = new Vector();
            vProv.addElement(lista.get(i).getIdProveedor());
            vProv.addElement(lista.get(i).getNif());
            vProv.addElement(lista.get(i).getNombre());
            dtm.addRow(vProv);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
