/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p")
    , @NamedQuery(name = "Parentesco.findByCodCliente", query = "SELECT p FROM Parentesco p WHERE p.parentescoPK.codCliente = :codCliente")
    , @NamedQuery(name = "Parentesco.findByCliCodCliente", query = "SELECT p FROM Parentesco p WHERE p.parentescoPK.cliCodCliente = :cliCodCliente")})
public class Parentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParentescoPK parentescoPK;
    @JoinColumn(name = "cli_cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente1;
    @JoinColumn(name = "cod_tipo_parentesco", referencedColumnName = "cod_tipo_parentesco")
    @ManyToOne
    private TipoParentesco codTipoParentesco;

    public Parentesco() {
    }

    public Parentesco(ParentescoPK parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public Parentesco(int codCliente, int cliCodCliente) {
        this.parentescoPK = new ParentescoPK(codCliente, cliCodCliente);
    }

    public ParentescoPK getParentescoPK() {
        return parentescoPK;
    }

    public void setParentescoPK(ParentescoPK parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public TipoParentesco getCodTipoParentesco() {
        return codTipoParentesco;
    }

    public void setCodTipoParentesco(TipoParentesco codTipoParentesco) {
        this.codTipoParentesco = codTipoParentesco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentescoPK != null ? parentescoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.parentescoPK == null && other.parentescoPK != null) || (this.parentescoPK != null && !this.parentescoPK.equals(other.parentescoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Parentesco[ parentescoPK=" + parentescoPK + " ]";
    }
    
}
