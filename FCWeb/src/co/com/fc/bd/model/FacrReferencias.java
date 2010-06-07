package co.com.fc.bd.model;



/**
 * FacrReferencias entity. @author MyEclipse Persistence Tools
 */

public class FacrReferencias  implements java.io.Serializable {


    // Fields    

     private Long consReferencia;
     private FacrSolicitante facrSolicitante;
     private String identificacion;
     private String nombre;
     private String telefono;
     private String direccion;
     private Long parentesco;
     private Long tipoReferencia;


    // Constructors

    /** default constructor */
    public FacrReferencias() {
    }

	/** minimal constructor */
    public FacrReferencias(Long consReferencia, FacrSolicitante facrSolicitante, String identificacion, String nombre, String telefono, String direccion, Long tipoReferencia) {
        this.consReferencia = consReferencia;
        this.facrSolicitante = facrSolicitante;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoReferencia = tipoReferencia;
    }
    
    /** full constructor */
    public FacrReferencias(Long consReferencia, FacrSolicitante facrSolicitante, String identificacion, String nombre, String telefono, String direccion, Long parentesco, Long tipoReferencia) {
        this.consReferencia = consReferencia;
        this.facrSolicitante = facrSolicitante;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.parentesco = parentesco;
        this.tipoReferencia = tipoReferencia;
    }

   
    // Property accessors

    public Long getConsReferencia() {
        return this.consReferencia;
    }
    
    public void setConsReferencia(Long consReferencia) {
        this.consReferencia = consReferencia;
    }

    public FacrSolicitante getFacrSolicitante() {
        return this.facrSolicitante;
    }
    
    public void setFacrSolicitante(FacrSolicitante facrSolicitante) {
        this.facrSolicitante = facrSolicitante;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getParentesco() {
        return this.parentesco;
    }
    
    public void setParentesco(Long parentesco) {
        this.parentesco = parentesco;
    }

    public Long getTipoReferencia() {
        return this.tipoReferencia;
    }
    
    public void setTipoReferencia(Long tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }
   








}