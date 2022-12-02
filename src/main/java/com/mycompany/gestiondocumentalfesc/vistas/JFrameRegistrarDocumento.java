
package com.mycompany.gestiondocumentalfesc.vistas;

import com.mycompany.gestiondocumentalfesc.conexion.Conexion;
import static com.mycompany.gestiondocumentalfesc.controladores.ControladorDetalles.copyFile;
import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class JFrameRegistrarDocumento extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection connection = conexion.conectar();
    
    public JFrameRegistrarDocumento() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarComboEstudiante(jcbxSeleccionarEstudiante);
        cargarComboEmpresa(jcbxSeleccionarEmpresa);
        cargarComboDestinatario(jcbxSeleccionarDestinatario);
        AutoCompleteDecorator.decorate(jcbxSeleccionarEstudiante);
        AutoCompleteDecorator.decorate(jcbxSeleccionarEmpresa);
        AutoCompleteDecorator.decorate(jcbxSeleccionarDestinatario);
        AutoCompleteDecorator.decorate(jcbxTipoDocumento);
        jcbxSeleccionarEstudiante.addItem("Ninguno");
        jcbxSeleccionarEmpresa.addItem("Ninguno");       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtAsunto = new javax.swing.JTextField();
        txtNumeroRadicado = new javax.swing.JTextField();
        txtNumeroAnexos = new javax.swing.JTextField();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jcbxTipoRadicado = new javax.swing.JComboBox<>();
        jcbxTipoDocumento = new javax.swing.JComboBox<>();
        jcbxSeleccionarEstudiante = new javax.swing.JComboBox<>();
        jcbxSeleccionarEmpresa = new javax.swing.JComboBox<>();
        jcbxSeleccionarDestinatario = new javax.swing.JComboBox<>();
        jBotonSeleccionarArchivo = new javax.swing.JButton();
        txtRutaArchivo = new javax.swing.JTextField();
        jcbRequiereRespuesta = new javax.swing.JCheckBox();
        jBotonAgregarRemitentes = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jBotonSubirDatos = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbVentanaConsultar = new javax.swing.JButton();
        jbCerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtAsunto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAsunto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asunto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txtNumeroRadicado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNumeroRadicado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero Radicado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txtNumeroAnexos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNumeroAnexos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero Anexos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jDateFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jDateFecha.setDateFormatString("yyyy-MM-dd");

        jcbxTipoRadicado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbxTipoRadicado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrega", "Respuesta" }));
        jcbxTipoRadicado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de radicado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jcbxTipoDocumento.setEditable(true);
        jcbxTipoDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Carta", "Acta", "Copia", "Peticion", "Solicitud", "Derecho de peticion", "Citacion", "Memorando", "Caja", "Factura", "Remision", "Paquete", "Otro" }));
        jcbxTipoDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de documento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jcbxTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxTipoDocumentoActionPerformed(evt);
            }
        });

        jcbxSeleccionarEstudiante.setEditable(true);
        jcbxSeleccionarEstudiante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbxSeleccionarEstudiante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estudiante remitente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jcbxSeleccionarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxSeleccionarEstudianteActionPerformed(evt);
            }
        });

        jcbxSeleccionarEmpresa.setEditable(true);
        jcbxSeleccionarEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbxSeleccionarEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empresa remitente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jcbxSeleccionarDestinatario.setEditable(true);
        jcbxSeleccionarDestinatario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbxSeleccionarDestinatario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jBotonSeleccionarArchivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBotonSeleccionarArchivo.setText("Seleccionar archivo");
        jBotonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonSeleccionarArchivoActionPerformed(evt);
            }
        });

        txtRutaArchivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRutaArchivo.setText(".");

        jcbRequiereRespuesta.setBackground(new java.awt.Color(255, 255, 255));
        jcbRequiereRespuesta.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jcbRequiereRespuesta.setText("Requiere Respuesta");

        jBotonAgregarRemitentes.setBackground(new java.awt.Color(255, 0, 0));
        jBotonAgregarRemitentes.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jBotonAgregarRemitentes.setForeground(new java.awt.Color(255, 255, 255));
        jBotonAgregarRemitentes.setText("+Nuevos remitentes y destinatarios");
        jBotonAgregarRemitentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonAgregarRemitentesActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jBotonSubirDatos.setBackground(new java.awt.Color(255, 0, 0));
        jBotonSubirDatos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBotonSubirDatos.setForeground(new java.awt.Color(255, 255, 255));
        jBotonSubirDatos.setText("SUBIR DATOS");
        jBotonSubirDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonSubirDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonSubirDatosActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Archivos adjuntos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nombre del archivo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcbxSeleccionarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbxSeleccionarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jBotonAgregarRemitentes)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcbRequiereRespuesta)
                                .addGap(109, 109, 109))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcbxSeleccionarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtAsunto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumeroRadicado)
                            .addComponent(jcbxTipoRadicado, 0, 240, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jBotonSubirDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jBotonSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroRadicado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbxTipoRadicado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxSeleccionarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxSeleccionarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxSeleccionarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotonAgregarRemitentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbRequiereRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotonSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jBotonSubirDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 760, 500));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 760, -1));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DOCUMENTAL");

        jbVentanaConsultar.setBackground(new java.awt.Color(255, 51, 51));
        jbVentanaConsultar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbVentanaConsultar.setForeground(new java.awt.Color(255, 255, 255));
        jbVentanaConsultar.setText("Consultar");
        jbVentanaConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentanaConsultarActionPerformed(evt);
            }
        });

        jbCerrarSesion.setBackground(new java.awt.Color(255, 51, 51));
        jbCerrarSesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrarSesion.setText("Cerrar sesion");
        jbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(jbVentanaConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCerrarSesion)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVentanaConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 60));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrar datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 760, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonAgregarRemitentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonAgregarRemitentesActionPerformed
        JFrameRegistrarEntidades rgf = new JFrameRegistrarEntidades();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_jBotonAgregarRemitentesActionPerformed

    private void jBotonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonSeleccionarArchivoActionPerformed
        
        JFileChooser escoger = new JFileChooser();

        escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int estado = escoger.showOpenDialog(null);

        if(estado == JFileChooser.APPROVE_OPTION) {
            File archivo = escoger.getSelectedFile();
            if((archivo == null || (archivo.getName().equals("")))) {
                txtRutaArchivo.setText("...");
            }
            else {
                txtRutaArchivo.setText(archivo.getAbsolutePath());
            }
            File directorio = new File("C:\\archivos");
        
        
        if (!directorio.exists()) {
           directorio.mkdir();     
        }
            try {
                File pdfDes = new File(directorio.getAbsolutePath()+ "\\" +archivo.getName());
                copyFile(archivo,pdfDes);
                
            } catch (IOException ex) {
                    System.out.println("Error al subir el archivo");
            }
        } 
    }//GEN-LAST:event_jBotonSeleccionarArchivoActionPerformed

    private void jBotonSubirDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonSubirDatosActionPerformed
            String sql;
            String nombreArchivo = txtNombreArchivo.getText();
            String rutaArchivo = txtRutaArchivo.getText();
            String fecha = ((JTextField)jDateFecha.getDateEditor().getUiComponent()).getText();
            String numRadicado = txtNumeroRadicado.getText();
            String tipoRadicado = getTipoRadicado();
            String tipoDocumento = getTipoDocumento();
            String asunto = txtAsunto.getText();
            String numAnexo = txtNumeroAnexos.getText();
            String reqRespuesta = getJhxReqRespuesta();
            String selecEstudiante = jcbxSeleccionarEstudiante.getSelectedItem().toString();
            String selecEmpresa = jcbxSeleccionarEmpresa.getSelectedItem().toString();
            String selecDestinatario = jcbxSeleccionarDestinatario.getSelectedItem().toString();

            
            sql = "INSERT INTO `documento`(`nombreArchivo`, `asunto`, `numeroRadicado`, `numeroAnexo`, `fecha`, `tipoRadicado`, `tipoDocumento`, "
                    + "`estudianteNombre`, `empresaNombre`, `destinatarioNombre`, `reqRespuesta`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, nombreArchivo);
                ps.setString(2, asunto);
                ps.setString(3, numRadicado);
                ps.setString(4, numAnexo);
                ps.setDate(5, (Date) Date.valueOf(fecha));
                ps.setString(6, tipoRadicado);
                ps.setString(7, tipoDocumento);
                ps.setString(8, selecEstudiante);
                ps.setString(9, selecEmpresa);               
                ps.setString(10, selecDestinatario);
                ps.setString(11, reqRespuesta);
                int consulta4 = ps.executeUpdate();
                
                if(consulta4 > 0) {
                    JOptionPane.showMessageDialog(null, "Datos del documento subidos con exito"); 
                    actualizar();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
                }
                
            } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
    }//GEN-LAST:event_jBotonSubirDatosActionPerformed

    private void jcbxSeleccionarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxSeleccionarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxSeleccionarEstudianteActionPerformed

    private void jcbxTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxTipoDocumentoActionPerformed
        
    }//GEN-LAST:event_jcbxTipoDocumentoActionPerformed

    private void jbVentanaConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentanaConsultarActionPerformed
        JFrameConsultar rgf = new JFrameConsultar();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jbVentanaConsultarActionPerformed

    private void jbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarSesionActionPerformed

        String botones[] = {"Si","No"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar sesion?", "Cerrar sesion", 0, 0, null,
            botones, this);
        
        if(eleccion == JOptionPane.YES_OPTION) {
            JFrameLoginUsuario jflu = new JFrameLoginUsuario();
            jflu.setVisible(true);
            jflu.pack();
            jflu.setLocationRelativeTo(null);
            jflu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(eleccion == JOptionPane.NO_OPTION) {   
        }
    }//GEN-LAST:event_jbCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRegistrarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRegistrarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRegistrarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRegistrarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRegistrarDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBotonAgregarRemitentes;
    public javax.swing.JButton jBotonSeleccionarArchivo;
    public javax.swing.JToggleButton jBotonSubirDatos;
    public com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JButton jbCerrarSesion;
    public javax.swing.JButton jbVentanaConsultar;
    public javax.swing.JCheckBox jcbRequiereRespuesta;
    public javax.swing.JComboBox<String> jcbxSeleccionarDestinatario;
    public javax.swing.JComboBox<String> jcbxSeleccionarEmpresa;
    public javax.swing.JComboBox<String> jcbxSeleccionarEstudiante;
    public javax.swing.JComboBox<String> jcbxTipoDocumento;
    public javax.swing.JComboBox<String> jcbxTipoRadicado;
    public javax.swing.JTextField txtAsunto;
    public javax.swing.JTextField txtNombreArchivo;
    public javax.swing.JTextField txtNumeroAnexos;
    public javax.swing.JTextField txtNumeroRadicado;
    public javax.swing.JTextField txtRutaArchivo;
    // End of variables declaration//GEN-END:variables

    private void cargarComboEstudiante(JComboBox c) {
        
        DefaultComboBoxModel comboEstudiante = new DefaultComboBoxModel();
        c.setModel(comboEstudiante);
        ArrayList<EstudianteRemitente> listadoEstudiantes = new ArrayList<>();
        
        String sql = "SELECT CONCAT(docEstudiante, ' ', apellidosEstudiante) FROM estudiante ORDER BY idEstudiante DESC";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                EstudianteRemitente estudiante = new EstudianteRemitente();
                estudiante.setNombres(rs.getString(1));
                listadoEstudiantes.add(estudiante);
                comboEstudiante.addElement(estudiante.getNombres());
                
                System.out.println("Datos de estudiantes cargados con exito");
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se puede cargar datos" + e.getMessage());
        }
    }

    private void cargarComboEmpresa(JComboBox c) {
        
        DefaultComboBoxModel comboEmpresa = new DefaultComboBoxModel();
        c.setModel(comboEmpresa);
        ArrayList<EmpresaRemitente> listadoEmpresas = new ArrayList<>();
        
        String sql = "SELECT CONCAT(nombreEmpresa, ' - ', docEmpresa) FROM empresa ORDER BY idEmpresa DESC";
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                EmpresaRemitente empresa = new EmpresaRemitente();
                empresa.setNombreEmpresa(rs.getString(1));
                listadoEmpresas.add(empresa);
                comboEmpresa.addElement(empresa.getNombreEmpresa());
                
                System.out.println("Datos de empresas cargados con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se puede cargar datos" + e.getMessage());
        }
    }

    private void cargarComboDestinatario(JComboBox c) {
        
        DefaultComboBoxModel comboDestinatario = new DefaultComboBoxModel();
        c.setModel(comboDestinatario);
        ArrayList<Destinatario> listadoDestinatarios = new ArrayList<>();
        
        String sql = "SELECT CONCAT(docDestinatario, ' - ', nombreDestinatario,' ',apellidoDestinatario) FROM destinatario ORDER BY idDestinatario DESC";
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Destinatario destinatario = new Destinatario();
                destinatario.setNombres(rs.getString(1));
                listadoDestinatarios.add(destinatario);
                comboDestinatario.addElement(destinatario.getNombres());
                
                System.out.println("Datos de destinatarios cargados con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se puede cargar datos" + e.getMessage());
        }
    }

    private String getJhxReqRespuesta() {
        if(jcbRequiereRespuesta.isSelected()) {
            return "1";
        }
        else {
            return "0";
        }
    }

    private void actualizar() {
        JFrameRegistrarDocumento main = new JFrameRegistrarDocumento();
        main.setVisible(true);
        this.dispose(); 
    }

    private String getTipoRadicado() {
        if(jcbxTipoRadicado.getSelectedItem().equals("Entrega")) {
            return "1";
        }
        else if(jcbxTipoRadicado.getSelectedItem().equals("Respuesta")) {
            return "2";
        }
        return null; 
    }

    private String getTipoDocumento() {
        if(jcbxTipoDocumento.getSelectedItem().equals("Carta")) {
            return "1";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Acta")){
            return "2";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Copia")) {
            return "3";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Peticion")) {
            return "4";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Solicitud")) {
            return "5";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Derecho de peticion")) {
            return "6";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Citacion")) {
            return "7";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Memorando")) {
            return "8";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Caja")) {
            return "9";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Factura")) {
            return "10";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Remision")) {
            return "11";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Paquete")) {
            return "12";
        }
        else if (jcbxTipoDocumento.getSelectedItem().equals("Otro")) {
            return "13";
        }
        else {
            JOptionPane.showMessageDialog(null, "No se selecciono un tipo de documento");
        }
        return null;
    }

}
