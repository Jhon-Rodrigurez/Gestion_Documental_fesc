
package com.mycompany.gestiondocumentalfesc.modelos;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Documento {
    
    private int id;
    private String nombreArchivo;
    private String rutaArchivo;
    private Timestamp fecha;
    private String numRadicado;
    private boolean tipoRadicado;
    private String asunto;
    private String anexos;
    private boolean reqRespuesta;
    private int tipoDocumento;
    private int remitenteId;
    private int destinatarioId;
    private int respuestaId;

    public Documento() {
    }
    
    public Documento(String nombreArchivo, String rutaArchivo, Timestamp fecha, String numRadicado, boolean tipoRadicado, String asunto, String anexos, boolean reqRespuesta, int tipoDocumento, int remitenteId, int destinatarioId, int respuestaId) {
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.fecha = fecha;
        this.numRadicado = numRadicado;
        this.tipoRadicado = tipoRadicado;
        this.asunto = asunto;
        this.anexos = anexos;
        this.reqRespuesta = reqRespuesta;
        this.tipoDocumento = tipoDocumento;
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        this.respuestaId = respuestaId;
    }
    
    public Documento(int id, String nombreArchivo, String rutaArchivo, Timestamp fecha, String numRadicado, boolean tipoRadicado, String asunto, String anexos, boolean reqRespuesta, int tipoDocumento, int remitenteId, int destinatarioId, int respuestaId) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.fecha = fecha;
        this.numRadicado = numRadicado;
        this.tipoRadicado = tipoRadicado;
        this.asunto = asunto;
        this.anexos = anexos;
        this.reqRespuesta = reqRespuesta;
        this.tipoDocumento = tipoDocumento;
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        this.respuestaId = respuestaId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the rutaArchivo
     */
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    /**
     * @param rutaArchivo the rutaArchivo to set
     */
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * @return the fecha
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numRadicado
     */
    public String getNumRadicado() {
        return numRadicado;
    }

    /**
     * @param numRadicado the numRadicado to set
     */
    public void setNumRadicado(String numRadicado) {
        this.numRadicado = numRadicado;
    }

    /**
     * @return the tipoRadicado
     */
    public boolean isTipoRadicado() {
        return tipoRadicado;
    }

    /**
     * @param tipoRadicado the tipoRadicado to set
     */
    public void setTipoRadicado(boolean tipoRadicado) {
        this.tipoRadicado = tipoRadicado;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the anexos
     */
    public String getAnexos() {
        return anexos;
    }

    /**
     * @param anexos the anexos to set
     */
    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    /**
     * @return the reqRespuesta
     */
    public boolean isReqRespuesta() {
        return reqRespuesta;
    }

    /**
     * @param reqRespuesta the reqRespuesta to set
     */
    public void setReqRespuesta(boolean reqRespuesta) {
        this.reqRespuesta = reqRespuesta;
    }

    /**
     * @return the tipoDocumento
     */
    public int getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the remitenteId
     */
    public int getRemitenteId() {
        return remitenteId;
    }

    /**
     * @param remitenteId the remitenteId to set
     */
    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    /**
     * @return the destinatarioId
     */
    public int getDestinatarioId() {
        return destinatarioId;
    }

    /**
     * @param destinatarioId the destinatarioId to set
     */
    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    /**
     * @return the respuestaId
     */
    public int getRespuestaId() {
        return respuestaId;
    }

    /**
     * @param respuestaId the respuestaId to set
     */
    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }
    
    public static ArrayList<Documento> getDocumentos() {
        
        ArrayList<Documento> arrayListDocumentos = new ArrayList<>();
        
        int id = 1;
        String nomDoc = "pdf1.pdf";
        String rutaDoc = "C:\\Users\\Familia\\Documents\\pdf\\pdf1.pdf";
        long dateTime = System.currentTimeMillis();
        Timestamp fecha = new Timestamp(dateTime);
        String numRad = "3245";
        boolean tpRad = true;
        String asunto = "ejemplo1";
        String anexos = "ejemplo1";
        boolean reqRes = true;
        int clDoc = 3;
        int idRemitente = 1;
        int idDestinatario = 1;
        int idRespuesta = 0;
        
        Documento doc1 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        id = 2;
        nomDoc = "pdf2.pdf";
        rutaDoc = "C:\\Users\\Familia\\Documents\\pdf\\pdf2.pdf";
        dateTime = System.currentTimeMillis();
        fecha = new Timestamp(dateTime);
        numRad = "7436";
        tpRad = false;
        asunto = "ejemplo2";
        anexos = "ejemplo2";
        reqRes = false;
        clDoc = 2;
        idRemitente = 1;
        idDestinatario = 1;
        idRespuesta = 1;
        
        Documento doc2 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        id = 3;
        nomDoc = "pdf3.pdf";
        rutaDoc = "C:\\Users\\Familia\\Documents\\pdf\\pdf3.pdf";
        dateTime = System.currentTimeMillis();
        fecha = new Timestamp(dateTime);
        numRad = "0983";
        tpRad = true;
        asunto = "ejemplo3";
        anexos = "ejemplo3";
        reqRes = false;
        clDoc = 7;
        idRemitente = 2;
        idDestinatario = 2;
        idRespuesta = 0;
        
        Documento doc3 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        id = 4;
        nomDoc = "pdf4.pdf";
        rutaDoc = "C:\\Users\\Familia\\Documents\\pdf\\pdf4.pdf";
        dateTime = System.currentTimeMillis();
        fecha = new Timestamp(dateTime);
        numRad = "8567";
        tpRad = true;
        asunto = "ejemplo4";
        anexos = "ejemplo4";
        reqRes = true;
        clDoc = 8;
        idRemitente = 10;
        idDestinatario = 3;
        idRespuesta = 0;
        
        Documento doc4 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        id = 5;
        nomDoc = "pdf5.pdf";
        rutaDoc = "C:\\Users\\Familia\\Documents\\pdf\\pdf5.pdf";
        dateTime = System.currentTimeMillis();
        fecha = new Timestamp(dateTime);
        numRad = "0983";
        tpRad = false;
        asunto = "ejemplo3";
        anexos = "ejemplo3";
        reqRes = false;
        clDoc = 7;
        idRemitente = 20;
        idDestinatario = 3;
        idRespuesta = 4;
        
        Documento doc5 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        
        arrayListDocumentos.add(doc1);
        arrayListDocumentos.add(doc2);
        arrayListDocumentos.add(doc3);
        arrayListDocumentos.add(doc4);
        arrayListDocumentos.add(doc5);
        
        return arrayListDocumentos;
    }
}
