/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author user
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_egreso")
    private Integer codTipoEgreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEgreso")
    private List<EgresoCliente> egresoClienteList;

    public TipoEgreso() {
    }

    public TipoEgreso(Integer codTipoEgreso) {
        this.codTipoEgreso = codTipoEgreso;
    }

    public TipoEgreso(Integer codTipoEgreso, String descripcion) {
        this.codTipoEgreso = codTipoEgreso;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoEgreso() {
        return codTipoEgreso;
    }

    public void setCodTipoEgreso(Integer codTipoEgreso) {
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
        return "dao.TipoEgreso[ codTipoEgreso=" + codTipoEgreso + " ]";
    }
    
}
