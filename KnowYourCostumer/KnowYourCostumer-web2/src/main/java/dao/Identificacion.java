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
@Table(name = "identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identificacion.findAll", query = "SELECT i FROM Identificacion i")
    , @NamedQuery(name = "Identificacion.findByCodTipoIdentificacion", query = "SELECT i FROM Identificacion i WHERE i.identificacionPK.codTipoIdentificacion = :codTipoIdentificacion")
    , @NamedQuery(name = "Identificacion.findByCodCliente", query = "SELECT i FROM Identificacion i WHERE i.identificacionPK.codCliente = :codCliente")
    , @NamedQuery(name = "Identificacion.findByCodPais", query = "SELECT i FROM Identificacion i WHERE i.identificacionPK.codPais = :codPais")
    , @NamedQuery(name = "Identificacion.findByNumeroIdentificacion", query = "SELECT i FROM Identificacion i WHERE i.numeroIdentificacion = :numeroIdentificacion")})
public class Identificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdentificacionPK identificacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_identificacion")
    private long numeroIdentificacion;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumn(name = "cod_tipo_identificacion", referencedColumnName = "cod_tipo_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoIdentificacion tipoIdentificacion;

    public Identificacion() {
    }

    public Identificacion(IdentificacionPK identificacionPK) {
        this.identificacionPK = identificacionPK;
    }

    public Identificacion(IdentificacionPK identificacionPK, long numeroIdentificacion) {
        this.identificacionPK = identificacionPK;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Identificacion(int codTipoIdentificacion, int codCliente, String codPais) {
        this.identificacionPK = new IdentificacionPK(codTipoIdentificacion, codCliente, codPais);
    }

    public IdentificacionPK getIdentificacionPK() {
        return identificacionPK;
    }

    public void setIdentificacionPK(IdentificacionPK identificacionPK) {
        this.identificacionPK = identificacionPK;
    }

    public long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionPK != null ? identificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identificacion)) {
            return false;
        }
        Identificacion other = (Identificacion) object;
        if ((this.identificacionPK == null && other.identificacionPK != null) || (this.identificacionPK != null && !this.identificacionPK.equals(other.identificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Identificacion[ identificacionPK=" + identificacionPK + " ]";
    }
    
}
