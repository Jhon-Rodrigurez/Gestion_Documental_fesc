
package com.mycompany.gestiondocumentalfesc.modelos;

import java.sql.Date;


public class Documento {
    
    private int id;
    private byte[] archivoPdf;
    private Date fecha;
    private String numRadicado;
    private boolean tipoRadicado;
    private String asunto;
    private String anexos;
    private boolean reqRespuesta;
    private String claseDocumento;
    private int remitenteId;
    private int encargadoId;
    private int respuestaId;

    public Documento() {
    }

    public Documento(int id, byte[] archivoPdf, Date fecha, String numRadicado, boolean tipoRadicado, String asunto, String anexos, boolean reqRespuesta, String claseDocumento, int remitenteId, int encargadoId, int respuestaId) {
        this.id = id;
        this.archivoPdf = archivoPdf;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getArchivoPdf() {
        return archivoPdf;
    }

    public void setArchivoPdf(byte[] archivoPdf) {
        this.archivoPdf = archivoPdf;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumRadicado() {
        return numRadicado;
    }

    public void setNumRadicado(String numRadicado) {
        this.numRadicado = numRadicado;
    }

    public boolean isTipoRadicado() {
        return tipoRadicado;
    }

    public void setTipoRadicado(boolean tipoRadicado) {
        this.tipoRadicado = tipoRadicado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public boolean isReqRespuesta() {
        return reqRespuesta;
    }

    public void setReqRespuesta(boolean reqRespuesta) {
        this.reqRespuesta = reqRespuesta;
    }

    public String getClaseDocumento() {
        return claseDocumento;
    }

    public void setClaseDocumento(String claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    public int getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    public int getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(int encargadoId) {
        this.encargadoId = encargadoId;
    }

    public int getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }
}
