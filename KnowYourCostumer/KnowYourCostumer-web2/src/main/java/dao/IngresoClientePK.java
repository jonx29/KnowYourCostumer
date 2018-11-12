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
public class IngresoClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_ingreso")
    private int codTipoIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;

    public IngresoClientePK() {
    }

    public IngresoClientePK(int codTipoIngreso, int codCliente) {
        this.codTipoIngreso = codTipoIngreso;
        this.codCliente = codCliente;
    }

    public int getCodTipoIngreso() {
        return codTipoIngreso;
    }

    public void setCodTipoIngreso(int codTipoIngreso) {
        this.codTipoIngreso = codTipoIngreso;
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
        hash += (int) codTipoIngreso;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoClientePK)) {
            return false;
        }
        IngresoClientePK other = (IngresoClientePK) object;
        if (this.codTipoIngreso != other.codTipoIngreso) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IngresoClientePK[ codTipoIngreso=" + codTipoIngreso + ", codCliente=" + codCliente + " ]";
    }
    
}
