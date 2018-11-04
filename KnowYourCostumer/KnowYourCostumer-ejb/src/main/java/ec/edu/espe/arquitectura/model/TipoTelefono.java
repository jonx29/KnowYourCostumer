/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

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
@Table(name = "tipo_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTelefono.findAll", query = "SELECT t FROM TipoTelefono t")
    , @NamedQuery(name = "TipoTelefono.findByCodTipoTelefono", query = "SELECT t FROM TipoTelefono t WHERE t.codTipoTelefono = :codTipoTelefono")
    , @NamedQuery(name = "TipoTelefono.findByDescripcion", query = "SELECT t FROM TipoTelefono t WHERE t.descripcion = :descripcion")})
public class TipoTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_telefono")
    private Short codTipoTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoTelefono")
    private List<NumeroTelefono> numeroTelefonoList;

    public TipoTelefono() {
    }

    public TipoTelefono(Short codTipoTelefono) {
        this.codTipoTelefono = codTipoTelefono;
    }

    public TipoTelefono(Short codTipoTelefono, String descripcion) {
        this.codTipoTelefono = codTipoTelefono;
        this.descripcion = descripcion;
    }

    public Short getCodTipoTelefono() {
        return codTipoTelefono;
    }

    public void setCodTipoTelefono(Short codTipoTelefono) {
        this.codTipoTelefono = codTipoTelefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<NumeroTelefono> getNumeroTelefonoList() {
        return numeroTelefonoList;
    }

    public void setNumeroTelefonoList(List<NumeroTelefono> numeroTelefonoList) {
        this.numeroTelefonoList = numeroTelefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoTelefono != null ? codTipoTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTelefono)) {
            return false;
        }
        TipoTelefono other = (TipoTelefono) object;
        if ((this.codTipoTelefono == null && other.codTipoTelefono != null) || (this.codTipoTelefono != null && !this.codTipoTelefono.equals(other.codTipoTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoTelefono[ codTipoTelefono=" + codTipoTelefono + " ]";
    }
    
}
