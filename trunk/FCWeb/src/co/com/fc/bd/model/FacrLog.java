package co.com.fc.bd.model;

import java.util.Date;


/**
 * FacrLog entity. @author MyEclipse Persistence Tools
 */

public class FacrLog  implements java.io.Serializable {


    // Fields    

     private Long consLog;
     private String descripcion;
     private Long numIdSolicitante;
     private Long numCredito;
     private Date fechaLog;


    // Constructors

    /** default constructor */
    public FacrLog() {
    }

    
    /** full constructor */
    public FacrLog(Long consLog, String descripcion, Long numIdSolicitante, Long numCredito, Date fechaLog) {
        this.consLog = consLog;
        this.descripcion = descripcion;
        this.numIdSolicitante = numIdSolicitante;
        this.numCredito = numCredito;
        this.fechaLog = fechaLog;
    }

   
    // Property accessors

    public Long getConsLog() {
        return this.consLog;
    }
    
    public void setConsLog(Long consLog) {
        this.consLog = consLog;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getNumIdSolicitante() {
        return this.numIdSolicitante;
    }
    
    public void setNumIdSolicitante(Long numIdSolicitante) {
        this.numIdSolicitante = numIdSolicitante;
    }

    public Long getNumCredito() {
        return this.numCredito;
    }
    
    public void setNumCredito(Long numCredito) {
        this.numCredito = numCredito;
    }

    public Date getFechaLog() {
        return this.fechaLog;
    }
    
    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
    }
   








}