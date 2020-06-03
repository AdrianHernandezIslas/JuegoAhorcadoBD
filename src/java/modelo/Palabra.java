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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "palabra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabra.findAll", query = "SELECT p FROM Palabra p")
    , @NamedQuery(name = "Palabra.findByIdPalabra", query = "SELECT p FROM Palabra p WHERE p.idPalabra = :idPalabra")
    , @NamedQuery(name = "Palabra.findByPalabra", query = "SELECT p FROM Palabra p WHERE p.palabra = :palabra")
    , @NamedQuery(name = "Palabra.findByIdTipo", query = "SELECT p FROM Palabra p WHERE p.idTipo = :idTipo")
    , @NamedQuery(name = "Palabra.findByNivel", query = "SELECT p FROM Palabra p WHERE p.nivel = :nivel")})
public class Palabra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palabra")
    private Integer idPalabra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "palabra")
    private String palabra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo")
    private int idTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;

    public Palabra() {
    }

    public Palabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public Palabra(Integer idPalabra, String palabra, int idTipo, int nivel) {
        this.idPalabra = idPalabra;
        this.palabra = palabra;
        this.idTipo = idTipo;
        this.nivel = nivel;
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalabra != null ? idPalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabra)) {
            return false;
        }
        Palabra other = (Palabra) object;
        if ((this.idPalabra == null && other.idPalabra != null) || (this.idPalabra != null && !this.idPalabra.equals(other.idPalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Palabra[ idPalabra=" + idPalabra + " ]";
    }
    
}
