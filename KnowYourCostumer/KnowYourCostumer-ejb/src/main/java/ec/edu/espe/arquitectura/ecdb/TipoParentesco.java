/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ecdb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tipo_parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoParentesco.findAll", query = "SELECT t FROM TipoParentesco t")
    , @NamedQuery(name = "TipoParentesco.findByCodTipoParentesco", query = "SELECT t FROM TipoParentesco t WHERE t.codTipoParentesco = :codTipoParentesco")
    , @NamedQuery(name = "TipoParentesco.findByDescripcion", query = "SELECT t FROM TipoParentesco t WHERE t.descripcion = :descripcion")})
public class TipoParentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_parentesco")
    private Short codTipoParentesco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoParentesco")
    private List<Parentesco> parentescoList;

    public TipoParentesco() {
    }

    public TipoParentesco(Short codTipoParentesco) {
        this.codTipoParentesco = codTipoParentesco;
    }

    public TipoParentesco(Short codTipoParentesco, String descripcion) {
        this.codTipoParentesco = codTipoParentesco;
        this.descripcion = descripcion;
    }

    public Short getCodTipoParentesco() {
        return codTipoParentesco;
    }

    public void setCodTipoParentesco(Short codTipoParentesco) {
        this.codTipoParentesco = codTipoParentesco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Parentesco> getParentescoList() {
        return parentescoList;
    }

    public void setParentescoList(List<Parentesco> parentescoList) {
        this.parentescoList = parentescoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoParentesco != null ? codTipoParentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoParentesco)) {
            return false;
        }
        TipoParentesco other = (TipoParentesco) object;
        if ((this.codTipoParentesco == null && other.codTipoParentesco != null) || (this.codTipoParentesco != null && !this.codTipoParentesco.equals(other.codTipoParentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoParentesco[ codTipoParentesco=" + codTipoParentesco + " ]";
    }
    
}
