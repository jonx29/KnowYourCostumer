/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class IdentificacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_identificacion")
    private int codTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_pais")
    private String codPais;

    public IdentificacionPK() {
    }

    public IdentificacionPK(int codTipoIdentificacion, int codCliente, String codPais) {
        this.codTipoIdentificacion = codTipoIdentificacion;
        this.codCliente = codCliente;
        this.codPais = codPais;
    }

    public int getCodTipoIdentificacion() {
        return codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(int codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codTipoIdentificacion;
        hash += (int) codCliente;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificacionPK)) {
            return false;
        }
        IdentificacionPK other = (IdentificacionPK) object;
        if (this.codTipoIdentificacion != other.codTipoIdentificacion) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IdentificacionPK[ codTipoIdentificacion=" + codTipoIdentificacion + ", codCliente=" + codCliente + ", codPais=" + codPais + " ]";
    }
    
}
