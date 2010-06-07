package co.com.fc.bd.model;



/**
 * FacrUsuario entity. @author MyEclipse Persistence Tools
 */

public class FacrUsuario  implements java.io.Serializable {


    // Fields    

     private Long consUsuario;
     private String nombre;
     private Long rol;
     private String username;
     private String password;


    // Constructors

    /** default constructor */
    public FacrUsuario() {
    }

    
    /** full constructor */
    public FacrUsuario(Long consUsuario, String nombre, Long rol, String username, String password) {
        this.consUsuario = consUsuario;
        this.nombre = nombre;
        this.rol = rol;
        this.username = username;
        this.password = password;
    }

   
    // Property accessors

    public Long getConsUsuario() {
        return this.consUsuario;
    }
    
    public void setConsUsuario(Long consUsuario) {
        this.consUsuario = consUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRol() {
        return this.rol;
    }
    
    public void setRol(Long rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}