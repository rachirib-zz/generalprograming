package co.com.fc.bd.model;



/**
 * FacrDocumento entity. @author MyEclipse Persistence Tools
 */

public class FacrDocumento  implements java.io.Serializable {


    // Fields    

     private Long consDocumento;
     private FacrSolicitante facrSolicitante;
     private Long tipoDocumento;
     private String detalle;
     private String urlDocumento;


    // Constructors

    /** default constructor */
    public FacrDocumento() {
    }

	/** minimal constructor */
    public FacrDocumento(Long consDocumento, FacrSolicitante facrSolicitante, Long tipoDocumento, String urlDocumento) {
        this.consDocumento = consDocumento;
        this.facrSolicitante = facrSolicitante;
        this.tipoDocumento = tipoDocumento;
        this.urlDocumento = urlDocumento;
    }
    
    /** full constructor */
    public FacrDocumento(Long consDocumento, FacrSolicitante facrSolicitante, Long tipoDocumento, String detalle, String urlDocumento) {
        this.consDocumento = consDocumento;
        this.facrSolicitante = facrSolicitante;
        this.tipoDocumento = tipoDocumento;
        this.detalle = detalle;
        this.urlDocumento = urlDocumento;
    }

   
    // Property accessors

    public Long getConsDocumento() {
        return this.consDocumento;
    }
    
    public void setConsDocumento(Long consDocumento) {
        this.consDocumento = consDocumento;
    }

    public FacrSolicitante getFacrSolicitante() {
        return this.facrSolicitante;
    }
    
    public void setFacrSolicitante(FacrSolicitante facrSolicitante) {
        this.facrSolicitante = facrSolicitante;
    }

    public Long getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getUrlDocumento() {
        return this.urlDocumento;
    }
    
    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }
   








}