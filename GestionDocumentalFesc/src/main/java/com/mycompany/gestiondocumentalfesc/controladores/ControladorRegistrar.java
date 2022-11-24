
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.conexion.Conexion;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jCheckBoxRequiereRespuesta;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxCarrera;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxSeleccionarDestinatario;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxSeleccionarEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxSeleccionarEstudiante;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxTipoDocumento;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jComboBoxTipoRadicado;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.jDateFecha;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtArea;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtAsunto;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtCargo;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtCorreoDestinatario;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtCorreoEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtCorreoEstudiante;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtDocDestinatario;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtDocEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtDocEstudiante;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNit;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNombreEmpleadoEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNombreEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNombreEstudiante;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNombresDestinatario;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNumAnexos;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtNumRadicado;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtSemestre;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtTelefonoDestinatario;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtTelefonoEmpresa;
import static com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar.txtTelefonoEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ControladorRegistrar implements ActionListener {
    
    private JFrameRegistrar jFrameRegistrar;
    
    public ControladorRegistrar(JFrameRegistrar jFrameRegistrar) {
        this.jFrameRegistrar = jFrameRegistrar;
    }
    
    public void iniciar() {
        jFrameRegistrar.setLocationRelativeTo(jFrameRegistrar);
        jFrameRegistrar.setVisible(true);
    }
    
    Conexion conexion = new Conexion();
    Connection connection = conexion.conectar();

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == JFrameRegistrar.jtbGuardarDatosEstudiante) {
            
        String sql;
        String docEstudianteRemitente = txtDocEstudiante.getText();
        String nombreEstudianteRemitente = txtNombreEstudiante.getText();
        String carrera = jComboBoxCarrera.getSelectedItem().toString();
        String semestre = txtSemestre.getText();
        String correoRemitente = txtCorreoEstudiante.getText();
        String telefonoRemitente = txtTelefonoEstudiante.getText();
        
        sql = "INSERT INTO `estudiante`(`idEstudiante`, `docEstudiante`, `nombresEstudiante`, `carrera`, `semestre`, `correoEstudiante`, `telefonoEstudiante`) VALUES(null,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, docEstudianteRemitente);
            ps.setString(2, nombreEstudianteRemitente);
            ps.setString(3, carrera);
            ps.setString(4, semestre);
            ps.setString(5, correoRemitente);
            ps.setString(6, telefonoRemitente);
            int consulta1 = ps.executeUpdate();
            
            if(consulta1 > 0) {
                JOptionPane.showMessageDialog(null, "Datos del estudiante subidos con exito");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al subir datos" + "" +ex.getMessage());
            }
        }
        
        if(e.getSource() == JFrameRegistrar.jtbGuardarDatosEmpresa) {
            
        String sql;
        String docEmpresaRemitente = txtDocEmpresa.getText();
        String nombreEmpresaRemitente = txtNombreEmpresa.getText();
        String nit = txtNit.getText();
        String nombreEmpleadoRemitente = txtNombreEmpleadoEmpresa.getText();
        String correoEmpresaRemitente = txtCorreoEmpresa.getText();
        String telefonoCompaniaRemitente = txtTelefonoEmpresa.getText();
        
        sql = "INSERT INTO `empresa`(`idEmpresa`, `docEmpresa`, `nombreEmpresa`, `nit`, `nombreEmpleado`, `correoEmpresa`, `telefonoEmpresa`) VALUES(null,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, docEmpresaRemitente);
            ps.setString(2, nombreEmpresaRemitente);
            ps.setString(3, nit);
            ps.setString(4, nombreEmpleadoRemitente);
            ps.setString(5, correoEmpresaRemitente);
            ps.setString(6, telefonoCompaniaRemitente);
            int consulta2 = ps.executeUpdate();
            
            if(consulta2 > 0) {
               JOptionPane.showMessageDialog(null, "Datos de la empresa subidos con exito"); 
            }
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al subir datos\n" + ex);
            }
        }
        
        if(e.getSource() == JFrameRegistrar.jtbGuardarDatosDestinatario) {
            
        String sql;
        String docDestinatario = txtDocDestinatario.getText();
        String cargo = txtCargo.getText();
        String correoDestinatario = txtCorreoDestinatario.getText();
        String area = txtArea.getText();
        String nombresDestinatario = txtNombresDestinatario.getText();
        String telefonoDestinatario = txtTelefonoDestinatario.getText();
        
        sql = "INSERT INTO `destinatario`(`idDestinatario`, `docDestinatario`, `cargo`, `nombreDestinatario`, `area`, `correoDestinatario`, `telefonoDestinatario`) VALUES(null,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, docDestinatario);
            ps.setString(2, cargo);
            ps.setString(3, nombresDestinatario);
            ps.setString(4, area);
            ps.setString(5, correoDestinatario);
            ps.setString(6, telefonoDestinatario);
            int consulta3 = ps.executeUpdate();
            
            if(consulta3 > 0) {
                JOptionPane.showMessageDialog(null, "Datos del destinatario subidos con exito"); 
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al subir datos\n" + ex);
                }
            }
        
        if(e.getSource() == JFrameRegistrar.jtbGuardarDatos) {
            
            String sql;
            String asunto = txtAsunto.getText();
            String numRadicado = txtNumRadicado.getText();
            String tipoRadicado = jComboBoxTipoRadicado.getSelectedItem().toString();
            String fecha = ((JTextField)jDateFecha.getDateEditor().getUiComponent()).getText();
            String numAnexo = txtNumAnexos.getText();
            String tipoDocumento = jComboBoxTipoDocumento.getSelectedItem().toString();
            String selecEstudiante = jComboBoxSeleccionarEstudiante.getSelectedItem().toString();
            String selecEmpresa = jComboBoxSeleccionarEmpresa.getSelectedItem().toString();
            String selecDestinatario = jComboBoxSeleccionarDestinatario.getSelectedItem().toString();
            String reqRespuesta = getJchReqRespuesta();
            
            sql = "INSERT INTO `documento`(`idDocumento`, `asunto`, `numeroRadicado`, `numeroAnexo`, `fecha`, `tipoRadicado`, `tipoDocumento`, `estudianteNombre`, `empresaNombre`, `destinatarioNombre`, `reqRespuesta`) VALUES (null,?,?,?,?,?,?,?,?,?,?)";
            
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, asunto);
                ps.setString(2, numRadicado);
                ps.setString(3, numAnexo);
                ps.setDate(4, (Date) Date.valueOf(fecha));
                ps.setString(5, tipoRadicado);
                ps.setString(6, tipoDocumento);
                ps.setString(7, selecEstudiante);
                ps.setString(8, selecEmpresa);
                ps.setString(9, selecDestinatario);
                ps.setString(10, reqRespuesta);
                int consulta4 = ps.executeUpdate();
                
                if(consulta4 > 0) {
                    JOptionPane.showMessageDialog(null, "Datos del documento subidos con exito"); 
                }
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al subir datos\n" + ex);
            }
        }
        
        if(e.getSource() == JFrameRegistrar.jButtonActualizar) {
            JFrameRegistrar main = new JFrameRegistrar();
            main.setVisible(true);
            this.dispose(); 
        }
    }
    
    public static String getJchReqRespuesta() {
        
        if(jCheckBoxRequiereRespuesta.isSelected()) {
            return "1";
        }
        else {
            return "0";
        }
    }

    public void dispose() {
    }
}

    
