package co.com.fc.bd.model;



/**
 * FacrPParametro entity. @author MyEclipse Persistence Tools
 */

public class FacrPParametro  implements java.io.Serializable {


    // Fields    

     private Long consParamtro;
     private FacrPTipoParametro facrPTipoParametro;
     private String descripcion;
     private String valor;


    // Constructors

    /** default constructor */
    public FacrPParametro() {
    }

	/** minimal constructor */
    public FacrPParametro(Long consParamtro, FacrPTipoParametro facrPTipoParametro, String valor) {
        this.consParamtro = consParamtro;
        this.facrPTipoParametro = facrPTipoParametro;
        this.valor = valor;
    }
    
    /** full constructor */
    public FacrPParametro(Long consParamtro, FacrPTipoParametro facrPTipoParametro, String descripcion, String valor) {
        this.consParamtro = consParamtro;
        this.facrPTipoParametro = facrPTipoParametro;
        this.descripcion = descripcion;
        this.valor = valor;
    }

   
    // Property accessors

    public Long getConsParamtro() {
        return this.consParamtro;
    }
    
    public void setConsParamtro(Long consParamtro) {
        this.consParamtro = consParamtro;
    }

    public FacrPTipoParametro getFacrPTipoParametro() {
        return this.facrPTipoParametro;
    }
    
    public void setFacrPTipoParametro(FacrPTipoParametro facrPTipoParametro) {
        this.facrPTipoParametro = facrPTipoParametro;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
   








}