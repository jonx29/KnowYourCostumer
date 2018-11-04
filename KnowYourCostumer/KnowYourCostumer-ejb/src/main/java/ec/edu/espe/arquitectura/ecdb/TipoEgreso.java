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
@Table(name = "tipo_egreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEgreso.findAll", query = "SELECT t FROM TipoEgreso t")
    , @NamedQuery(name = "TipoEgreso.findByCodTipoEgreso", query = "SELECT t FROM TipoEgreso t WHERE t.codTipoEgreso = :codTipoEgreso")
    , @NamedQuery(name = "TipoEgreso.findByDescripcion", query = "SELECT t FROM TipoEgreso t WHERE t.descripcion = :descripcion")})
public class TipoEgreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_egreso")
    private Short codTipoEgreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoEgreso")
    private List<EgresoCliente> egresoClienteList;

    public TipoEgreso() {
    }

    public TipoEgreso(Short codTipoEgreso) {
        this.codTipoEgreso = codTipoEgreso;
    }

    public TipoEgreso(Short codTipoEgreso, String descripcion) {
        this.codTipoEgreso = codTipoEgreso;
        this.descripcion = descripcion;
    }

    public Short getCodTipoEgreso() {
        return codTipoEgreso;
    }

    public void setCodTipoEgreso(Short codTipoEgreso) {
        this.codTipoEgreso = codTipoEgreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<EgresoCliente> getEgresoClienteList() {
        return egresoClienteList;
    }

    public void setEgresoClienteList(List<EgresoCliente> egresoClienteList) {
        this.egresoClienteList = egresoClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoEgreso != null ? codTipoEgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEgreso)) {
            return false;
        }
        TipoEgreso other = (TipoEgreso) object;
        if ((this.codTipoEgreso == null && other.codTipoEgreso != null) || (this.codTipoEgreso != null && !this.codTipoEgreso.equals(other.codTipoEgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoEgreso[ codTipoEgreso=" + codTipoEgreso + " ]";
    }
    
}
