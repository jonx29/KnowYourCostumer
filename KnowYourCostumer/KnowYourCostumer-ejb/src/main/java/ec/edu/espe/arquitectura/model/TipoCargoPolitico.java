/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author USUARIO
 */
@Entity
@Table(name = "tipo_cargo_politico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargoPolitico.findAll", query = "SELECT t FROM TipoCargoPolitico t")
    , @NamedQuery(name = "TipoCargoPolitico.findByCodTipoCargoPolitico", query = "SELECT t FROM TipoCargoPolitico t WHERE t.codTipoCargoPolitico = :codTipoCargoPolitico")
    , @NamedQuery(name = "TipoCargoPolitico.findByDescripcion", query = "SELECT t FROM TipoCargoPolitico t WHERE t.descripcion = :descripcion")})
public class TipoCargoPolitico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_cargo_politico")
    private Short codTipoCargoPolitico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoCargoPolitico")
    private List<CargoPolitico> cargoPoliticoList;

    public TipoCargoPolitico() {
    }

    public TipoCargoPolitico(Short codTipoCargoPolitico) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
    }

    public TipoCargoPolitico(Short codTipoCargoPolitico, String descripcion) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
        this.descripcion = descripcion;
    }

    public Short getCodTipoCargoPolitico() {
        return codTipoCargoPolitico;
    }

    public void setCodTipoCargoPolitico(Short codTipoCargoPolitico) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CargoPolitico> getCargoPoliticoList() {
        return cargoPoliticoList;
    }

    public void setCargoPoliticoList(List<CargoPolitico> cargoPoliticoList) {
        this.cargoPoliticoList = cargoPoliticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoCargoPolitico != null ? codTipoCargoPolitico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargoPolitico)) {
            return false;
        }
        TipoCargoPolitico other = (TipoCargoPolitico) object;
        if ((this.codTipoCargoPolitico == null && other.codTipoCargoPolitico != null) || (this.codTipoCargoPolitico != null && !this.codTipoCargoPolitico.equals(other.codTipoCargoPolitico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.TipoCargoPolitico[ codTipoCargoPolitico=" + codTipoCargoPolitico + " ]";
    }
    
}
