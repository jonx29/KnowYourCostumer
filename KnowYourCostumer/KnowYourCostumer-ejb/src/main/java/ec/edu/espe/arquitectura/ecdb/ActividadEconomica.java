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
@Table(name = "actividad_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadEconomica.findAll", query = "SELECT a FROM ActividadEconomica a")
    , @NamedQuery(name = "ActividadEconomica.findByCodActividadEconomica", query = "SELECT a FROM ActividadEconomica a WHERE a.codActividadEconomica = :codActividadEconomica")})
public class ActividadEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_actividad_economica")
    private Integer codActividadEconomica;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_actividad_economica", referencedColumnName = "cod_tipo_actividad_economica")
    @ManyToOne(optional = false)
    private TipoActividadEconomica codTipoActividadEconomica;

    public ActividadEconomica() {
    }

    public ActividadEconomica(Integer codActividadEconomica) {
        this.codActividadEconomica = codActividadEconomica;
    }

    public Integer getCodActividadEconomica() {
        return codActividadEconomica;
    }

    public void setCodActividadEconomica(Integer codActividadEconomica) {
        this.codActividadEconomica = codActividadEconomica;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public TipoActividadEconomica getCodTipoActividadEconomica() {
        return codTipoActividadEconomica;
    }

    public void setCodTipoActividadEconomica(TipoActividadEconomica codTipoActividadEconomica) {
        this.codTipoActividadEconomica = codTipoActividadEconomica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codActividadEconomica != null ? codActividadEconomica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadEconomica)) {
            return false;
        }
        ActividadEconomica other = (ActividadEconomica) object;
        if ((this.codActividadEconomica == null && other.codActividadEconomica != null) || (this.codActividadEconomica != null && !this.codActividadEconomica.equals(other.codActividadEconomica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.ActividadEconomica[ codActividadEconomica=" + codActividadEconomica + " ]";
    }
    
}
