/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "direccion_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionCliente.findAll", query = "SELECT d FROM DireccionCliente d")
    , @NamedQuery(name = "DireccionCliente.findByCodDireccion", query = "SELECT d FROM DireccionCliente d WHERE d.direccionClientePK.codDireccion = :codDireccion")
    , @NamedQuery(name = "DireccionCliente.findByCodCliente", query = "SELECT d FROM DireccionCliente d WHERE d.direccionClientePK.codCliente = :codCliente")
    , @NamedQuery(name = "DireccionCliente.findByReferencia", query = "SELECT d FROM DireccionCliente d WHERE d.referencia = :referencia")})
public class DireccionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionClientePK direccionClientePK;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_direccion", referencedColumnName = "cod_direccion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Direccion direccion;

    public DireccionCliente() {
    }

    public DireccionCliente(DireccionClientePK direccionClientePK) {
        this.direccionClientePK = direccionClientePK;
    }

    public DireccionCliente(int codDireccion, int codCliente) {
        this.direccionClientePK = new DireccionClientePK(codDireccion, codCliente);
    }

    public DireccionClientePK getDireccionClientePK() {
        return direccionClientePK;
    }

    public void setDireccionClientePK(DireccionClientePK direccionClientePK) {
        this.direccionClientePK = direccionClientePK;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionClientePK != null ? direccionClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionCliente)) {
            return false;
        }
        DireccionCliente other = (DireccionCliente) object;
        if ((this.direccionClientePK == null && other.direccionClientePK != null) || (this.direccionClientePK != null && !this.direccionClientePK.equals(other.direccionClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.DireccionCliente[ direccionClientePK=" + direccionClientePK + " ]";
    }
    
}
