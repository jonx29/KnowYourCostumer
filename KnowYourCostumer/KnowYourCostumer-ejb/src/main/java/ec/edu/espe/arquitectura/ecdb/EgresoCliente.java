/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ecdb;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "egreso_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresoCliente.findAll", query = "SELECT e FROM EgresoCliente e")
    , @NamedQuery(name = "EgresoCliente.findByCodEgresoCliente", query = "SELECT e FROM EgresoCliente e WHERE e.codEgresoCliente = :codEgresoCliente")
    , @NamedQuery(name = "EgresoCliente.findByValor", query = "SELECT e FROM EgresoCliente e WHERE e.valor = :valor")})
public class EgresoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_egreso_cliente")
    private Long codEgresoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_egreso", referencedColumnName = "cod_tipo_egreso")
    @ManyToOne(optional = false)
    private TipoEgreso codTipoEgreso;

    public EgresoCliente() {
    }

    public EgresoCliente(Long codEgresoCliente) {
        this.codEgresoCliente = codEgresoCliente;
    }

    public EgresoCliente(Long codEgresoCliente, int valor) {
        this.codEgresoCliente = codEgresoCliente;
        this.valor = valor;
    }

    public Long getCodEgresoCliente() {
        return codEgresoCliente;
    }

    public void setCodEgresoCliente(Long codEgresoCliente) {
        this.codEgresoCliente = codEgresoCliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public TipoEgreso getCodTipoEgreso() {
        return codTipoEgreso;
    }

    public void setCodTipoEgreso(TipoEgreso codTipoEgreso) {
        this.codTipoEgreso = codTipoEgreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEgresoCliente != null ? codEgresoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresoCliente)) {
            return false;
        }
        EgresoCliente other = (EgresoCliente) object;
        if ((this.codEgresoCliente == null && other.codEgresoCliente != null) || (this.codEgresoCliente != null && !this.codEgresoCliente.equals(other.codEgresoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.EgresoCliente[ codEgresoCliente=" + codEgresoCliente + " ]";
    }
    
}
