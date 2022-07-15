
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
@Table (name = "trabajos")
public class Trabajos implements Serializable{
    private static final long serialVersionUID = 5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column (name = "id")
    private int id;
    
    @Column (name = "empresa")
    private String empresa;
    
    @Column (name = "desde")
    private String desde;
    
    @Column (name = "hasta")
    private String hasta;
    
    @Column (name = "tareas")
    private String tareas;
    
     @Column (name = "logo")
    private String logo;
    
    @Column (name = "fk_idusuario")
    private int fkIdUsuario; 

    public Trabajos() {
    }

    public Trabajos(int id, String empresa, String desde, String hasta, String tareas, String logo, int fkIdUsuario) {
        this.id = id;
        this.empresa = empresa;
        this.desde = desde;
        this.hasta = hasta;
        this.tareas = tareas;
        this.logo = logo;
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public String toString() {
        return "Trabajos{" + "id=" + id + ", empresa=" + empresa + ", desde=" + desde + ", hasta=" + hasta + ", tareas=" + tareas + ", logo=" + logo + ", fkIdUsuario=" + fkIdUsuario + '}';
    }

}
