package co.com.fc.bd.model;

import java.util.HashSet;
import java.util.Set;


/**
 * FacrPTipoParametro entity. @author MyEclipse Persistence Tools
 */

public class FacrPTipoParametro  implements java.io.Serializable {


    // Fields    

     private Long consTipoParametro;
     private String descripcion;
     private String valor;
     private Set facrPParametros = new HashSet(0);


    // Constructors

    /** default constructor */
    public FacrPTipoParametro() {
    }

	/** minimal constructor */
    public FacrPTipoParametro(Long consTipoParametro, String valor) {
        this.consTipoParametro = consTipoParametro;
        this.valor = valor;
    }
    
    /** full constructor */
    public FacrPTipoParametro(Long consTipoParametro, String descripcion, String valor, Set facrPParametros) {
        this.consTipoParametro = consTipoParametro;
        this.descripcion = descripcion;
        this.valor = valor;
        this.facrPParametros = facrPParametros;
    }

   
    // Property accessors

    public Long getConsTipoParametro() {
        return this.consTipoParametro;
    }
    
    public void setConsTipoParametro(Long consTipoParametro) {
        this.consTipoParametro = consTipoParametro;
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

    public Set getFacrPParametros() {
        return this.facrPParametros;
    }
    
    public void setFacrPParametros(Set facrPParametros) {
        this.facrPParametros = facrPParametros;
    }
   








}