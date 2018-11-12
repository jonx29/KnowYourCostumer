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
@Table(name = "tipo_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t")
    , @NamedQuery(name = "TipoCuenta.findByCodTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.codTipoCuenta = :codTipoCuenta")
    , @NamedQuery(name = "TipoCuenta.findByDescripcion", query = "SELECT t FROM TipoCuenta t WHERE t.descripcion = :descripcion")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_cuenta")
    private Integer codTipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoCuenta")
    private List<Cuenta> cuentaList;

    public TipoCuenta() {
    }

    public TipoCuenta(Integer codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    public TipoCuenta(Integer codTipoCuenta, String descripcion) {
        this.codTipoCuenta = codTipoCuenta;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(Integer codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoCuenta != null ? codTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.codTipoCuenta == null && other.codTipoCuenta != null) || (this.codTipoCuenta != null && !this.codTipoCuenta.equals(other.codTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.TipoCuenta[ codTipoCuenta=" + codTipoCuenta + " ]";
    }
    
}
