
package com.mycompany.gestiondocumentalfesc.controladores;

import static com.mycompany.gestiondocumentalfesc.controladores.ControladorDetalles.copyFile;
import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameLoginUsuario;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarDocumento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ControladorRegistrar implements ActionListener {
    
    private JFrameRegistrarEntidades jFrameRegistrarEntidades;
    private JFrameRegistrarDocumento jFrameRegistrarDocumento;
    private EstudianteRemitente estudianteRemitente;
    private EmpresaRemitente empresaRemitente;
    private Destinatario destinatario;
    private Documento documento;
    
    public ControladorRegistrar(JFrameRegistrarEntidades jFrameRegistrarEntidades) {
        this.jFrameRegistrarEntidades = jFrameRegistrarEntidades;
//        this.jFrameRegistrarDocumento = jFrameRegistrarDocumento;
        this.estudianteRemitente = new EstudianteRemitente();
        this.empresaRemitente = new EmpresaRemitente();
        this.destinatario = new Destinatario();
        this.documento = new Documento();
        this.jFrameRegistrarEntidades.jtbGuardarDatosEstudiante.addActionListener(this);
        this.jFrameRegistrarEntidades.jtbGuardarDatosEmpresa.addActionListener(this);
        this.jFrameRegistrarEntidades.jtbGuardarDatosDestinatario.addActionListener(this);
//        this.jFrameRegistrarDocumento.jBotonAgregarRemitentes.addActionListener(this);
//        this.jFrameRegistrarDocumento.jBotonSeleccionarArchivo.addActionListener(this);
//        this.jFrameRegistrarDocumento.jBotonSubirDatos.addActionListener(this);
//        this.jFrameRegistrarDocumento.jbCerrarSesion.addActionListener(this);
//        this.jFrameRegistrarDocumento.jbVentanaConsultar.addActionListener(this);
    }
    public ControladorRegistrar(JFrameRegistrarDocumento jFrameRegistrarDocumento) {
        this.jFrameRegistrarDocumento = jFrameRegistrarDocumento;
        this.jFrameRegistrarDocumento.jBotonAgregarRemitentes.addActionListener(this);
        this.jFrameRegistrarDocumento.jBotonSeleccionarArchivo.addActionListener(this);
        this.jFrameRegistrarDocumento.jBotonSubirDatos.addActionListener(this);
        this.jFrameRegistrarDocumento.jbCerrarSesion.addActionListener(this);
        this.jFrameRegistrarDocumento.jbVentanaConsultar.addActionListener(this);
    }
    
    public void iniciar() {
        jFrameRegistrarDocumento.setLocationRelativeTo(jFrameRegistrarDocumento);
        jFrameRegistrarDocumento.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == jFrameRegistrarEntidades.jtbGuardarDatosEstudiante) {
            String docEstudianteRemitente = jFrameRegistrarEntidades.txtDocEstudiante.getText();
            String nombreEstudianteRemitente = jFrameRegistrarEntidades.txtNombreEstudiante.getText();
            String apellidoEstudianteRemitente = jFrameRegistrarEntidades.txtApellidosEstudiante.getText();
            String correoEstudianteRemitente = jFrameRegistrarEntidades.txtCorreoEstudiante.getText();
            String carrera = getCarrera();
            String semestre = jFrameRegistrarEntidades.txtSemestre.getText();
            
            if(!docEstudianteRemitente.equals("") && !nombreEstudianteRemitente.equals("") && !apellidoEstudianteRemitente.equals("") && 
               !correoEstudianteRemitente.equals("") && !carrera.equals("") && !semestre.equals("")) {
                
//                while(true) {
////                    if(iDaoRegistrarEntidades.registrarEstudianteRemitente(estudianteRemitente)) {
////                        JOptionPane.showMessageDialog(null, "Datos del estudiante subidos con exito");
//////                        int id = iDaoRegistrarEntidades.getit(estudianteRemitente.getDocumento())
////                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
//                    }
//                }
            }
        }
        if(e.getSource() == jFrameRegistrarEntidades.jtbGuardarDatosEmpresa) {
            String docEmpresaRemitente = jFrameRegistrarEntidades.txtDocEmpresa.getText();
            String nombreEmpleadoRemitente = jFrameRegistrarEntidades.txtNombreEmpleadoEmpresa.getText();
            String apellidoEmpleadoRemitente = jFrameRegistrarEntidades.txtApellidoEmpleadoEmpresa.getText();
            String correoEmpresaRemitente = jFrameRegistrarEntidades.txtCorreoEmpresa.getText();
            String nombreEmpresaRemitente = jFrameRegistrarEntidades.txtNombreEmpresa.getText();
            String nit = jFrameRegistrarEntidades.txtNit.getText();
            
            if(!docEmpresaRemitente.equals("") && !nombreEmpleadoRemitente.equals("") && !apellidoEmpleadoRemitente.equals("") && 
               !correoEmpresaRemitente.equals("") && !nombreEmpresaRemitente.equals("") && !nit.equals("")) {
                
//                while(true) {
//                    if(iDaoRegistrarEntidades.registrarEmpresaRemitente(empresaRemitente)) {
//                        JOptionPane.showMessageDialog(null, "Datos de la empresa subidos con exito");
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
//                    }
//                }
            }
        }
        if(e.getSource() == jFrameRegistrarEntidades.jtbGuardarDatosDestinatario) {
            String docDestinatario = jFrameRegistrarEntidades.txtDocDestinatario.getText();
            String nombresDestinatario = jFrameRegistrarEntidades.txtNombresDestinatario.getText();
            String apellidosDestinatario = jFrameRegistrarEntidades.txtApellidosDestinatario.getText();
            String correoDestinatario = jFrameRegistrarEntidades.txtCorreoDestinatario.getText();
            String cargo = jFrameRegistrarEntidades.txtCargo.getText();
            String area = jFrameRegistrarEntidades.txtArea.getText();
            
            if(!docDestinatario.equals("") && !nombresDestinatario.equals("") && !apellidosDestinatario.equals("") && 
               !correoDestinatario.equals("") && !cargo.equals("") && !area.equals("")) {
                
//                while(true) {
//                    if(iDaoRegistrarEntidades.registrarDestinatario(destinatario)) {
//                        JOptionPane.showMessageDialog(null, "Datos del destinatario subidos con exito");
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
//                    }
//                }
            }
        }
        if(e.getSource() == jFrameRegistrarDocumento.jBotonSubirDatos) {
            String nombreArchivo = jFrameRegistrarDocumento.txtNombreArchivo.getText();
            String rutaArchivo = jFrameRegistrarDocumento.txtRutaArchivo.getText();
            String fecha = ((JTextField)jFrameRegistrarDocumento.jDateFecha.getDateEditor().getUiComponent()).getText();
            String numRadicado = jFrameRegistrarDocumento.txtNumeroRadicado.getText();
            String tipoRadicado = getTipoRadicado();
            String tipoDocumento = getTipoDocumento();
            String asunto = jFrameRegistrarDocumento.txtAsunto.getText();
            String numAnexo = jFrameRegistrarDocumento.txtNumeroAnexos.getText();
            String reqRespuesta = getJchReqRespuesta();
            
            if(!nombreArchivo.equals("") && !rutaArchivo.equals("") && !fecha.equals("") && !numRadicado.equals("") && 
               !tipoRadicado.equals("") && !tipoDocumento.equals("") && !asunto.equals("") && !numAnexo.equals("") && 
               !reqRespuesta.equals("")) {
                
//                while(true) {
//                    if(iDaoRegistrarEntidades.registrarDocumento(documento)) {
//                        JOptionPane.showMessageDialog(null, "Datos del documento subidos con exito"); 
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
//                    }
//                }
            }
        }
    }
    
    public void seleccionarArchivo() {
        
        if(jFrameRegistrarDocumento.jBotonSeleccionarArchivo.isSelected()) {
            
            JFileChooser escoger = new JFileChooser();
            escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int estado = escoger.showOpenDialog(null);

            if(estado == JFileChooser.APPROVE_OPTION) {
                File archivo = escoger.getSelectedFile();
                    if((archivo == null || (archivo.getName().equals("")))) {
                        jFrameRegistrarDocumento.txtRutaArchivo.setText("...");
                    }
                    else {
                        jFrameRegistrarDocumento.txtRutaArchivo.setText(archivo.getAbsolutePath());
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
        }
    }
    public String getJchReqRespuesta() {
        
        if(jFrameRegistrarDocumento.jcbRequiereRespuesta.isSelected()) {
            return "1";
        }
        else {
            return "0";
        }
    }

    public String getCarrera() {
        if(jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Diseño grafico")) {
            return "1";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Diseño de modas")){
            return "2";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Hoteleria y turismo")) {
            return "3";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Ingenieria de software")) {
            return "4";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Negocios internacionales")) {
            return "5";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Administracion financiera")) {
            return "6";
        }
        else if (jFrameRegistrarEntidades.jComboBoxCarrera.getSelectedItem().equals("Logistica empresarial")) {
            return "7";
        }
        else {
            JOptionPane.showMessageDialog(null, "No se selecciono una carrera");
        }
        return null;
    }

    public String getTipoRadicado() {
        
        if(jFrameRegistrarDocumento.jcbxTipoRadicado.getSelectedItem().equals("Entrega")) {
            return "1";
        }
        else if(jFrameRegistrarDocumento.jcbxTipoRadicado.getSelectedItem().equals("Respuesta")) {
            return "2";
        }
        return null; 
    }

    public String getTipoDocumento() {
        
        if(jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Carta")) {
            return "1";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Acta")){
            return "2";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Copia")) {
            return "3";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Peticion")) {
            return "4";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Solicitud")) {
            return "5";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Derecho de peticion")) {
            return "6";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Citacion")) {
            return "7";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Memorando")) {
            return "8";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Caja")) {
            return "9";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Factura")) {
            return "10";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Remision")) {
            return "11";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Paquete")) {
            return "12";
        }
        else if (jFrameRegistrarDocumento.jcbxTipoDocumento.getSelectedItem().equals("Otro")) {
            return "13";
        }
        else {
            JOptionPane.showMessageDialog(null, "No se selecciono un tipo de documento");
        }
        return null;
    }
    
    public void ventanaConsultar() {
        
        if(jFrameRegistrarDocumento.jbVentanaConsultar.isSelected()) {
        JFrameConsultar rgf = new JFrameConsultar();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        }
    }
    
    public void ventanaRegistrarEntidades() {
        
        if(jFrameRegistrarDocumento.jBotonAgregarRemitentes.isSelected()) {
        JFrameRegistrarEntidades rgf = new JFrameRegistrarEntidades();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    public void cerrarSesion() {
        if(jFrameRegistrarDocumento.jbCerrarSesion.isSelected()) {
            String botones[] = {"Si","No"};
                int eleccion = JOptionPane.showOptionDialog(this.jFrameRegistrarDocumento, "¿Desea cerrar sesion?", "Cerrar sesion", 0, 0, null,
                botones, this);
        
        if(eleccion == JOptionPane.YES_OPTION) {
            JFrameLoginUsuario jflu = new JFrameLoginUsuario();
            jflu.setVisible(true);
            jflu.pack();
            jflu.setLocationRelativeTo(null);
            jflu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(eleccion == JOptionPane.NO_OPTION) {   
            }
        }
    }
}

    
