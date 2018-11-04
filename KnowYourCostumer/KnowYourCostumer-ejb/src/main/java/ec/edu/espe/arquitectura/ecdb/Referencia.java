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
@Table(name = "referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r")
    , @NamedQuery(name = "Referencia.findByCodReferencia", query = "SELECT r FROM Referencia r WHERE r.codReferencia = :codReferencia")})
public class Referencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_referencia")
    private Long codReferencia;
    @JoinColumn(name = "cli_cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente cliCodCliente;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_referencia", referencedColumnName = "cod_tipo_referencia")
    @ManyToOne(optional = false)
    private TipoReferencia codTipoReferencia;

    public Referencia() {
    }

    public Referencia(Long codReferencia) {
        this.codReferencia = codReferencia;
    }

    public Long getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(Long codReferencia) {
        this.codReferencia = codReferencia;
    }

    public Cliente getCliCodCliente() {
        return cliCodCliente;
    }

    public void setCliCodCliente(Cliente cliCodCliente) {
        this.cliCodCliente = cliCodCliente;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
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
        hash += (codReferencia != null ? codReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.codReferencia == null && other.codReferencia != null) || (this.codReferencia != null && !this.codReferencia.equals(other.codReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.Referencia[ codReferencia=" + codReferencia + " ]";
    }
    
}
