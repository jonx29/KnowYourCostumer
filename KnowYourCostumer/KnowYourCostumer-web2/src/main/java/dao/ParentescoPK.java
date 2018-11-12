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
public class ParentescoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private int codCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_cod_cliente")
    private int cliCodCliente;

    public ParentescoPK() {
    }

    public ParentescoPK(int codCliente, int cliCodCliente) {
        this.codCliente = codCliente;
        this.cliCodCliente = cliCodCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCliCodCliente() {
        return cliCodCliente;
    }

    public void setCliCodCliente(int cliCodCliente) {
        this.cliCodCliente = cliCodCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCliente;
        hash += (int) cliCodCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentescoPK)) {
            return false;
        }
        ParentescoPK other = (ParentescoPK) object;
        if (this.codCliente != other.codCliente) {
            return false;
        }
        if (this.cliCodCliente != other.cliCodCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ParentescoPK[ codCliente=" + codCliente + ", cliCodCliente=" + cliCodCliente + " ]";
    }
    
}
