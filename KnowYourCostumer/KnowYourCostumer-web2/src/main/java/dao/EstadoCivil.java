/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByCodEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.codEstadoCivil = :codEstadoCivil")
    , @NamedQuery(name = "EstadoCivil.findByDescripcion", query = "SELECT e FROM EstadoCivil e WHERE e.descripcion = :descripcion")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estado_civil")
    private Integer codEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codEstadoCivil")
    private List<Cliente> clienteList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public EstadoCivil(Integer codEstadoCivil, String descripcion) {
        this.codEstadoCivil = codEstadoCivil;
        this.descripcion = descripcion;
    }

    public Integer getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(Integer codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadoCivil != null ? codEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.codEstadoCivil == null && other.codEstadoCivil != null) || (this.codEstadoCivil != null && !this.codEstadoCivil.equals(other.codEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.EstadoCivil[ codEstadoCivil=" + codEstadoCivil + " ]";
    }
    
}
