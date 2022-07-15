
package com.app.porfolio.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column (name = "id")
    private int id;
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "clave")
    private String clave;
    
    @Column (name = "fk_idrol")
    private int fkidrol;
    
   @OneToMany (mappedBy = "fkIdUsuario")
   private List<Datos> datosList;
   
    
   @OneToMany (mappedBy = "fkIdUsuario")
   private List<Estudios> estudiosList;
   
   
   @OneToMany (mappedBy = "fkIdUsuario")
   private List<Trabajos> trabajosList;
   
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getFkidrol() {
        return fkidrol;
    }

    public void setFkidrol(int fkidrol) {
        this.fkidrol = fkidrol;
    }

    public List<Estudios> getEstudiosList() {
        return estudiosList;
    }

    public void setEstudiosList(List<Estudios> estudiosList) {
        this.estudiosList = estudiosList;
    }

    public List<Trabajos> getTrabajosList() {
        return trabajosList;
    }

    public void setTrabajosList(List<Trabajos> trabajosList) {
        this.trabajosList = trabajosList;
    }
   
   public void setDatosList(List<Datos> datosList) {
        this.datosList =  datosList;
    }

    public List<Datos> getDatosList() {
        return datosList;
    }
    
}