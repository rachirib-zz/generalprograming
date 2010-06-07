package co.com.fc.bd.model;



/**
 * FacrInmuebleGarantia entity. @author MyEclipse Persistence Tools
 */

public class FacrInmuebleGarantia  implements java.io.Serializable {


    // Fields    

     private Long consInmueble;
     private FacrCredito facrCredito;
     private Long tipoInmueble;
     private Double valorComercial;
     private String registroEscrituras;


    // Constructors

    /** default constructor */
    public FacrInmuebleGarantia() {
    }

    
    /** full constructor */
    public FacrInmuebleGarantia(Long consInmueble, FacrCredito facrCredito, Long tipoInmueble, Double valorComercial, String registroEscrituras) {
        this.consInmueble = consInmueble;
        this.facrCredito = facrCredito;
        this.tipoInmueble = tipoInmueble;
        this.valorComercial = valorComercial;
        this.registroEscrituras = registroEscrituras;
    }

   
    // Property accessors

    public Long getConsInmueble() {
        return this.consInmueble;
    }
    
    public void setConsInmueble(Long consInmueble) {
        this.consInmueble = consInmueble;
    }

    public FacrCredito getFacrCredito() {
        return this.facrCredito;
    }
    
    public void setFacrCredito(FacrCredito facrCredito) {
        this.facrCredito = facrCredito;
    }

    public Long getTipoInmueble() {
        return this.tipoInmueble;
    }
    
    public void setTipoInmueble(Long tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Double getValorComercial() {
        return this.valorComercial;
    }
    
    public void setValorComercial(Double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getRegistroEscrituras() {
        return this.registroEscrituras;
    }
    
    public void setRegistroEscrituras(String registroEscrituras) {
        this.registroEscrituras = registroEscrituras;
    }
   








}