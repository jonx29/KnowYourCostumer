/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByNumeroCuenta", query = "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "Cuenta.findByActiva", query = "SELECT c FROM Cuenta c WHERE c.activa = :activa")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private boolean activa;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_cuenta", referencedColumnName = "cod_tipo_cuenta")
    @ManyToOne(optional = false)
    private TipoCuenta codTipoCuenta;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cuenta(String numeroCuenta, boolean activa) {
        this.numeroCuenta = numeroCuenta;
        this.activa = activa;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public TipoCuenta getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(TipoCuenta codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.numeroCuenta == null && other.numeroCuenta != null) || (this.numeroCuenta != null && !this.numeroCuenta.equals(other.numeroCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Cuenta[ numeroCuenta=" + numeroCuenta + " ]";
    }
    
}
