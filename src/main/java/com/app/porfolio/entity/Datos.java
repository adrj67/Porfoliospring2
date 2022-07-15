
package com.app.porfolio.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "datos")
public class Datos implements Serializable{
    private static final long serialVersionUID = 3L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column (name = "id")
    private int id;
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "fechaNac")
    private String fechaNac;
    
    @Column (name = "domicilio")
    private String domicilio;
    
    @Column (name = "correo")
    private String correo;
    
    @Column (name = "telefono")
    private String telefono;
    
    @Column (name = "fk_idusuario")
    private int fkIdUsuario;

    public Datos() {
    }

    public Datos(int id, String nombre, String fechaNac, String domicilio, String correo, String telefono, int fkIdUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
        this.correo = correo;
        this.telefono = telefono;
        this.fkIdUsuario = fkIdUsuario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

  
 
  public Datos(String nombre) {
    super();
    this.nombre = nombre;
  }
    
}
