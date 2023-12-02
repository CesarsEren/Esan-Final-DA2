package UI;

import BEAN.CabVenta;
import BEAN.Categoria;
import BEAN.Cliente;
import BEAN.DetVenta;
import BEAN.NumComprob;
import BEAN.Producto;
import BEAN.TipoComprobante;
import BEAN.Trabajador;
import DAO.CabVentaDAO;
import DAO.CategoriaDAO;
import DAO.DetVentaDAO;
import DAO.NumComprobDAO;
import DAO.TipoComprobanteDAO;
import DAO.TrabajadorDAO;
import UTIL.Util;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Vector;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;



public class FrmVenta extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm1;
    DefaultTableModel dtm2;
    CabVentaDAO cabDAO;
    DetVentaDAO detDAO;
    Util u;
    TipoComprobanteDAO tipCompDAO;
    CategoriaDAO catDAO;
    NumComprobDAO numCompDAO;
    TrabajadorDAO trabDAO;
    
    int idVenta;
    int idSerie;
    int idCorrelativo;
    DecimalFormat formatDec;
    
    public FrmVenta() {
        initComponents();

        u=new Util();
        dtm1 = (DefaultTableModel)this.tblDetVenta.getModel();
        
        cabDAO = new CabVentaDAO();
        detDAO = new DetVentaDAO();
        
        catDAO = new CategoriaDAO();
        tipCompDAO = new TipoComprobanteDAO();
        numCompDAO = new NumComprobDAO(); 
        formatDec = new DecimalFormat("#.00");
        trabDAO = new TrabajadorDAO();
        obtenerVendedor();
        this.llenaCmbTipoComprobante(false, "");
    }
    
    private void obtenerVendedor(){
        int idTrab=101;
        String nomb="";
        mdiPrincipal principal = new mdiPrincipal();

       //idTrab = principal.devIdTrab();
        
        Vector<Trabajador> listaTrab;
        
        listaTrab =  trabDAO.listarTrabajador(true, String.valueOf(idTrab));
        for(int i=0;i<listaTrab.size(); i++){
             nomb = listaTrab.get(i).getApePat()+" "+listaTrab.get(i).getApeMat()+", "+listaTrab.get(i).getNombre();
        }
        
        this.txtVendedor.setText(nomb);
    }
    
    private void verCorrelDocum(){
        
        int tipComp = codigoTipoComprobante(true, this.cmbTipoComp.getSelectedItem().toString());
        if ( this.cmbTipoComp.getSelectedItem().toString().isEmpty()){
        } else {
            idSerie = u.idNext2("NumComprob", "serie", "idTienda", 102, "idTipComp", tipComp)-1;
            idCorrelativo = u.idNext2("NumComprob", "numero", "idTienda", 102, "idTipComp",tipComp)-1;
            this.txtSerie.setText(formato(3, idSerie ));
            this.txtCorrelativo.setText(formato(7, idCorrelativo )); 
        }


    }
    
    private void actCorrelDocum(){
        
        int xSerie, xCorrel;
        
        xSerie=Integer.parseInt(this.txtSerie.getText());
        xCorrel=Integer.parseInt(this.txtCorrelativo.getText());
        
        NumComprob nc = new NumComprob();
        nc.setIdTienda(102);
        nc.setIdTipComp(codigoTipoComprobante(true, this.cmbTipoComp.getSelectedItem().toString()));
        nc.setSerie(xSerie);
        nc.setNumero(xCorrel+1);
        this.numCompDAO.procesaNumComprob(nc, "actualizar");
    }

    private String llenaCmbTipoComprobante(boolean sw, String cad){
        String t = "";
        Vector<TipoComprobante> listaTipoComp ;
        listaTipoComp =  tipCompDAO.listaTipoComprobante(sw, cad)    ;
        this.cmbTipoComp.addItem("");
        for(int i=0;i<listaTipoComp.size(); i++){
            this.cmbTipoComp.addItem(listaTipoComp.get(i).getDescr());
            if (sw==true){
                t = listaTipoComp.get(i).getDescr();
            }
        }
        
        return t;
        
    }
    
    private String formato(int longMax, int x){
        String aux="";
        String format="";
        for (int i=0; i< longMax-String.valueOf(x).length(); i++)
        {
            aux= aux + "0";
        }

        format = aux + String.valueOf(x);
        return format;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtImpuesto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        calFecha = new com.toedter.calendar.JDateChooser();
        txtSerie = new javax.swing.JTextField();
        txtCorrelativo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTipoComp = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        btnBusqProd = new javax.swing.JButton();
        txtIdProduc = new javax.swing.JTextField();
        txtNomProducto = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        btnAgregarProd = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnTotaliza = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtNIFCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        btnBusqCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetVenta = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE VENTA");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1028, 396));

        txtImpuesto.setEditable(false);
        txtImpuesto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txtImpuesto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        calFecha.setDateFormatString("yyyy-MM-dd");

        txtSerie.setEditable(false);

        txtCorrelativo.setEditable(false);

        jLabel7.setText("Nro Documento");
        jLabel7.setToolTipText("");

        txtVendedor.setEditable(false);
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });

        jLabel8.setText("Vendedor");

        jLabel9.setText("Fecha");
        jLabel9.setToolTipText("");

        jLabel10.setText("IMPUESTO");
        jLabel10.setToolTipText("");

        jLabel11.setText("TOTAL A PAGAR");
        jLabel11.setToolTipText("");

        jLabel6.setText("Tipo Comprobante");

        cmbTipoComp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoCompItemStateChanged(evt);
            }
        });
        cmbTipoComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCompActionPerformed(evt);
            }
        });

        jLabel12.setText("SUB TOTAL");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoComp, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorrelativo, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtVendedor)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(txtImpuesto)
                    .addComponent(txtSubTotal))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbTipoComp, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrelativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel4.setText("ID Producto");
        jLabel4.setToolTipText("");

        jLabel13.setText("Categoria");

        jLabel14.setText("Precio");
        jLabel14.setToolTipText("");

        jLabel15.setText("Cantidad");
        jLabel15.setToolTipText("");

        jLabel16.setText("Importe");
        jLabel16.setToolTipText("");

        txtPrecio.setEditable(false);
        txtPrecio.setAutoscrolls(false);

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtImporte.setEditable(false);
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnBusqProd.setText("Buscar");
        btnBusqProd.setToolTipText("");
        btnBusqProd.setPreferredSize(new java.awt.Dimension(74, 23));
        btnBusqProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqProdActionPerformed(evt);
            }
        });

        txtIdProduc.setEditable(false);

        txtNomProducto.setEditable(false);
        txtNomProducto.setAutoscrolls(false);

        txtCategoria.setEditable(false);

        btnAgregarProd.setText("Agregar");
        btnAgregarProd.setToolTipText("");
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });

        jLabel17.setText("Descuento");
        jLabel17.setToolTipText("");

        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("%");
        jLabel3.setToolTipText("");

        btnTotaliza.setText("...");
        btnTotaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalizaActionPerformed(evt);
            }
        });

        jLabel18.setText("Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdProduc)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNomProducto)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTotaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCantidad)
                                .addGap(94, 94, 94)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBusqProd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBusqProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdProduc))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTotaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setToolTipText("");

        jLabel2.setText("ID Cliente");
        jLabel2.setToolTipText("");

        txtCliente.setEditable(false);
        txtCliente.setToolTipText("");
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtNIFCliente.setEditable(false);

        txtIdCliente.setEditable(false);

        btnBusqCliente.setText("Buscar");
        btnBusqCliente.setToolTipText("");
        btnBusqCliente.setPreferredSize(new java.awt.Dimension(74, 23));
        btnBusqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(btnBusqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNIFCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBusqCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdCliente)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblDetVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Descripción", "Precio", "Cantidad", "Descuento [%]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetVenta);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Datos del Cliente");

        jTabbedPane1.addTab("Ventas", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCompActionPerformed
  
    }//GEN-LAST:event_cmbTipoCompActionPerformed

    private void btnBusqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqClienteActionPerformed
        Cliente c;
        SelCliente dialog = new SelCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        c = dialog.devClie();
        
        this.txtIdCliente.setText(String.valueOf(c.getIdCliente()));
        this.txtNIFCliente.setText(c.getNif());
        this.txtCliente.setText(c.getNombre());
    }//GEN-LAST:event_btnBusqClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBusqProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqProdActionPerformed
        Producto p;
        String categ;
        
        SelProducto dialog = new SelProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        p = dialog.devProd();
        
        this.txtIdProduc.setText(String.valueOf(p.getIdProducto()));
        this.txtNomProducto.setText(p.getDescr());
        this.txtPrecio.setText(String.valueOf(p.getPrecVta()));
        
        categ = this.llenaTxtCategoria(true, String.valueOf(p.getIdCategoria()));
        this.txtCategoria.setText(llenaTxtCategoria(true, String.valueOf(categ)));
        this.txtDescuento.setText("0");
    }//GEN-LAST:event_btnBusqProdActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed
        if(this.txtIdProduc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
        }else if(this.txtCantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad");
        }else{
            boolean validPorc, validCant;
            validPorc = validaImportes("porc", Double.parseDouble(this.txtDescuento.getText()));
            validCant = validaImportes("cant", Double.parseDouble(this.txtCantidad.getText()));
            if ( validPorc == false){
                JOptionPane.showMessageDialog(this, "Descuento inválido,máximo a aplicar: 20%");
            } if(validCant == false){
                JOptionPane.showMessageDialog(this, "Cantidad inválida");
            }else{
                Vector vec = new Vector();
                vec.addElement(this.txtIdProduc.getText());
                vec.addElement(this.txtNomProducto.getText());
                vec.addElement(this.txtPrecio.getText());
                vec.addElement(this.txtCantidad.getText());
                vec.addElement(this.txtDescuento.getText());
                this.dtm1.addRow(vec);
                limpiaProducto();
                
                this.TotalVenta();
            }
            
        }
    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void btnTotalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalizaActionPerformed
        if (this.txtIdProduc.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Seleccione producto");
        }else{
            boolean validPorc, validCant;
            double precio, cantidad, descuento; 
            String total;

            validPorc = validaImportes("porc", Double.parseDouble(this.txtDescuento.getText()));
            validCant = validaImportes("cant", Double.parseDouble(this.txtCantidad.getText()));
            if ( validPorc == false){
                JOptionPane.showMessageDialog(this, "Descuento inválido,máximo a aplicar: 20%");
            } if(validCant == false){
                JOptionPane.showMessageDialog(this, "Cantidad inválida");
            }else{
                precio = Double.parseDouble(this.txtPrecio.getText());
                cantidad = Double.parseDouble(this.txtCantidad.getText());
                
                if (this.txtDescuento.getText().equals("0")){
                    descuento=0.0;
                }else {
                    descuento = Double.parseDouble(this.txtDescuento.getText()); 
                }
                
                total = formatDec.format(precio*cantidad*(100-descuento)/100);
                this.txtImporte.setText(total);
            }
        }
    }//GEN-LAST:event_btnTotalizaActionPerformed

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(this.validaDatos()==true){
            u = new Util();
            //Grabar Cabecera de Venta
            CabVenta cv = new CabVenta();
            String fechaEmision;
            SimpleDateFormat formatoFechaE;
            idVenta = u.idNext("CabVenta", "idVenta");
            cv.setIdVenta(idVenta);
            cv.setIdCliente(Integer.parseInt(this.txtIdCliente.getText()));
            cv.setIdTipComp(codigoTipoComprobante(true, this.cmbTipoComp.getSelectedItem().toString()));
            cv.setSerie(this.txtSerie.getText());
            cv.setCorrelativo(this.txtCorrelativo.getText());
            
            formatoFechaE = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            fechaEmision=formatoFechaE.format(this.calFecha.getCalendar().getTime());
            cv.setFecha(u.obtenerFecha());
            
            //JOptionPane.showMessageDialog(this, String.valueOf(fechaEmision));
            cv.setImpuesto(Double.parseDouble(this.txtImpuesto.getText()));
            cv.setTotal(Double.parseDouble(this.txtTotal.getText()));
            cv.setIdUsuarioReg(101);//por revisar
            cv.setIdUsuarioMod(101);//por revisar
            cv.setFechReg(u.obtenerFecha());
            cv.setFechaMod(u.obtenerFecha());
            cv.setEstado(1);
       
            this.cabDAO.procesaCabVenta(cv, "insertar");
            
            //Grabando en det_venta
            int linea =1;
            for(int i=0;i<dtm1.getRowCount();i++){
                DetVenta dv = new DetVenta();
                dv.setIdVenta(idVenta);
                dv.setIdDetVenta(linea);
                dv.setIdProducto(Integer.parseInt(dtm1.getValueAt(i, 0).toString()));
                dv.setCantidad(Double.parseDouble(dtm1.getValueAt(i, 3).toString()));
                dv.setImporte(Double.parseDouble(dtm1.getValueAt(i, 2).toString()));
                dv.setDescuento(Double.parseDouble(dtm1.getValueAt(i, 4).toString()));
                this.detDAO.procesaDetVenta(dv, "insertar");
                linea += 1;
            }    
            JOptionPane.showMessageDialog(this, "Venta Realizada con éxito");
   
            this.actCorrelDocum();
            this.limpiaVenta();
            this.limpiaProducto();
            dtm1.setRowCount(0);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void cmbTipoCompItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoCompItemStateChanged
        this.verCorrelDocum();
    }//GEN-LAST:event_cmbTipoCompItemStateChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
            this.limpiaVenta();
            this.limpiaProducto();
            dtm1.setRowCount(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private int codigoTipoComprobante(boolean sw, String cad){
        int codigo=1001;
        Vector<TipoComprobante> listaTipComp ;
        listaTipComp =  tipCompDAO.listaTipoComprobante(sw, cad)    ;
        for(int i=0;i<listaTipComp.size(); i++){
            codigo = listaTipComp.get(i).getIdTipComp();
        }
        return codigo;
    }
    
    private boolean validaImportes(String dato, Double val){
        boolean aux = true;
        
        if(dato == "porc"){
            if(val<0 || val>20){
                aux=false;
            }
        }  
        if(dato == "cant"){
            if(val<0){
                aux=false;
            }
        } 
       return aux ;
    }
    
    private boolean validaDatos(){
        boolean aux = false;
        String cad="";
        if(this.calFecha.getDate()==null){
            cad = "\nSeleccione la fecha de venta";
        }
        if(this.cmbTipoComp.getSelectedItem().toString().equals("")){
            cad += "\nSeleccione el tipo de documento";
        }
        if(this.txtIdCliente.getText().equals("")){
            cad += "\nSeleccione el cliente";
        }
        if(dtm1.getRowCount()==0){
            cad += "\nRegistre el detalle de la venta";
        }
        if(cad != ""){
            JOptionPane.showMessageDialog(this, cad);
        }
        return aux = true;
    }
    
    private void TotalVenta(){
        double precio, cantidad, descuento, subtotal=0, total, impuesto;
        
        for(int i=0;i<dtm1.getRowCount();i++){
            
            precio = Double.parseDouble(dtm1.getValueAt(i, 2).toString());
            cantidad = Double.parseDouble(dtm1.getValueAt(i, 3).toString());
            
            if (dtm1.getValueAt(i, 4).toString().isEmpty()){
                    descuento = 0.0;
                }else {
                    descuento = Double.parseDouble(dtm1.getValueAt(i, 4).toString()); 
                }
 
            subtotal = subtotal + precio*cantidad*(100-descuento)/100;
        }  
        impuesto = subtotal*0.18;
        total = subtotal+impuesto;
        
        this.txtSubTotal.setText(formatDec.format(subtotal));
        this.txtTotal.setText(formatDec.format(total));
        this.txtImpuesto.setText(formatDec.format(impuesto));
    }
    
    private void limpiaProducto(){
        this.txtIdProduc.setText("");
        this.txtNomProducto.setText("");
        this.txtPrecio.setText("");
        this.txtCantidad.setText("");
        this.txtDescuento.setText("");
        this.txtCategoria.setText("");
        this.txtImporte.setText(""); 
    }
    
    private void limpiaVenta(){
        this.calFecha.setDate(null);
        this.cmbTipoComp.setSelectedItem("");
        this.txtSerie.setText("");
        this.txtCorrelativo.setText("");
        this.txtSubTotal.setText("");
        this.txtImpuesto.setText("");
        this.txtTotal.setText("");
        this.txtIdCliente.setText("");
        this.txtNIFCliente.setText("");
        this.txtCliente.setText("");
    }
    
    
    
    private String llenaTxtCategoria(boolean sw, String cad){
        String c="";
        Vector<Categoria> listaCate ;
        listaCate =  catDAO.listaCategoria(sw, cad);
        for(int i=0;i<listaCate.size(); i++){
            
            if (sw==true){
                c = listaCate.get(i).getDescr();
            }
        }
        return c;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProd;
    private javax.swing.JButton btnBusqCliente;
    private javax.swing.JButton btnBusqProd;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTotaliza;
    private com.toedter.calendar.JDateChooser calFecha;
    private javax.swing.JComboBox<String> cmbTipoComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDetVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProduc;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtNIFCliente;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
