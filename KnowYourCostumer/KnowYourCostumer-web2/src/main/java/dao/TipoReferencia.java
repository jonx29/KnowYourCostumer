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
@Table(name = "tipo_referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReferencia.findAll", query = "SELECT t FROM TipoReferencia t")
    , @NamedQuery(name = "TipoReferencia.findByCodTipoReferencia", query = "SELECT t FROM TipoReferencia t WHERE t.codTipoReferencia = :codTipoReferencia")
    , @NamedQuery(name = "TipoReferencia.findByDescripcion", query = "SELECT t FROM TipoReferencia t WHERE t.descripcion = :descripcion")})
public class TipoReferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_referencia")
    private Integer codTipoReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codTipoReferencia")
    private List<Referencia> referenciaList;

    public TipoReferencia() {
    }

    public TipoReferencia(Integer codTipoReferencia) {
        this.codTipoReferencia = codTipoReferencia;
    }

    public TipoReferencia(Integer codTipoReferencia, String descripcion) {
        this.codTipoReferencia = codTipoReferencia;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoReferencia() {
        return codTipoReferencia;
    }

    public void setCodTipoReferencia(Integer codTipoReferencia) {
        this.codTipoReferencia = codTipoReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Referencia> getReferenciaList() {
        return referenciaList;
    }

    public void setReferenciaList(List<Referencia> referenciaList) {
        this.referenciaList = referenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoReferencia != null ? codTipoReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReferencia)) {
            return false;
        }
        TipoReferencia other = (TipoReferencia) object;
        if ((this.codTipoReferencia == null && other.codTipoReferencia != null) || (this.codTipoReferencia != null && !this.codTipoReferencia.equals(other.codTipoReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.TipoReferencia[ codTipoReferencia=" + codTipoReferencia + " ]";
    }
    
}
