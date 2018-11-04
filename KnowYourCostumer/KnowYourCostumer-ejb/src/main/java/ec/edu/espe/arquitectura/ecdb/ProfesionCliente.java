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
@Table(name = "profesion_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesionCliente.findAll", query = "SELECT p FROM ProfesionCliente p")
    , @NamedQuery(name = "ProfesionCliente.findByCodProfesionCliente", query = "SELECT p FROM ProfesionCliente p WHERE p.codProfesionCliente = :codProfesionCliente")})
public class ProfesionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_profesion_cliente")
    private Integer codProfesionCliente;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_profesion", referencedColumnName = "cod_profesion")
    @ManyToOne(optional = false)
    private Profesion codProfesion;

    public ProfesionCliente() {
    }

    public ProfesionCliente(Integer codProfesionCliente) {
        this.codProfesionCliente = codProfesionCliente;
    }

    public Integer getCodProfesionCliente() {
        return codProfesionCliente;
    }

    public void setCodProfesionCliente(Integer codProfesionCliente) {
        this.codProfesionCliente = codProfesionCliente;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Profesion getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(Profesion codProfesion) {
        this.codProfesion = codProfesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProfesionCliente != null ? codProfesionCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionCliente)) {
            return false;
        }
        ProfesionCliente other = (ProfesionCliente) object;
        if ((this.codProfesionCliente == null && other.codProfesionCliente != null) || (this.codProfesionCliente != null && !this.codProfesionCliente.equals(other.codProfesionCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.ecdb.ProfesionCliente[ codProfesionCliente=" + codProfesionCliente + " ]";
    }
    
}
