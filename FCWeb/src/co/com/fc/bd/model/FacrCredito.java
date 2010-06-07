package co.com.fc.bd.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * FacrCredito entity. @author MyEclipse Persistence Tools
 */

public class FacrCredito  implements java.io.Serializable {


    // Fields    

     private Long consCredito;
     private FacrSolicitante facrSolicitante;
     private Double montoCredito;
     private Date fechaSolicitud;
     private Date fechaAprobacion;
     private Long estadoCredito;
     private Set facrInmuebleGarantias = new HashSet(0);


    // Constructors

    /** default constructor */
    public FacrCredito() {
    }

	/** minimal constructor */
    public FacrCredito(Long consCredito, FacrSolicitante facrSolicitante, Double montoCredito, Date fechaSolicitud, Long estadoCredito) {
        this.consCredito = consCredito;
        this.facrSolicitante = facrSolicitante;
        this.montoCredito = montoCredito;
        this.fechaSolicitud = fechaSolicitud;
        this.estadoCredito = estadoCredito;
    }
    
    /** full constructor */
    public FacrCredito(Long consCredito, FacrSolicitante facrSolicitante, Double montoCredito, Date fechaSolicitud, Date fechaAprobacion, Long estadoCredito, Set facrInmuebleGarantias) {
        this.consCredito = consCredito;
        this.facrSolicitante = facrSolicitante;
        this.montoCredito = montoCredito;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaAprobacion = fechaAprobacion;
        this.estadoCredito = estadoCredito;
        this.facrInmuebleGarantias = facrInmuebleGarantias;
    }

   
    // Property accessors

    public Long getConsCredito() {
        return this.consCredito;
    }
    
    public void setConsCredito(Long consCredito) {
        this.consCredito = consCredito;
    }

    public FacrSolicitante getFacrSolicitante() {
        return this.facrSolicitante;
    }
    
    public void setFacrSolicitante(FacrSolicitante facrSolicitante) {
        this.facrSolicitante = facrSolicitante;
    }

    public Double getMontoCredito() {
        return this.montoCredito;
    }
    
    public void setMontoCredito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }
    
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaAprobacion() {
        return this.fechaAprobacion;
    }
    
    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Long getEstadoCredito() {
        return this.estadoCredito;
    }
    
    public void setEstadoCredito(Long estadoCredito) {
        this.estadoCredito = estadoCredito;
    }

    public Set getFacrInmuebleGarantias() {
        return this.facrInmuebleGarantias;
    }
    
    public void setFacrInmuebleGarantias(Set facrInmuebleGarantias) {
        this.facrInmuebleGarantias = facrInmuebleGarantias;
    }
   








}