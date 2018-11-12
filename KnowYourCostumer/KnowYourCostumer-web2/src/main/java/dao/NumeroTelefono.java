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
@Table(name = "numero_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroTelefono.findAll", query = "SELECT n FROM NumeroTelefono n")
    , @NamedQuery(name = "NumeroTelefono.findByCodCliente", query = "SELECT n FROM NumeroTelefono n WHERE n.numeroTelefonoPK.codCliente = :codCliente")
    , @NamedQuery(name = "NumeroTelefono.findByNumero", query = "SELECT n FROM NumeroTelefono n WHERE n.numeroTelefonoPK.numero = :numero")})
public class NumeroTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumeroTelefonoPK numeroTelefonoPK;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_tipo_telefono", referencedColumnName = "cod_tipo_telefono")
    @ManyToOne(optional = false)
    private TipoTelefono codTipoTelefono;

    public NumeroTelefono() {
    }

    public NumeroTelefono(NumeroTelefonoPK numeroTelefonoPK) {
        this.numeroTelefonoPK = numeroTelefonoPK;
    }

    public NumeroTelefono(int codCliente, String numero) {
        this.numeroTelefonoPK = new NumeroTelefonoPK(codCliente, numero);
    }

    public NumeroTelefonoPK getNumeroTelefonoPK() {
        return numeroTelefonoPK;
    }

    public void setNumeroTelefonoPK(NumeroTelefonoPK numeroTelefonoPK) {
        this.numeroTelefonoPK = numeroTelefonoPK;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoTelefono getCodTipoTelefono() {
        return codTipoTelefono;
    }

    public void setCodTipoTelefono(TipoTelefono codTipoTelefono) {
        this.codTipoTelefono = codTipoTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroTelefonoPK != null ? numeroTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroTelefono)) {
            return false;
        }
        NumeroTelefono other = (NumeroTelefono) object;
        if ((this.numeroTelefonoPK == null && other.numeroTelefonoPK != null) || (this.numeroTelefonoPK != null && !this.numeroTelefonoPK.equals(other.numeroTelefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.NumeroTelefono[ numeroTelefonoPK=" + numeroTelefonoPK + " ]";
    }
    
}
