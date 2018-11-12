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

/**
 *
 * @author user
 */
@Embeddable
public class EgresoClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_egreso")
    private int codTipoEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;

    public EgresoClientePK() {
    }

    public EgresoClientePK(int codTipoEgreso, int codCliente) {
        this.codTipoEgreso = codTipoEgreso;
        this.codCliente = codCliente;
    }

    public int getCodTipoEgreso() {
        return codTipoEgreso;
    }

    public void setCodTipoEgreso(int codTipoEgreso) {
        this.codTipoEgreso = codTipoEgreso;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codTipoEgreso;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresoClientePK)) {
            return false;
        }
        EgresoClientePK other = (EgresoClientePK) object;
        if (this.codTipoEgreso != other.codTipoEgreso) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.EgresoClientePK[ codTipoEgreso=" + codTipoEgreso + ", codCliente=" + codCliente + " ]";
    }
    
}
