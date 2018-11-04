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
@Table(name = "tipo_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t")
    , @NamedQuery(name = "TipoIdentificacion.findByCodTipoIdentificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.codTipoIdentificacion = :codTipoIdentificacion")
    , @NamedQuery(name = "TipoIdentificacion.findByDescripcion", query = "SELECT t FROM TipoIdentificacion t WHERE t.descripcion = :descripcion")})
public class TipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_identificacion")
    private Short codTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoIdentificacion")
    private List<Identificacion> identificacionList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Short codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    public TipoIdentificacion(Short codTipoIdentificacion, String descripcion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
        this.descripcion = descripcion;
    }

    public Short getCodTipoIdentificacion() {
        return codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(Short codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Identificacion> getIdentificacionList() {
        return identificacionList;
    }

    public void setIdentificacionList(List<Identificacion> identificacionList) {
        this.identificacionList = identificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoIdentificacion != null ? codTipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.codTipoIdentificacion == null && other.codTipoIdentificacion != null) || (this.codTipoIdentificacion != null && !this.codTipoIdentificacion.equals(other.codTipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoIdentificacion[ codTipoIdentificacion=" + codTipoIdentificacion + " ]";
    }
    
}
