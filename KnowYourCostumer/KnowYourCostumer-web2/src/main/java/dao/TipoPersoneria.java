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
@Table(name = "tipo_personeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersoneria.findAll", query = "SELECT t FROM TipoPersoneria t")
    , @NamedQuery(name = "TipoPersoneria.findByCodTipoPersoneria", query = "SELECT t FROM TipoPersoneria t WHERE t.codTipoPersoneria = :codTipoPersoneria")
    , @NamedQuery(name = "TipoPersoneria.findByDescripcion", query = "SELECT t FROM TipoPersoneria t WHERE t.descripcion = :descripcion")})
public class TipoPersoneria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_personeria")
    private Integer codTipoPersoneria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoPersoneria")
    private List<Cliente> clienteList;

    public TipoPersoneria() {
    }

    public TipoPersoneria(Integer codTipoPersoneria) {
        this.codTipoPersoneria = codTipoPersoneria;
    }

    public TipoPersoneria(Integer codTipoPersoneria, String descripcion) {
        this.codTipoPersoneria = codTipoPersoneria;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoPersoneria() {
        return codTipoPersoneria;
    }

    public void setCodTipoPersoneria(Integer codTipoPersoneria) {
        this.codTipoPersoneria = codTipoPersoneria;
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
        hash += (codTipoPersoneria != null ? codTipoPersoneria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersoneria)) {
            return false;
        }
        TipoPersoneria other = (TipoPersoneria) object;
        if ((this.codTipoPersoneria == null && other.codTipoPersoneria != null) || (this.codTipoPersoneria != null && !this.codTipoPersoneria.equals(other.codTipoPersoneria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.TipoPersoneria[ codTipoPersoneria=" + codTipoPersoneria + " ]";
    }
    
}
