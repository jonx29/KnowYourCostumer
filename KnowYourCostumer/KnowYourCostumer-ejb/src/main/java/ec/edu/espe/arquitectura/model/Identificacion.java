/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

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
@Table(name = "identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identificacion.findAll", query = "SELECT i FROM Identificacion i")
    , @NamedQuery(name = "Identificacion.findByCodIdentificacion", query = "SELECT i FROM Identificacion i WHERE i.codIdentificacion = :codIdentificacion")
    , @NamedQuery(name = "Identificacion.findByNumeroIdentificacion", query = "SELECT i FROM Identificacion i WHERE i.numeroIdentificacion = :numeroIdentificacion")})
public class Identificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_identificacion")
    private Integer codIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_identificacion")
    private long numeroIdentificacion;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Pais codPais;
    @JoinColumn(name = "cod_tipo_identificacion", referencedColumnName = "cod_tipo_identificacion")
    @ManyToOne(optional = false)
    private TipoIdentificacion codTipoIdentificacion;

    public Identificacion() {
    }

    public Identificacion(Integer codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public Identificacion(Integer codIdentificacion, long numeroIdentificacion) {
        this.codIdentificacion = codIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Integer getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(Integer codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
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

    public TipoIdentificacion getCodTipoIdentificacion() {
        return codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(TipoIdentificacion codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdentificacion != null ? codIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identificacion)) {
            return false;
        }
        Identificacion other = (Identificacion) object;
        if ((this.codIdentificacion == null && other.codIdentificacion != null) || (this.codIdentificacion != null && !this.codIdentificacion.equals(other.codIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.Identificacion[ codIdentificacion=" + codIdentificacion + " ]";
    }
    
}
