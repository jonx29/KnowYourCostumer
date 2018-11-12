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
@Table(name = "ingreso_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoCliente.findAll", query = "SELECT i FROM IngresoCliente i")
    , @NamedQuery(name = "IngresoCliente.findByCodTipoIngreso", query = "SELECT i FROM IngresoCliente i WHERE i.ingresoClientePK.codTipoIngreso = :codTipoIngreso")
    , @NamedQuery(name = "IngresoCliente.findByCodCliente", query = "SELECT i FROM IngresoCliente i WHERE i.ingresoClientePK.codCliente = :codCliente")
    , @NamedQuery(name = "IngresoCliente.findByValor", query = "SELECT i FROM IngresoCliente i WHERE i.valor = :valor")})
public class IngresoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresoClientePK ingresoClientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_tipo_ingreso", referencedColumnName = "cod_tipo_ingreso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoIngreso tipoIngreso;

    public IngresoCliente() {
    }

    public IngresoCliente(IngresoClientePK ingresoClientePK) {
        this.ingresoClientePK = ingresoClientePK;
    }

    public IngresoCliente(IngresoClientePK ingresoClientePK, int valor) {
        this.ingresoClientePK = ingresoClientePK;
        this.valor = valor;
    }

    public IngresoCliente(int codTipoIngreso, int codCliente) {
        this.ingresoClientePK = new IngresoClientePK(codTipoIngreso, codCliente);
    }

    public IngresoClientePK getIngresoClientePK() {
        return ingresoClientePK;
    }

    public void setIngresoClientePK(IngresoClientePK ingresoClientePK) {
        this.ingresoClientePK = ingresoClientePK;
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

    public TipoIngreso getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngreso tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingresoClientePK != null ? ingresoClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoCliente)) {
            return false;
        }
        IngresoCliente other = (IngresoCliente) object;
        if ((this.ingresoClientePK == null && other.ingresoClientePK != null) || (this.ingresoClientePK != null && !this.ingresoClientePK.equals(other.ingresoClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IngresoCliente[ ingresoClientePK=" + ingresoClientePK + " ]";
    }
    
}
