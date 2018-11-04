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
@Table(name = "tipo_ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIngreso.findAll", query = "SELECT t FROM TipoIngreso t")
    , @NamedQuery(name = "TipoIngreso.findByCodTipoIngreso", query = "SELECT t FROM TipoIngreso t WHERE t.codTipoIngreso = :codTipoIngreso")
    , @NamedQuery(name = "TipoIngreso.findByDescripcion", query = "SELECT t FROM TipoIngreso t WHERE t.descripcion = :descripcion")})
public class TipoIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_ingreso")
    private Short codTipoIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoIngreso")
    private List<IngresoCliente> ingresoClienteList;

    public TipoIngreso() {
    }

    public TipoIngreso(Short codTipoIngreso) {
        this.codTipoIngreso = codTipoIngreso;
    }

    public TipoIngreso(Short codTipoIngreso, String descripcion) {
        this.codTipoIngreso = codTipoIngreso;
        this.descripcion = descripcion;
    }

    public Short getCodTipoIngreso() {
        return codTipoIngreso;
    }

    public void setCodTipoIngreso(Short codTipoIngreso) {
        this.codTipoIngreso = codTipoIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<IngresoCliente> getIngresoClienteList() {
        return ingresoClienteList;
    }

    public void setIngresoClienteList(List<IngresoCliente> ingresoClienteList) {
        this.ingresoClienteList = ingresoClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoIngreso != null ? codTipoIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIngreso)) {
            return false;
        }
        TipoIngreso other = (TipoIngreso) object;
        if ((this.codTipoIngreso == null && other.codTipoIngreso != null) || (this.codTipoIngreso != null && !this.codTipoIngreso.equals(other.codTipoIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoIngreso[ codTipoIngreso=" + codTipoIngreso + " ]";
    }
    
}
