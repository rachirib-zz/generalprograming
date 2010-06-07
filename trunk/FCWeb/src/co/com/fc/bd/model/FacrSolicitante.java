package co.com.fc.bd.model;

import java.util.HashSet;
import java.util.Set;


/**
 * FacrSolicitante entity. @author MyEclipse Persistence Tools
 */

public class FacrSolicitante  implements java.io.Serializable {


    // Fields    

     private String numId;
     private Localizacion localizacion;
     private Long tipoId;
     private String nombreSolicitante;
     private Double ingresos;
     private Double egresos;
     private Long tipoSolicitante;
     private Long tipoContrato;
     private Long tiempoFuncionamiento;
     private String direccion;
     private String telefonoContacto;
     private String telefonoResidencia;
     private Long numPersonasMenores;
     private Long numPersonasMayores;
     private Long calificacion;
     private Set facrDocumentos = new HashSet(0);
     private Set facrCreditos = new HashSet(0);
     private Set facrReferenciases = new HashSet(0);


    // Constructors

    /** default constructor */
    public FacrSolicitante() {
    }

	/** minimal constructor */
    public FacrSolicitante(String numId, Localizacion localizacion, Long tipoId, String nombreSolicitante, Long tipoSolicitante, String direccion, String telefonoContacto, String telefonoResidencia) {
        this.numId = numId;
        this.localizacion = localizacion;
        this.tipoId = tipoId;
        this.nombreSolicitante = nombreSolicitante;
        this.tipoSolicitante = tipoSolicitante;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.telefonoResidencia = telefonoResidencia;
    }
    
    /** full constructor */
    public FacrSolicitante(String numId, Localizacion localizacion, Long tipoId, String nombreSolicitante, Double ingresos, Double egresos, Long tipoSolicitante, Long tipoContrato, Long tiempoFuncionamiento, String direccion, String telefonoContacto, String telefonoResidencia, Long numPersonasMenores, Long numPersonasMayores, Long calificacion, Set facrDocumentos, Set facrCreditos, Set facrReferenciases) {
        this.numId = numId;
        this.localizacion = localizacion;
        this.tipoId = tipoId;
        this.nombreSolicitante = nombreSolicitante;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.tipoSolicitante = tipoSolicitante;
        this.tipoContrato = tipoContrato;
        this.tiempoFuncionamiento = tiempoFuncionamiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.telefonoResidencia = telefonoResidencia;
        this.numPersonasMenores = numPersonasMenores;
        this.numPersonasMayores = numPersonasMayores;
        this.calificacion = calificacion;
        this.facrDocumentos = facrDocumentos;
        this.facrCreditos = facrCreditos;
        this.facrReferenciases = facrReferenciases;
    }

   
    // Property accessors

    public String getNumId() {
        return this.numId;
    }
    
    public void setNumId(String numId) {
        this.numId = numId;
    }

    public Localizacion getLocalizacion() {
        return this.localizacion;
    }
    
    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Long getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombreSolicitante() {
        return this.nombreSolicitante;
    }
    
    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public Double getIngresos() {
        return this.ingresos;
    }
    
    public void setIngresos(Double ingresos) {
        this.ingresos = ingresos;
    }

    public Double getEgresos() {
        return this.egresos;
    }
    
    public void setEgresos(Double egresos) {
        this.egresos = egresos;
    }

    public Long getTipoSolicitante() {
        return this.tipoSolicitante;
    }
    
    public void setTipoSolicitante(Long tipoSolicitante) {
        this.tipoSolicitante = tipoSolicitante;
    }

    public Long getTipoContrato() {
        return this.tipoContrato;
    }
    
    public void setTipoContrato(Long tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Long getTiempoFuncionamiento() {
        return this.tiempoFuncionamiento;
    }
    
    public void setTiempoFuncionamiento(Long tiempoFuncionamiento) {
        this.tiempoFuncionamiento = tiempoFuncionamiento;
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }
    
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getTelefonoResidencia() {
        return this.telefonoResidencia;
    }
    
    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public Long getNumPersonasMenores() {
        return this.numPersonasMenores;
    }
    
    public void setNumPersonasMenores(Long numPersonasMenores) {
        this.numPersonasMenores = numPersonasMenores;
    }

    public Long getNumPersonasMayores() {
        return this.numPersonasMayores;
    }
    
    public void setNumPersonasMayores(Long numPersonasMayores) {
        this.numPersonasMayores = numPersonasMayores;
    }

    public Long getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public Set getFacrDocumentos() {
        return this.facrDocumentos;
    }
    
    public void setFacrDocumentos(Set facrDocumentos) {
        this.facrDocumentos = facrDocumentos;
    }

    public Set getFacrCreditos() {
        return this.facrCreditos;
    }
    
    public void setFacrCreditos(Set facrCreditos) {
        this.facrCreditos = facrCreditos;
    }

    public Set getFacrReferenciases() {
        return this.facrReferenciases;
    }
    
    public void setFacrReferenciases(Set facrReferenciases) {
        this.facrReferenciases = facrReferenciases;
    }
   








}