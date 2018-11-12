/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "egreso_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresoCliente.findAll", query = "SELECT e FROM EgresoCliente e")
    , @NamedQuery(name = "EgresoCliente.findByCodTipoEgreso", query = "SELECT e FROM EgresoCliente e WHERE e.egresoClientePK.codTipoEgreso = :codTipoEgreso")
    , @NamedQuery(name = "EgresoCliente.findByCodCliente", query = "SELECT e FROM EgresoCliente e WHERE e.egresoClientePK.codCliente = :codCliente")
    , @NamedQuery(name = "EgresoCliente.findByValor", query = "SELECT e FROM EgresoCliente e WHERE e.valor = :valor")})
public class EgresoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EgresoClientePK egresoClientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_tipo_egreso", referencedColumnName = "cod_tipo_egreso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoEgreso tipoEgreso;

    public EgresoCliente() {
    }

    public EgresoCliente(EgresoClientePK egresoClientePK) {
        this.egresoClientePK = egresoClientePK;
    }

    public EgresoCliente(EgresoClientePK egresoClientePK, int valor) {
        this.egresoClientePK = egresoClientePK;
        this.valor = valor;
    }

    public EgresoCliente(int codTipoEgreso, int codCliente) {
        this.egresoClientePK = new EgresoClientePK(codTipoEgreso, codCliente);
    }

    public EgresoClientePK getEgresoClientePK() {
        return egresoClientePK;
    }

    public void setEgresoClientePK(EgresoClientePK egresoClientePK) {
        this.egresoClientePK = egresoClientePK;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEgreso getTipoEgreso() {
        return tipoEgreso;
    }

    public void setTipoEgreso(TipoEgreso tipoEgreso) {
        this.tipoEgreso = tipoEgreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (egresoClientePK != null ? egresoClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresoCliente)) {
            return false;
        }
        EgresoCliente other = (EgresoCliente) object;
        if ((this.egresoClientePK == null && other.egresoClientePK != null) || (this.egresoClientePK != null && !this.egresoClientePK.equals(other.egresoClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.EgresoCliente[ egresoClientePK=" + egresoClientePK + " ]";
    }
    
}
