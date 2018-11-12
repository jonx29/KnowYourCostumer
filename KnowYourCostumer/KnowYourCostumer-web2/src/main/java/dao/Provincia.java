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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findByCodProvincia", query = "SELECT p FROM Provincia p WHERE p.codProvincia = :codProvincia")
    , @NamedQuery(name = "Provincia.findByNombre", query = "SELECT p FROM Provincia p WHERE p.nombre = :nombre")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_provincia")
    private Integer codProvincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Pais codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProvincia")
    private List<Ciudad> ciudadList;

    public Provincia() {
    }

    public Provincia(Integer codProvincia) {
        this.codProvincia = codProvincia;
    }

    public Provincia(Integer codProvincia, String nombre) {
        this.codProvincia = codProvincia;
        this.nombre = nombre;
    }

    public Integer getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(Integer codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProvincia != null ? codProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.codProvincia == null && other.codProvincia != null) || (this.codProvincia != null && !this.codProvincia.equals(other.codProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Provincia[ codProvincia=" + codProvincia + " ]";
    }
    
}
