/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

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
@Table(name = "ingreso_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoCliente.findAll", query = "SELECT i FROM IngresoCliente i")
    , @NamedQuery(name = "IngresoCliente.findByCodIngresoCliente", query = "SELECT i FROM IngresoCliente i WHERE i.codIngresoCliente = :codIngresoCliente")
    , @NamedQuery(name = "IngresoCliente.findByValor", query = "SELECT i FROM IngresoCliente i WHERE i.valor = :valor")})
public class IngresoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_ingreso_cliente")
    private Long codIngresoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_ingreso", referencedColumnName = "cod_tipo_ingreso")
    @ManyToOne(optional = false)
    private TipoIngreso codTipoIngreso;

    public IngresoCliente() {
    }

    public IngresoCliente(Long codIngresoCliente) {
        this.codIngresoCliente = codIngresoCliente;
    }

    public IngresoCliente(Long codIngresoCliente, int valor) {
        this.codIngresoCliente = codIngresoCliente;
        this.valor = valor;
    }

    public Long getCodIngresoCliente() {
        return codIngresoCliente;
    }

    public void setCodIngresoCliente(Long codIngresoCliente) {
        this.codIngresoCliente = codIngresoCliente;
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

    public TipoIngreso getCodTipoIngreso() {
        return codTipoIngreso;
    }

    public void setCodTipoIngreso(TipoIngreso codTipoIngreso) {
        this.codTipoIngreso = codTipoIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIngresoCliente != null ? codIngresoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoCliente)) {
            return false;
        }
        IngresoCliente other = (IngresoCliente) object;
        if ((this.codIngresoCliente == null && other.codIngresoCliente != null) || (this.codIngresoCliente != null && !this.codIngresoCliente.equals(other.codIngresoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.IngresoCliente[ codIngresoCliente=" + codIngresoCliente + " ]";
    }
    
}
