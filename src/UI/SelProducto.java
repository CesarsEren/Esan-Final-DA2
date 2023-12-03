package UI;

import BEAN.Producto;
import DAO.Impl.ProductoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelProducto extends javax.swing.JDialog {

    DefaultTableModel dtm;
    ProductoDAO prodDAO;
    Producto prod;

    public SelProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        prodDAO = new ProductoDAO();
        dtm = (DefaultTableModel) this.tblProducto.getModel();
        this.llenaProducto(false, "");
    }

    @SuppressWarnings("unchecked")

    public Producto devProd() {
        return this.prod;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("SELECCIONE PRODUCTO");

        jLabel2.setText("Busqueda");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Producto", "Descripción", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int fila;
        fila = this.tblProducto.getSelectedRow();
        prod = new Producto();
        prod.setIdProducto(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        prod.setDescr(dtm.getValueAt(fila, 1).toString());
        prod.setIdCategoria(Integer.parseInt(dtm.getValueAt(fila, 2).toString()));
        prod.setPrecVta(Double.parseDouble(dtm.getValueAt(fila, 3).toString()));
        this.dispose();
    }//GEN-LAST:event_tblProductoMouseClicked

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        if (this.txtBusqueda.getText().isEmpty()) {
            this.llenaProducto(false, "");
        } else {
            this.llenaProducto(true, this.txtBusqueda.getText());
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    public void llenaProducto(boolean sw, String cad) {
        if (dtm.getRowCount() > 0) {
            dtm.setRowCount(0);
        }
        Vector<Producto> lista = prodDAO.listaProducto(sw, cad);
        for (int i = 0; i < lista.size(); i++) {
            Vector vProd = new Vector();
            vProd.addElement(lista.get(i).getIdProducto());
            vProd.addElement(lista.get(i).getDescr());
            vProd.addElement(lista.get(i).getIdCategoria());
            vProd.addElement(lista.get(i).getPrecVta());
            dtm.addRow(vProd);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
