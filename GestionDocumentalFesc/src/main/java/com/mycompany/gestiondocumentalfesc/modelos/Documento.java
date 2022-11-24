
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
    private int claseDocumento;
    private int remitenteId;
    private int encargadoId;
    private int respuestaId;

    public Documento() {
    }
    
    public Documento(String nombreArchivo, String rutaArchivo, Timestamp fecha, String numRadicado, boolean tipoRadicado, String asunto, String anexos, boolean reqRespuesta, int claseDocumento, int remitenteId, int encargadoId, int respuestaId) {
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.fecha = fecha;
        this.numRadicado = numRadicado;
        this.tipoRadicado = tipoRadicado;
        this.asunto = asunto;
        this.anexos = anexos;
        this.reqRespuesta = reqRespuesta;
        this.claseDocumento = claseDocumento;
        this.remitenteId = remitenteId;
        this.encargadoId = encargadoId;
        this.respuestaId = respuestaId;
    }

    public Documento(int id, String nombreArchivo, String rutaArchivo, Timestamp fecha, String numRadicado, boolean tipoRadicado, String asunto, String anexos, boolean reqRespuesta, int claseDocumento, int remitenteId, int encargadoId, int respuestaId) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.fecha = fecha;
        this.numRadicado = numRadicado;
        this.tipoRadicado = tipoRadicado;
        this.asunto = asunto;
        this.anexos = anexos;
        this.reqRespuesta = reqRespuesta;
        this.claseDocumento = claseDocumento;
        this.remitenteId = remitenteId;
        this.encargadoId = encargadoId;
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
     * @return the claseDocumento
     */
    public int getClaseDocumento() {
        return claseDocumento;
    }

    /**
     * @param claseDocumento the claseDocumento to set
     */
    public void setClaseDocumento(int claseDocumento) {
        this.claseDocumento = claseDocumento;
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
     * @return the encargadoId
     */
    public int getEncargadoId() {
        return encargadoId;
    }

    /**
     * @param encargadoId the encargadoId to set
     */
    public void setEncargadoId(int encargadoId) {
        this.encargadoId = encargadoId;
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
        String nomDoc = "Despliegue en Heroku de un Backend.pdf";
        String rutaDoc = "C:\\Users\\Familia\\Documents\\Docs\\Despliegue en Heroku de un Backend.pdf";
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
        int idRespuesta = 1;
        
        Documento doc1 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        id = 1;
        nomDoc = "previo1_sistemas operativos.pdf";
        rutaDoc = "C:\\Users\\Familia\\Documents\\Docs\\previo1_sistemas operativos.pdf";
        dateTime = System.currentTimeMillis();
        fecha = new Timestamp(dateTime);
        numRad = "7436";
        tpRad = false;
        asunto = "ejemplo2";
        anexos = "ejemplo2";
        reqRes = true;
        clDoc = 2;
        idRemitente = 1;
        idDestinatario = 2;
        idRespuesta = 0;
        
        Documento doc2 = new Documento(id, nomDoc, rutaDoc, fecha, numRad, tpRad, asunto, anexos, reqRes, clDoc, idRemitente, idDestinatario, idRespuesta);
        
        arrayListDocumentos.add(doc1);
        arrayListDocumentos.add(doc2);
        
        return arrayListDocumentos;
    }
}
