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
public class DireccionClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_direccion")
    private int codDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;

    public DireccionClientePK() {
    }

    public DireccionClientePK(int codDireccion, int codCliente) {
        this.codDireccion = codDireccion;
        this.codCliente = codCliente;
    }

    public int getCodDireccion() {
        return codDireccion;
    }

    public void setCodDireccion(int codDireccion) {
        this.codDireccion = codDireccion;
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
        hash += (int) codDireccion;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionClientePK)) {
            return false;
        }
        DireccionClientePK other = (DireccionClientePK) object;
        if (this.codDireccion != other.codDireccion) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.DireccionClientePK[ codDireccion=" + codDireccion + ", codCliente=" + codCliente + " ]";
    }
    
}
