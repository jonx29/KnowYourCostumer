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
@Table(name = "referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r")
    , @NamedQuery(name = "Referencia.findByCodCliente", query = "SELECT r FROM Referencia r WHERE r.referenciaPK.codCliente = :codCliente")
    , @NamedQuery(name = "Referencia.findByCliCodCliente", query = "SELECT r FROM Referencia r WHERE r.referenciaPK.cliCodCliente = :cliCodCliente")})
public class Referencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReferenciaPK referenciaPK;
    @JoinColumn(name = "cli_cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente1;
    @JoinColumn(name = "cod_tipo_referencia", referencedColumnName = "cod_tipo_referencia")
    @ManyToOne
    private TipoReferencia codTipoReferencia;

    public Referencia() {
    }

    public Referencia(ReferenciaPK referenciaPK) {
        this.referenciaPK = referenciaPK;
    }

    public Referencia(int codCliente, int cliCodCliente) {
        this.referenciaPK = new ReferenciaPK(codCliente, cliCodCliente);
    }

    public ReferenciaPK getReferenciaPK() {
        return referenciaPK;
    }

    public void setReferenciaPK(ReferenciaPK referenciaPK) {
        this.referenciaPK = referenciaPK;
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

    public TipoReferencia getCodTipoReferencia() {
        return codTipoReferencia;
    }

    public void setCodTipoReferencia(TipoReferencia codTipoReferencia) {
        this.codTipoReferencia = codTipoReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenciaPK != null ? referenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.referenciaPK == null && other.referenciaPK != null) || (this.referenciaPK != null && !this.referenciaPK.equals(other.referenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Referencia[ referenciaPK=" + referenciaPK + " ]";
    }
    
}
