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
@Table(name = "tipo_actividad_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividadEconomica.findAll", query = "SELECT t FROM TipoActividadEconomica t")
    , @NamedQuery(name = "TipoActividadEconomica.findByCodTipoActividadEconomica", query = "SELECT t FROM TipoActividadEconomica t WHERE t.codTipoActividadEconomica = :codTipoActividadEconomica")
    , @NamedQuery(name = "TipoActividadEconomica.findByDescripcion", query = "SELECT t FROM TipoActividadEconomica t WHERE t.descripcion = :descripcion")})
public class TipoActividadEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_actividad_economica")
    private Integer codTipoActividadEconomica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "tipoActividadEconomicaList")
    private List<Cliente> clienteList;

    public TipoActividadEconomica() {
    }

    public TipoActividadEconomica(Integer codTipoActividadEconomica) {
        this.codTipoActividadEconomica = codTipoActividadEconomica;
    }

    public TipoActividadEconomica(Integer codTipoActividadEconomica, String descripcion) {
        this.codTipoActividadEconomica = codTipoActividadEconomica;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoActividadEconomica() {
        return codTipoActividadEconomica;
    }

    public void setCodTipoActividadEconomica(Integer codTipoActividadEconomica) {
        this.codTipoActividadEconomica = codTipoActividadEconomica;
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
        hash += (codTipoActividadEconomica != null ? codTipoActividadEconomica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividadEconomica)) {
            return false;
        }
        TipoActividadEconomica other = (TipoActividadEconomica) object;
        if ((this.codTipoActividadEconomica == null && other.codTipoActividadEconomica != null) || (this.codTipoActividadEconomica != null && !this.codTipoActividadEconomica.equals(other.codTipoActividadEconomica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.TipoActividadEconomica[ codTipoActividadEconomica=" + codTipoActividadEconomica + " ]";
    }
    
}
