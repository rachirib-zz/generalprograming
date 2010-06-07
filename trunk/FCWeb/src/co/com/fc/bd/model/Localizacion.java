package co.com.fc.bd.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Localizacion entity. @author MyEclipse Persistence Tools
 */

public class Localizacion  implements java.io.Serializable {


    // Fields    

     private Long consLocalizacion;
     private Localizacion localizacion;
     private String descripcion;
     private Long nivel;
     private Set localizacions = new HashSet(0);
     private Set facrSolicitantes = new HashSet(0);


    // Constructors

    /** default constructor */
    public Localizacion() {
    }

	/** minimal constructor */
    public Localizacion(Long consLocalizacion, Localizacion localizacion, String descripcion, Long nivel) {
        this.consLocalizacion = consLocalizacion;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }
    
    /** full constructor */
    public Localizacion(Long consLocalizacion, Localizacion localizacion, String descripcion, Long nivel, Set localizacions, Set facrSolicitantes) {
        this.consLocalizacion = consLocalizacion;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.localizacions = localizacions;
        this.facrSolicitantes = facrSolicitantes;
    }

   
    // Property accessors

    public Long getConsLocalizacion() {
        return this.consLocalizacion;
    }
    
    public void setConsLocalizacion(Long consLocalizacion) {
        this.consLocalizacion = consLocalizacion;
    }

    public Localizacion getLocalizacion() {
        return this.localizacion;
    }
    
    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getNivel() {
        return this.nivel;
    }
    
    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Set getLocalizacions() {
        return this.localizacions;
    }
    
    public void setLocalizacions(Set localizacions) {
        this.localizacions = localizacions;
    }

    public Set getFacrSolicitantes() {
        return this.facrSolicitantes;
    }
    
    public void setFacrSolicitantes(Set facrSolicitantes) {
        this.facrSolicitantes = facrSolicitantes;
    }
   








}