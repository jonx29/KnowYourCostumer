/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodCliente", query = "SELECT c FROM Cliente c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Cliente.findByFechaHoraRegistro", query = "SELECT c FROM Cliente c WHERE c.fechaHoraRegistro = :fechaHoraRegistro")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cliente")
    private Integer codCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinTable(name = "nacionalidad", joinColumns = {
        @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")})
    @ManyToMany
    private List<Pais> paisList;
    @JoinTable(name = "contacto", joinColumns = {
        @JoinColumn(name = "cli_cod_cliente", referencedColumnName = "cod_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")})
    @ManyToMany
    private List<Cliente> clienteList;
    @ManyToMany(mappedBy = "clienteList")
    private List<Cliente> clienteList1;
    @JoinTable(name = "actividad_economica", joinColumns = {
        @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_tipo_actividad_economica", referencedColumnName = "cod_tipo_actividad_economica")})
    @ManyToMany
    private List<TipoActividadEconomica> tipoActividadEconomicaList;
    @JoinTable(name = "profesion_cliente", joinColumns = {
        @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_profesion", referencedColumnName = "cod_profesion")})
    @ManyToMany
    private List<Profesion> profesionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<DireccionCliente> direccionClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCliente")
    private List<Cuenta> cuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<CargoPolitico> cargoPoliticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Identificacion> identificacionList;
    @JoinColumn(name = "cod_estado_civil", referencedColumnName = "cod_estado_civil")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    @JoinColumn(name = "cod_genero", referencedColumnName = "cod_genero")
    @ManyToOne
    private Genero codGenero;
    @JoinColumn(name = "pais_nacimiento", referencedColumnName = "cod_pais")
    @ManyToOne
    private Pais paisNacimiento;
    @JoinColumn(name = "cod_tipo_personeria", referencedColumnName = "cod_tipo_personeria")
    @ManyToOne(optional = false)
    private TipoPersoneria codTipoPersoneria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<IngresoCliente> ingresoClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<NumeroTelefono> numeroTelefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Parentesco> parentescoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente1")
    private List<Parentesco> parentescoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Referencia> referenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente1")
    private List<Referencia> referenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<EgresoCliente> egresoClienteList;

    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Integer codCliente, String nombres, String apellidos, Date fechaHoraRegistro) {
        this.codCliente = codCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @XmlTransient
    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Cliente> getClienteList1() {
        return clienteList1;
    }

    public void setClienteList1(List<Cliente> clienteList1) {
        this.clienteList1 = clienteList1;
    }

    @XmlTransient
    public List<TipoActividadEconomica> getTipoActividadEconomicaList() {
        return tipoActividadEconomicaList;
    }

    public void setTipoActividadEconomicaList(List<TipoActividadEconomica> tipoActividadEconomicaList) {
        this.tipoActividadEconomicaList = tipoActividadEconomicaList;
    }

    @XmlTransient
    public List<Profesion> getProfesionList() {
        return profesionList;
    }

    public void setProfesionList(List<Profesion> profesionList) {
        this.profesionList = profesionList;
    }

    @XmlTransient
    public List<DireccionCliente> getDireccionClienteList() {
        return direccionClienteList;
    }

    public void setDireccionClienteList(List<DireccionCliente> direccionClienteList) {
        this.direccionClienteList = direccionClienteList;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @XmlTransient
    public List<CargoPolitico> getCargoPoliticoList() {
        return cargoPoliticoList;
    }

    public void setCargoPoliticoList(List<CargoPolitico> cargoPoliticoList) {
        this.cargoPoliticoList = cargoPoliticoList;
    }

    @XmlTransient
    public List<Identificacion> getIdentificacionList() {
        return identificacionList;
    }

    public void setIdentificacionList(List<Identificacion> identificacionList) {
        this.identificacionList = identificacionList;
    }

    public EstadoCivil getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(EstadoCivil codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Genero getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(Genero codGenero) {
        this.codGenero = codGenero;
    }

    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public TipoPersoneria getCodTipoPersoneria() {
        return codTipoPersoneria;
    }

    public void setCodTipoPersoneria(TipoPersoneria codTipoPersoneria) {
        this.codTipoPersoneria = codTipoPersoneria;
    }

    @XmlTransient
    public List<IngresoCliente> getIngresoClienteList() {
        return ingresoClienteList;
    }

    public void setIngresoClienteList(List<IngresoCliente> ingresoClienteList) {
        this.ingresoClienteList = ingresoClienteList;
    }

    @XmlTransient
    public List<NumeroTelefono> getNumeroTelefonoList() {
        return numeroTelefonoList;
    }

    public void setNumeroTelefonoList(List<NumeroTelefono> numeroTelefonoList) {
        this.numeroTelefonoList = numeroTelefonoList;
    }

    @XmlTransient
    public List<Parentesco> getParentescoList() {
        return parentescoList;
    }

    public void setParentescoList(List<Parentesco> parentescoList) {
        this.parentescoList = parentescoList;
    }

    @XmlTransient
    public List<Parentesco> getParentescoList1() {
        return parentescoList1;
    }

    public void setParentescoList1(List<Parentesco> parentescoList1) {
        this.parentescoList1 = parentescoList1;
    }

    @XmlTransient
    public List<Referencia> getReferenciaList() {
        return referenciaList;
    }

    public void setReferenciaList(List<Referencia> referenciaList) {
        this.referenciaList = referenciaList;
    }

    @XmlTransient
    public List<Referencia> getReferenciaList1() {
        return referenciaList1;
    }

    public void setReferenciaList1(List<Referencia> referenciaList1) {
        this.referenciaList1 = referenciaList1;
    }

    @XmlTransient
    public List<EgresoCliente> getEgresoClienteList() {
        return egresoClienteList;
    }

    public void setEgresoClienteList(List<EgresoCliente> egresoClienteList) {
        this.egresoClienteList = egresoClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Cliente[ codCliente=" + codCliente + " ]";
    }
    
}
