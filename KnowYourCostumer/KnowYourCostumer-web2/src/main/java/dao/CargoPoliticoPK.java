/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
public class CargoPoliticoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_cargo_politico")
    private int codTipoCargoPolitico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_ciudad")
    private int codCiudad;
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

    public CargoPoliticoPK() {
    }

    public CargoPoliticoPK(int codTipoCargoPolitico, int codCliente, int codCiudad, Date fechaInicio, Date fechaFin) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
        this.codCliente = codCliente;
        this.codCiudad = codCiudad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getCodTipoCargoPolitico() {
        return codTipoCargoPolitico;
    }

    public void setCodTipoCargoPolitico(int codTipoCargoPolitico) {
        this.codTipoCargoPolitico = codTipoCargoPolitico;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codTipoCargoPolitico;
        hash += (int) codCliente;
        hash += (int) codCiudad;
        hash += (fechaInicio != null ? fechaInicio.hashCode() : 0);
        hash += (fechaFin != null ? fechaFin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPoliticoPK)) {
            return false;
        }
        CargoPoliticoPK other = (CargoPoliticoPK) object;
        if (this.codTipoCargoPolitico != other.codTipoCargoPolitico) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        if ((this.fechaInicio == null && other.fechaInicio != null) || (this.fechaInicio != null && !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        if ((this.fechaFin == null && other.fechaFin != null) || (this.fechaFin != null && !this.fechaFin.equals(other.fechaFin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.CargoPoliticoPK[ codTipoCargoPolitico=" + codTipoCargoPolitico + ", codCliente=" + codCliente + ", codCiudad=" + codCiudad + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + " ]";
    }
    
}
