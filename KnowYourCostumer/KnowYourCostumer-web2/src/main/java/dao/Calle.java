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
@Table(name = "calle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calle.findAll", query = "SELECT c FROM Calle c")
    , @NamedQuery(name = "Calle.findByCodCalle", query = "SELECT c FROM Calle c WHERE c.codCalle = :codCalle")
    , @NamedQuery(name = "Calle.findByNombre", query = "SELECT c FROM Calle c WHERE c.nombre = :nombre")})
public class Calle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_calle")
    private Integer codCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "cod_ciudad")
    @ManyToOne(optional = false)
    private Ciudad codCiudad;
    @OneToMany(mappedBy = "codCalleTrans")
    private List<Direccion> direccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCalle")
    private List<Direccion> direccionList1;

    public Calle() {
    }

    public Calle(Integer codCalle) {
        this.codCalle = codCalle;
    }

    public Calle(Integer codCalle, String nombre) {
        this.codCalle = codCalle;
        this.nombre = nombre;
    }

    public Integer getCodCalle() {
        return codCalle;
    }

    public void setCodCalle(Integer codCalle) {
        this.codCalle = codCalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudad codCiudad) {
        this.codCiudad = codCiudad;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Direccion> getDireccionList1() {
        return direccionList1;
    }

    public void setDireccionList1(List<Direccion> direccionList1) {
        this.direccionList1 = direccionList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCalle != null ? codCalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calle)) {
            return false;
        }
        Calle other = (Calle) object;
        if ((this.codCalle == null && other.codCalle != null) || (this.codCalle != null && !this.codCalle.equals(other.codCalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Calle[ codCalle=" + codCalle + " ]";
    }
    
}
