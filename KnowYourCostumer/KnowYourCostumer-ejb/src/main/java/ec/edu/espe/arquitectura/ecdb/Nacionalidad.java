/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ecdb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "nacionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n")
    , @NamedQuery(name = "Nacionalidad.findByCodNacionalidad", query = "SELECT n FROM Nacionalidad n WHERE n.codNacionalidad = :codNacionalidad")})
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_nacionalidad")
    private Integer codNacionalidad;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Pais codPais;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer codNacionalidad) {
        this.codNacionalidad = codNacionalidad;
    }

    public Integer getCodNacionalidad() {
        return codNacionalidad;
    }

    public void setCodNacionalidad(Integer codNacionalidad) {
        this.codNacionalidad = codNacionalidad;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNacionalidad != null ? codNacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.codNacionalidad == null && other.codNacionalidad != null) || (this.codNacionalidad != null && !this.codNacionalidad.equals(other.codNacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.Nacionalidad[ codNacionalidad=" + codNacionalidad + " ]";
    }
    
}
