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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "profesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p")
    , @NamedQuery(name = "Profesion.findByCodProfesion", query = "SELECT p FROM Profesion p WHERE p.codProfesion = :codProfesion")
    , @NamedQuery(name = "Profesion.findByDescripcion", query = "SELECT p FROM Profesion p WHERE p.descripcion = :descripcion")})
public class Profesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_profesion")
    private Integer codProfesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "profesionList")
    private List<Cliente> clienteList;

    public Profesion() {
    }

    public Profesion(Integer codProfesion) {
        this.codProfesion = codProfesion;
    }

    public Profesion(Integer codProfesion, String descripcion) {
        this.codProfesion = codProfesion;
        this.descripcion = descripcion;
    }

    public Integer getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(Integer codProfesion) {
        this.codProfesion = codProfesion;
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
        hash += (codProfesion != null ? codProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.codProfesion == null && other.codProfesion != null) || (this.codProfesion != null && !this.codProfesion.equals(other.codProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Profesion[ codProfesion=" + codProfesion + " ]";
    }
    
}
