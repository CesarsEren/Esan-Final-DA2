package UI.internal;

import BEAN.ComboData;
import BEAN.Proveedor;
import BEAN.Ubigeo;
import DAO.Impl.TrabajadorDAOImpl;
import DAO.Impl.UbigeoUtilDAOImpl;
import DAO.Impl.ProveedorDAO;
import DAO.TrabajadorDAO;
import DAO.UbigeoUtilDAO;
import DAO.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import UTIL.EmailOnlyDocument;
import UTIL.NumberOnlyDocument;
import UTIL.TextOnlyDocument;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class InFrmProveedor extends javax.swing.JInternalFrame {

    ProveedorDAO provDao;
    DefaultTableModel dtm;
    int idProveedor;
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    Object[][] select, selectaux;
    DefaultComboBoxModel<ComboData> boxModel = null;
    DefaultComboBoxModel<String> boxDep, boxProv, boxDisc = null;
    UbigeoUtilDAO ubigeoDAO = new UbigeoUtilDAOImpl();

    public InFrmProveedor() {
        initComponents();
        provDao = new ProveedorDAO();
        default_config();
        dtm = (DefaultTableModel) this.TBLproveedores.getModel();
        llenaTblProveedor(false, "");
        default_validaciones();
        config_ubigeo();
        llenaCmbEstado();
    }

    public void default_config() {
        this.setTitle("Proveedor");
        this.setClosable(true);
        this.setResizable(true);
    }

    public void config_ubigeo() {
        boxDep = ubigeoDAO.llenarcomboDep();
        CmbDepartamento.setModel(boxDep);
        CmbDepartamento.setSelectedIndex(2);
        TXTubigeo1.setText(ubigeoDAO.getUbigeoByDeptProvDist(CmbDepartamento.getSelectedItem().toString(), CmbProvincia.getSelectedItem().toString(), CmbDistrito.getSelectedItem().toString()));
    }

    private boolean validar() {
        boolean sw = false;
        String sql = "";

        if (this.TXTnif.getText().isEmpty()) {
            sql += "Debe registrar el NIF ";
        }
        if (this.TXTnombre.getText().isEmpty()) {
            sql += "\nDebe registrar el Nombre del proveedor ";
        }
        if (this.TXTcorreo.getText().isEmpty()) {
            sql += "\nDebe registrar el correo ";
        }
        if (this.TXTcelular.getText().isEmpty()) {
            sql += "\nDebe registrar el Celular ";
        }
        if (this.TXTtelefono.getText().isEmpty()) {
            sql += "\nDebe registrar el Telefono ";
        }
        if (this.TXTdireccion.getText().isEmpty()) {
            sql += "\nDebe registrar la direccion ";
        }
        if (this.CMBestado.getSelectedItem().toString().isEmpty()) {
            sql += "\nDebe seleccionar el estado ";
        }
        if (sql.isEmpty()) {
            sw = true;
        } else {
            JOptionPane.showMessageDialog(this, sql);
        }
        return sw;
    }

    public void default_validaciones() {
        TXTnif.setDocument(new NumberOnlyDocument(11));
        TXTcelular.setDocument(new NumberOnlyDocument(9));
        TXTtelefono.setDocument(new NumberOnlyDocument(9));
        TXTcorreo.setDocument(new EmailOnlyDocument(60));
    }

    private void limpia() {
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

    private void llenaCmbEstado() {
        this.CMBestado.addItem("");
        this.CMBestado.addItem("Activo");
        this.CMBestado.addItem(("No Activo"));
    }

    private static int findIndex(DefaultComboBoxModel<ComboData> model, ComboData value) {
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).getId() == (value.getId())) {
                return i;
            }
        }
        return -1;
    }

    private void llenaTblProveedor(boolean sw, String str) {
        Vector<Proveedor> listaProv;
        listaProv = provDao.listarProveedor(sw, str);
        dtm.setRowCount(0);
        for (int i = 0; i < listaProv.size(); i++) {
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
        BtnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTcorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnGrabar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CmbDistrito = new javax.swing.JComboBox<>();
        CmbProvincia = new javax.swing.JComboBox<>();
        CmbDepartamento = new javax.swing.JComboBox<>();
        BtnEliminar1 = new javax.swing.JButton();
        TXTbuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        TBLproveedores.setGridColor(new java.awt.Color(102, 204, 0));
        TBLproveedores.setSelectionBackground(new java.awt.Color(102, 204, 0));
        TBLproveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLproveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLproveedores);

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

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

        TXTubigeo1.setEnabled(false);
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

        CMBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBestadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        jLabel3.setText("NIF");

        TXTcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTcorreoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        jLabel5.setText("Distrito");

        jLabel6.setText("Direccion");

        jLabel7.setText("Celular");

        BtnGrabar.setText("Grabar");
        BtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGrabarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Nuevo");
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

        jLabel12.setText("ID Ubigeo");

        jLabel13.setText("Provincia");

        jLabel14.setText("Departamento");

        CmbDistrito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbDistritoItemStateChanged(evt);
            }
        });
        CmbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbDistritoActionPerformed(evt);
            }
        });

        CmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbProvinciaItemStateChanged(evt);
            }
        });
        CmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProvinciaActionPerformed(evt);
            }
        });

        CmbDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbDepartamentoItemStateChanged(evt);
            }
        });

        BtnEliminar1.setText("Ver Reporte");
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnGrabar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(TXTnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(TXTnif)
                            .addComponent(jLabel2)
                            .addComponent(TXTid)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(TXTtelefono)
                            .addComponent(TXTcelular)
                            .addComponent(jLabel10)
                            .addComponent(TXTcorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TXTdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CMBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(TXTubigeo1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(CmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(CmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(CmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(90, 90, 90))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTnif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTubigeo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMBestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGrabar)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnLimpiar)
                    .addComponent(BtnEliminar1))
                .addContainerGap())
        );

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

        jLabel11.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(44, 44, 44)
                                    .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(99, 99, 99)))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(BtnSalir)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtnSalir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGrabarActionPerformed
        if (this.validar() == true) {
            Proveedor prov = new Proveedor();
            Util u = new Util();
            prov.setNombre(this.TXTnombre.getText());
            prov.setCorreo(this.TXTcorreo.getText());
            prov.setIdUbigeo(this.TXTubigeo1.getText());
            prov.setDireccion(this.TXTdireccion.getText());
            prov.setNif(this.TXTnif.getText());
            prov.setTelefono(this.TXTtelefono.getText());
            prov.setCelular(this.TXTcelular.getText());
            if (this.CMBestado.getSelectedItem().toString().equals("Activo")) {
                prov.setEstado(1);
            } else {
                prov.setEstado(0);
            }

            if (this.BtnGrabar.getText().equals("Grabar")) {
                this.idProveedor = u.idNext("Proveedor", "IdProveedor");
                prov.setIdProveedor(idProveedor);
                provDao.insertaProveedor(prov);
            } else {
                prov.setIdProveedor(idProveedor);
                provDao.actualizaProveedor(prov);
            }
            this.llenaTblProveedor(false, "");
            limpia();
            JOptionPane.showMessageDialog(this, "Registro procesado correctamente");

        }
    }//GEN-LAST:event_BtnGrabarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void TXTbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTbuscarActionPerformed

    private void TXTbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTbuscarKeyReleased
        if (this.TXTbuscar.getText().isEmpty()) {
            this.llenaTblProveedor(false, "");
        } else {
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
        this.TXTcorreo.setText(dtm.getValueAt(idx, 7).toString());
        this.TXTtelefono.setText(dtm.getValueAt(idx, 6).toString());
        this.TXTnif.setText(dtm.getValueAt(idx, 1).toString());
        this.TXTnombre.setText(dtm.getValueAt(idx, 2).toString());
        this.TXTdireccion.setText(dtm.getValueAt(idx, 4).toString());
        this.TXTubigeo1.setText(dtm.getValueAt(idx, 3).toString());

        Object[][] ubigeos = ubigeoDAO.getRowByIdUbigeo(this.TXTubigeo1.getText().trim());
        CmbDepartamento.setSelectedItem(ubigeos[0][1].toString());
        CmbProvincia.setSelectedItem(ubigeos[0][2].toString());
        CmbDistrito.setSelectedItem(ubigeos[0][3].toString());

        if (dtm.getValueAt(idx, 8).toString().equals("1")) {
            this.CMBestado.setSelectedItem("Activo");
        } else {
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
        if (sw = true) {
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            this.limpia();
            this.llenaTblProveedor(false, "");
        } else {
            JOptionPane.showMessageDialog(this, "Registro no eliminado por tener dependencias");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TXTcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTcorreoActionPerformed

    private void TXTcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTcelularActionPerformed

    private void TXTtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTtelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTtelefonoActionPerformed

    private void TXTubigeo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTubigeo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTubigeo1ActionPerformed

    private void TXTdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTdireccionActionPerformed

    private void TXTnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTnombreActionPerformed

    private void TXTnifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTnifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTnifActionPerformed

    private void TXTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTidActionPerformed

    private void CmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbProvinciaActionPerformed

    private void CmbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbDistritoActionPerformed

    private void CMBestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMBestadoActionPerformed

    private void CmbDistritoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbDistritoItemStateChanged
        TXTubigeo1.setText(ubigeoDAO.getUbigeoByDeptProvDist(CmbDepartamento.getSelectedItem().toString(), CmbProvincia.getSelectedItem().toString(), CmbDistrito.getSelectedItem().toString()));
    }//GEN-LAST:event_CmbDistritoItemStateChanged

    private void CmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbProvinciaItemStateChanged
        boxDisc = ubigeoDAO.llenarcomboDist(((String) boxProv.getSelectedItem()));
        CmbDistrito.setModel(boxDisc);
        TXTubigeo1.setText(ubigeoDAO.getUbigeoByDeptProvDist(CmbDepartamento.getSelectedItem().toString(), CmbProvincia.getSelectedItem().toString(), CmbDistrito.getSelectedItem().toString()));
    }//GEN-LAST:event_CmbProvinciaItemStateChanged

    private void CmbDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbDepartamentoItemStateChanged
        boxProv = ubigeoDAO.llenarcomboProv((String) boxDep.getSelectedItem());
        CmbProvincia.setModel(boxProv);
        boxDisc = ubigeoDAO.llenarcomboDist((String) boxProv.getSelectedItem());
        CmbDistrito.setModel(boxDisc);
        TXTubigeo1.setText(ubigeoDAO.getUbigeoByDeptProvDist(CmbDepartamento.getSelectedItem().toString(), CmbProvincia.getSelectedItem().toString(), CmbDistrito.getSelectedItem().toString()));
    }//GEN-LAST:event_CmbDepartamentoItemStateChanged

    private void BtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1ActionPerformed
        // TODO add your handling code here:
        provDao.ImprimirReporte();
    }//GEN-LAST:event_BtnEliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JButton BtnGrabar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JComboBox<String> CMBestado;
    private javax.swing.JComboBox<String> CmbDepartamento;
    private javax.swing.JComboBox<String> CmbDistrito;
    private javax.swing.JComboBox<String> CmbProvincia;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
