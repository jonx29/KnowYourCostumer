/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cargo_politico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoPolitico.findAll", query = "SELECT c FROM CargoPolitico c")
    , @NamedQuery(name = "CargoPolitico.findByCodTipoCargoPolitico", query = "SELECT c FROM CargoPolitico c WHERE c.cargoPoliticoPK.codTipoCargoPolitico = :codTipoCargoPolitico")
    , @NamedQuery(name = "CargoPolitico.findByCodCliente", query = "SELECT c FROM CargoPolitico c WHERE c.cargoPoliticoPK.codCliente = :codCliente")
    , @NamedQuery(name = "CargoPolitico.findByCodCiudad", query = "SELECT c FROM CargoPolitico c WHERE c.cargoPoliticoPK.codCiudad = :codCiudad")
    , @NamedQuery(name = "CargoPolitico.findByFechaInicio", query = "SELECT c FROM CargoPolitico c WHERE c.cargoPoliticoPK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CargoPolitico.findByFechaFin", query = "SELECT c FROM CargoPolitico c WHERE c.cargoPoliticoPK.fechaFin = :fechaFin")})
public class CargoPolitico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargoPoliticoPK cargoPoliticoPK;
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "cod_ciudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_tipo_cargo_politico", referencedColumnName = "cod_tipo_cargo_politico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoCargoPolitico tipoCargoPolitico;

    public CargoPolitico() {
    }

    public CargoPolitico(CargoPoliticoPK cargoPoliticoPK) {
        this.cargoPoliticoPK = cargoPoliticoPK;
    }

    public CargoPolitico(int codTipoCargoPolitico, int codCliente, int codCiudad, Date fechaInicio, Date fechaFin) {
        this.cargoPoliticoPK = new CargoPoliticoPK(codTipoCargoPolitico, codCliente, codCiudad, fechaInicio, fechaFin);
    }

    public CargoPoliticoPK getCargoPoliticoPK() {
        return cargoPoliticoPK;
    }

    public void setCargoPoliticoPK(CargoPoliticoPK cargoPoliticoPK) {
        this.cargoPoliticoPK = cargoPoliticoPK;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCargoPolitico getTipoCargoPolitico() {
        return tipoCargoPolitico;
    }

    public void setTipoCargoPolitico(TipoCargoPolitico tipoCargoPolitico) {
        this.tipoCargoPolitico = tipoCargoPolitico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoPoliticoPK != null ? cargoPoliticoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPolitico)) {
            return false;
        }
        CargoPolitico other = (CargoPolitico) object;
        if ((this.cargoPoliticoPK == null && other.cargoPoliticoPK != null) || (this.cargoPoliticoPK != null && !this.cargoPoliticoPK.equals(other.cargoPoliticoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.CargoPolitico[ cargoPoliticoPK=" + cargoPoliticoPK + " ]";
    }
    
}
