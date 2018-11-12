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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByCodDireccion", query = "SELECT d FROM Direccion d WHERE d.codDireccion = :codDireccion")
    , @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero")
    , @NamedQuery(name = "Direccion.findByReferencia", query = "SELECT d FROM Direccion d WHERE d.referencia = :referencia")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_direccion")
    private Integer codDireccion;
    @Column(name = "numero")
    private Short numero;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<DireccionCliente> direccionClienteList;
    @JoinColumn(name = "cod_calle_trans", referencedColumnName = "cod_calle")
    @ManyToOne
    private Calle codCalleTrans;
    @JoinColumn(name = "cod_calle", referencedColumnName = "cod_calle")
    @ManyToOne(optional = false)
    private Calle codCalle;

    public Direccion() {
    }

    public Direccion(Integer codDireccion) {
        this.codDireccion = codDireccion;
    }

    public Integer getCodDireccion() {
        return codDireccion;
    }

    public void setCodDireccion(Integer codDireccion) {
        this.codDireccion = codDireccion;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @XmlTransient
    public List<DireccionCliente> getDireccionClienteList() {
        return direccionClienteList;
    }

    public void setDireccionClienteList(List<DireccionCliente> direccionClienteList) {
        this.direccionClienteList = direccionClienteList;
    }

    public Calle getCodCalleTrans() {
        return codCalleTrans;
    }

    public void setCodCalleTrans(Calle codCalleTrans) {
        this.codCalleTrans = codCalleTrans;
    }

    public Calle getCodCalle() {
        return codCalle;
    }

    public void setCodCalle(Calle codCalle) {
        this.codCalle = codCalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDireccion != null ? codDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.codDireccion == null && other.codDireccion != null) || (this.codDireccion != null && !this.codDireccion.equals(other.codDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Direccion[ codDireccion=" + codDireccion + " ]";
    }
    
}
