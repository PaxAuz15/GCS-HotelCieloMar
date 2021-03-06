/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Datos.vhabitacion;
import Datos.vpago;
import Datos.vreserva;
import Logica.conexion;
import Logica.fconsumo;
import Logica.fhabitacion;
import Logica.fpago;
import Logica.fproducto;
import Logica.freserva;
import static Presentacion.frmreserva.txtnhabitacion;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CARLOS
 */
public class frmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public frmPago() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
       
        txtidreserva.setText(idreserva);
        txtcliente.setText(cliente);
        txthabitacion.setText(habitacion);
        txtidhabitacion.setText(idhabitacion);
        txttotalreserva.setText(Double.toString(totalreserva));
        
        fconsumo func = new fconsumo();
        func.mostrar(idreserva);
        
        txttotal_pago.setText(Double.toString(totalreserva + func.totalconsumo));
        
        
    }
    
    
    private String accion = "guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;
    

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_columnasconsumo() {
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    
    
    void inhabilitar() {
        txtidpago.setVisible(false);
        
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        txtnum_comprobante.setEnabled(false);
        cbotipo_comprobante.setEnabled(false);
        txtIva.setEnabled(false);
        txttotal_pago.setEnabled(false);
        txttotalreserva.setEnabled(false);
        dcfecha_emision.setEnabled(false);
        dcfecha_pago.setEnabled(false);
        
        txtidhabitacion.setVisible(false);
        txthabitacion.setEnabled(false);
        txtSubtotal.setEnabled(false);
        txtdescuento.setEnabled(false);
         
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtIva.setText("");
        txttotal_pago.setText("");

    }

    void habilitar() {
        txtidpago.setVisible(false);
        
        txtidreserva.setVisible(true);
        txtcliente.setEnabled(true);
        txtnum_comprobante.setEnabled(true);
        cbotipo_comprobante.setEnabled(true);
        txtIva.setEnabled(true);
        txttotal_pago.setEnabled(true);
        txttotalreserva.setEnabled(true);
        dcfecha_emision.setEnabled(true);
        dcfecha_pago.setEnabled(true);
        
        txtidhabitacion.setVisible(true);
        txthabitacion.setEnabled(true);
        txtSubtotal.setEnabled(true);
        txtdescuento.setEnabled(true);
        
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtIva.setText("");
        //txttotal_pago.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fpago func = new fpago();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));
            
            //Mostrar los datos de los consumos
            fconsumo func2 = new fconsumo();
            modelo= func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();
            
            double totalconsumo = func2.totalconsumo;
            String numCadenaConsumo= String.valueOf(totalconsumo); 
            lbltotalregistrosconsumo.setText("Total Consumos " + func2.totalregistros);
            lbltotalconsumo.setText(numCadenaConsumo);
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        txttotal_reserva = new javax.swing.JPanel();
        txtidpago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnum_comprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbotipo_comprobante = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotalreserva = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txthabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttotal_pago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dcfecha_emision = new com.toedter.calendar.JDateChooser();
        dcfecha_pago = new com.toedter.calendar.JDateChooser();
        txtSubtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnImprimirComprobante = new javax.swing.JButton();
        btnImprimirComprobanteConsumo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        txttotal_reserva.setBackground(new java.awt.Color(255, 204, 102));
        txttotal_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagos"));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Reserva:");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Habitación:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Num Comprobante:");

        txtnum_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_comprobanteActionPerformed(evt);
            }
        });
        txtnum_comprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_comprobanteKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Tipo Comprobante:");

        cbotipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleta", "Factura", "Ticket", "Otro" }));
        cbotipo_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_comprobanteActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnnuevo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.GIF"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(51, 51, 51));
        btncancelar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtcliente.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Total Reserva:");

        txttotalreserva.setEditable(false);

        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        txthabitacion.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Iva");

        txtIva.setEditable(false);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Total Pago:");

        txttotal_pago.setEditable(false);
        txttotal_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotal_pagoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Fecha Emisión:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Fecha Pago:");

        txtSubtotal.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Subtotal");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Descuento");

        txtdescuento.setEditable(false);
        txtdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescuentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txttotal_reservaLayout = new javax.swing.GroupLayout(txttotal_reserva);
        txttotal_reserva.setLayout(txttotal_reservaLayout);
        txttotal_reservaLayout.setHorizontalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txttotal_reservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(btnnuevo)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnguardar)
                                        .addGap(58, 58, 58)
                                        .addComponent(btncancelar))
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbotipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dcfecha_emision, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addComponent(dcfecha_pago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(99, 99, 99)))
                            .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtnum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIva, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(txttotal_pago, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdescuento))))))
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        txttotal_reservaLayout.setVerticalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbotipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addComponent(dcfecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(dcfecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnnuevo)
                                    .addComponent(btnguardar)
                                    .addComponent(btncancelar)))
                            .addComponent(jLabel11)))
                    .addComponent(jLabel5))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("PAGOS");

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pagos"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(51, 51, 51));
        btnsalir.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        btnImprimirComprobante.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirComprobante.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnImprimirComprobante.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirComprobante.setText("Imprimir");
        btnImprimirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprobanteActionPerformed(evt);
            }
        });

        btnImprimirComprobanteConsumo.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirComprobanteConsumo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnImprimirComprobanteConsumo.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirComprobanteConsumo.setText("Imprimir Consumos");
        btnImprimirComprobanteConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprobanteConsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnImprimirComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImprimirComprobanteConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir)
                    .addComponent(btnImprimirComprobante)
                    .addComponent(btnImprimirComprobanteConsumo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbltotalregistros))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));

        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistadoconsumo);

        lbltotalregistrosconsumo.setText("Registros");

        lbltotalconsumo.setText("jLabel12");

        jLabel13.setText("Total consumo $");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalconsumo)
                        .addGap(48, 48, 48)
                        .addComponent(lbltotalregistrosconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumo)
                    .addComponent(lbltotalconsumo)
                    .addComponent(jLabel13)))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Incono.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(454, 454, 454))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
        txtidreserva.transferFocus();
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txtnum_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_comprobanteActionPerformed
        // TODO add your handling code here:
        txtnum_comprobante.transferFocus();
    }//GEN-LAST:event_txtnum_comprobanteActionPerformed

    private void cbotipo_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_comprobanteActionPerformed
        // TODO add your handling code here:
        cbotipo_comprobante.transferFocus();
    }//GEN-LAST:event_cbotipo_comprobanteActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        
        PreparedStatement ps;
        ResultSet rs;
            try{
                //coneccion con la base de datos
                ps = cn.prepareStatement("Select tipo_documento from persona INNER JOIN reserva on idpersona = idcliente WHERE idreserva = ?");
                ps.setString(1,txtidreserva.getText() );
                rs = ps.executeQuery(); 
                if(rs.next()){
                    String tipo_documento= rs.getString("tipo_documento");
                    String texto = "PREMIUN";
                    
                    char c1=tipo_documento.charAt(0);
                    char c2=texto.charAt(0);
                    
                    if(c1==c2){
                        String valorReserva = txttotalreserva.getText();
                        double Iva = 0.12;
                        double valorReservaEntero = Double.parseDouble(valorReserva);
                        double PrecioIva = valorReservaEntero * Iva;
                        String PreIva= String.valueOf(PrecioIva);
                        txtIva.setText(PreIva);

                        String valorReserva1 = txttotalreserva.getText();
                        double Descuento = 0.10;
                        double valorReservaEntero1 = Double.parseDouble(valorReserva1);
                        double PrecioDescuento = valorReservaEntero1 * Descuento;
                        String PreDesc= String.valueOf(PrecioDescuento);
                        txtdescuento.setText(PreDesc);

                        String valor3 = txttotal_pago.getText();
                        double otroValor3 = Double.parseDouble(valor3);
                        double PrecioToal = PrecioIva + otroValor3 - PrecioDescuento;
                        String numCadena2= String.valueOf(PrecioToal);
                        txttotal_pago.setText(numCadena2);

                        String valor4 = lbltotalconsumo.getText();
                        double otroValor4 = Double.parseDouble(valor4);
                        double subTotal = otroValor4+valorReservaEntero;
                        String numCadena3=String.valueOf(subTotal);
                        txtSubtotal.setText(numCadena3);
                     }else{
                        String valorReserva = txttotalreserva.getText();
                        double Iva = 0.12;
                        double valorReservaEntero = Double.parseDouble(valorReserva);
                        double PrecioIva = valorReservaEntero * Iva;
                        String PreIva= String.valueOf(PrecioIva);
                        txtIva.setText(PreIva);

                        txtdescuento.setText("0");

                        String valor3 = txttotal_pago.getText();
                        double otroValor3 = Double.parseDouble(valor3);
                        double PrecioToal = PrecioIva + otroValor3;
                        String numCadena2= String.valueOf(PrecioToal);
                        txttotal_pago.setText(numCadena2);

                        String valor4 = lbltotalconsumo.getText();
                        double otroValor4 = Double.parseDouble(valor4);
                        double subTotal = otroValor4+valorReservaEntero;
                        String numCadena3=String.valueOf(subTotal);
                        txtSubtotal.setText(numCadena3);
                     } 
                }else{
                    JOptionPane.showMessageDialog(null,"EL CODIGO NO EXISTE");
                }   
            } catch (Exception ex) {
            
            }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtIva.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el igv del Comprobante de pago a generar");
            txtIva.requestFocus();
            return;
        }
        if (txttotal_pago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante");
            txttotal_pago.requestFocus();
            return;
        }

        if (txtnum_comprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Comprobante del Pago");
            txtnum_comprobante.requestFocus();
            return;
        }

        vpago dts = new vpago();
        fpago func = new fpago();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));


        int seleccionado = cbotipo_comprobante.getSelectedIndex();
        dts.setTipo_comprobante((String) cbotipo_comprobante.getItemAt(seleccionado));
        
        dts.setNum_comprobante(txtnum_comprobante.getText());
        dts.setIgv(Double.parseDouble(txtIva.getText()));
        dts.setTotal_pago(Double.parseDouble(txttotal_pago.getText()));
        
        Calendar cal;
        int d,m,a;
        
        cal=dcfecha_pago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_pago( new Date (a,m,d));
        
        
        cal=dcfecha_emision.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_emision(new Date (a,m,d));
        
        
        

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " El pago por $. " + txttotal_pago.getText() + 
                        " del Sr. " + txtcliente.getText() + " Ha sido realizado con Éxito");
                mostrar(idreserva);
                inhabilitar();
                
                //Desocupar la Habitación
                fhabitacion func2 = new fhabitacion();
                vhabitacion dts2 = new vhabitacion();
                
                dts2.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocupar(dts2);
                
                //Cancelar o pagar la reserva
                
                freserva func3 = new freserva();
                vreserva dts3 = new vreserva();
                
                dts3.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
                
            }

        }
        else if (accion.equals("editar")){
            dts.setIdpago(Integer.parseInt(txtidpago.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr. " + 
                        txtcliente.getText() + " Ha sido Modificado Correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpago.setText(tablalistado.getValueAt(fila, 0).toString());
        //txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());
        
        cbotipo_comprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtnum_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtIva.setText(tablalistado.getValueAt(fila, 4).toString());
        txtdescuento.setText(tablalistado.getValueAt(fila, 5).toString());
        txttotal_pago.setText(tablalistado.getValueAt(fila, 6).toString());
        
        dcfecha_emision.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString()));
        dcfecha_pago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 8).toString()));
       

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Pago seleccionado?","Confirmar",2);

            if (confirmacion==0) {
                fpago func = new fpago ();
                vpago dts= new vpago();

                dts.setIdpago(Integer.parseInt(txtidpago.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txttotal_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotal_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotal_pagoActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

    private Connection connection=new conexion().conectar();
    
    
    
    private void btnImprimirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprobanteActionPerformed
        if (!txtidpago.getText().equals("")) {
            Map p = new HashMap();
            p.put("idpago", txtidpago.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprobante.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirComprobanteActionPerformed

    private void btnImprimirComprobanteConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprobanteConsumoActionPerformed
        if (!txtidpago.getText().equals("")) {
            Map p = new HashMap();
            p.put("idpago", txtidpago.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprobanteConsumo.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirComprobanteConsumoActionPerformed

    private void txtdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentoActionPerformed

    private void txtnum_comprobanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_comprobanteKeyTyped
        // TODO add your handling code here:
        int numero_caracteres=6;
        if(txtnum_comprobante.getText().length()>=numero_caracteres){
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Ingrese solo 6 caracteres");
        }
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
        }
    }//GEN-LAST:event_txtnum_comprobanteKeyTyped

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
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimirComprobante;
    private javax.swing.JButton btnImprimirComprobanteConsumo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbotipo_comprobante;
    private com.toedter.calendar.JDateChooser dcfecha_emision;
    private com.toedter.calendar.JDateChooser dcfecha_pago;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txthabitacion;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidpago;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtnum_comprobante;
    private javax.swing.JTextField txttotal_pago;
    private javax.swing.JPanel txttotal_reserva;
    private javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
    conexion db = new conexion();
    Connection cn = db.conectar();
}
