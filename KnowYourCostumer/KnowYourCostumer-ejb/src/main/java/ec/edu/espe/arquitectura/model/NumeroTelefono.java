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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "numero_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroTelefono.findAll", query = "SELECT n FROM NumeroTelefono n")
    , @NamedQuery(name = "NumeroTelefono.findByCodNumeroTelefono", query = "SELECT n FROM NumeroTelefono n WHERE n.codNumeroTelefono = :codNumeroTelefono")
    , @NamedQuery(name = "NumeroTelefono.findByNumero", query = "SELECT n FROM NumeroTelefono n WHERE n.numero = :numero")})
public class NumeroTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_numero_telefono")
    private Long codNumeroTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_telefono", referencedColumnName = "cod_tipo_telefono")
    @ManyToOne(optional = false)
    private TipoTelefono codTipoTelefono;

    public NumeroTelefono() {
    }

    public NumeroTelefono(Long codNumeroTelefono) {
        this.codNumeroTelefono = codNumeroTelefono;
    }

    public NumeroTelefono(Long codNumeroTelefono, String numero) {
        this.codNumeroTelefono = codNumeroTelefono;
        this.numero = numero;
    }

    public Long getCodNumeroTelefono() {
        return codNumeroTelefono;
    }

    public void setCodNumeroTelefono(Long codNumeroTelefono) {
        this.codNumeroTelefono = codNumeroTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
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
        hash += (codNumeroTelefono != null ? codNumeroTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroTelefono)) {
            return false;
        }
        NumeroTelefono other = (NumeroTelefono) object;
        if ((this.codNumeroTelefono == null && other.codNumeroTelefono != null) || (this.codNumeroTelefono != null && !this.codNumeroTelefono.equals(other.codNumeroTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.NumeroTelefono[ codNumeroTelefono=" + codNumeroTelefono + " ]";
    }
    
}
