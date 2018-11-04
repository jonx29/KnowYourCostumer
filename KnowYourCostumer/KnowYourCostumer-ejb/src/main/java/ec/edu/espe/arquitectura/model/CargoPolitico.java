/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "cargo_politico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoPolitico.findAll", query = "SELECT c FROM CargoPolitico c")
    , @NamedQuery(name = "CargoPolitico.findByCodCargoPolitico", query = "SELECT c FROM CargoPolitico c WHERE c.codCargoPolitico = :codCargoPolitico")
    , @NamedQuery(name = "CargoPolitico.findByFechaInicio", query = "SELECT c FROM CargoPolitico c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CargoPolitico.findByFechaFin", query = "SELECT c FROM CargoPolitico c WHERE c.fechaFin = :fechaFin")})
public class CargoPolitico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cargo_politico")
    private Integer codCargoPolitico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_cargo_politico", referencedColumnName = "cod_tipo_cargo_politico")
    @ManyToOne(optional = false)
    private TipoCargoPolitico codTipoCargoPolitico;

    public CargoPolitico() {
    }

    public CargoPolitico(Integer codCargoPolitico) {
        this.codCargoPolitico = codCargoPolitico;
    }

    public CargoPolitico(Integer codCargoPolitico, Date fechaInicio, Date fechaFin) {
        this.codCargoPolitico = codCargoPolitico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getCodCargoPolitico() {
        return codCargoPolitico;
    }

    public void setCodCargoPolitico(Integer codCargoPolitico) {
        this.codCargoPolitico = codCargoPolitico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public TipoCargoPolitico getCodTipoCargoPolitico() {
        return codTipoCargoPolitico;
    }

    public void setCodTipoCargoPolitico(TipoCargoPolitico codTipoCargoPolitico) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCargoPolitico != null ? codCargoPolitico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPolitico)) {
            return false;
        }
        CargoPolitico other = (CargoPolitico) object;
        if ((this.codCargoPolitico == null && other.codCargoPolitico != null) || (this.codCargoPolitico != null && !this.codCargoPolitico.equals(other.codCargoPolitico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.CargoPolitico[ codCargoPolitico=" + codCargoPolitico + " ]";
    }
    
}
