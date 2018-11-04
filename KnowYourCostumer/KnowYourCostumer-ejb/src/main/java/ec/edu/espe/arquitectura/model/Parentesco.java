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
@Table(name = "parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p")
    , @NamedQuery(name = "Parentesco.findByCodParentesco", query = "SELECT p FROM Parentesco p WHERE p.codParentesco = :codParentesco")})
public class Parentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_parentesco")
    private Integer codParentesco;
    @JoinColumn(name = "cli_cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente cliCodCliente;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_tipo_parentesco", referencedColumnName = "cod_tipo_parentesco")
    @ManyToOne(optional = false)
    private TipoParentesco codTipoParentesco;

    public Parentesco() {
    }

    public Parentesco(Integer codParentesco) {
        this.codParentesco = codParentesco;
    }

    public Integer getCodParentesco() {
        return codParentesco;
    }

    public void setCodParentesco(Integer codParentesco) {
        this.codParentesco = codParentesco;
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

    public TipoParentesco getCodTipoParentesco() {
        return codTipoParentesco;
    }

    public void setCodTipoParentesco(TipoParentesco codTipoParentesco) {
        this.codTipoParentesco = codTipoParentesco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParentesco != null ? codParentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.codParentesco == null && other.codParentesco != null) || (this.codParentesco != null && !this.codParentesco.equals(other.codParentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.Parentesco[ codParentesco=" + codParentesco + " ]";
    }
    
}
