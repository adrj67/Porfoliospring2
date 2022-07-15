
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
@Table (name = "estudios")
public class Estudios implements Serializable{
    private static final long serialVersionUID = 4L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column (name = "id")
    private int id;
    
    @Column (name = "institucion")
    private String institucion;
    
    @Column (name = "anio")
    private String anio;
    
    @Column (name = "titulo")
    private String titulo;
    
    @Column (name = "fk_idusuario")
    private int fkIdUsuario;    

    public Estudios() {
    }

    public Estudios(int id, String institucion, String anio, String titulo, int fkIdUsuario) {
        this.id = id;
        this.institucion = institucion;
        this.anio = anio;
        this.titulo = titulo;
        this.fkIdUsuario = fkIdUsuario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public String toString() {
        return "Estudios{" + "id=" + id + ", institucion=" + institucion + ", anio=" + anio + ", titulo=" + titulo + ", fkIdUsuario=" + fkIdUsuario + '}';
    }
    
}