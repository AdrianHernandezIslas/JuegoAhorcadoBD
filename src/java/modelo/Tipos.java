/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "tipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipos.findAll", query = "SELECT t FROM Tipos t")
    , @NamedQuery(name = "Tipos.findByIdTipos", query = "SELECT t FROM Tipos t WHERE t.idTipos = :idTipos")
    , @NamedQuery(name = "Tipos.findByDescripcion", query = "SELECT t FROM Tipos t WHERE t.descripcion = :descripcion")})
public class Tipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipos")
    private Integer idTipos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;

    public Tipos() {
    }

    public Tipos(Integer idTipos) {
        this.idTipos = idTipos;
    }

    public Tipos(Integer idTipos, String descripcion) {
        this.idTipos = idTipos;
        this.descripcion = descripcion;
    }

    public Integer getIdTipos() {
        return idTipos;
    }

    public void setIdTipos(Integer idTipos) {
        this.idTipos = idTipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipos != null ? idTipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipos)) {
            return false;
        }
        Tipos other = (Tipos) object;
        if ((this.idTipos == null && other.idTipos != null) || (this.idTipos != null && !this.idTipos.equals(other.idTipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipos[ idTipos=" + idTipos + " ]";
    }
    
}
