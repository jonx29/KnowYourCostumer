/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import ec.edu.espe.arquitectura.model.ActividadEconomica;
import ec.edu.espe.arquitectura.model.CargoPolitico;
import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.model.EgresoCliente;
import ec.edu.espe.arquitectura.model.Identificacion;
import ec.edu.espe.arquitectura.model.IngresoCliente;
import ec.edu.espe.arquitectura.model.NumeroTelefono;
import ec.edu.espe.arquitectura.model.Parentesco;
import ec.edu.espe.arquitectura.model.Profesion;
import ec.edu.espe.arquitectura.model.ProfesionCliente;
import ec.edu.espe.arquitectura.model.Referencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.espe.arquitectura.service.crudService;
import java.sql.Time;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author User
 */
@ManagedBean()
@SessionScoped
public class BeanClientesBusqueda {
    //@EJB
    // Bean_loginLocal bean_login;

    @Inject
    crudService bean_cliente;
    private Cliente objCliente;
    public String mensaje;

    //Datos Personales
    public String cedula;
    public String apellidos;
    public String nombres;
    public Date fecha_ingreso;
    public Date fecha_nace;
    public String profecion;
    public String Genero;
    public String pais;
    public String ciudadania;
    public String estadoCivil;
    public Time hora;

    //Direccion de Residencia
    public String paisResidencia;
    public String provinciaResidencia;
    public String ciudadResidencia;
    public String callePrincipal;
    public int numCasa;
    public String calleSecundaria;
    public String referencia;
    public int celular;
    public int domicilio;

    //Referencias
    public String tipoReferencia;
    public String cedulaReferencia;
    public String apellidosReferencia;
    public String nombresReferencia;
    public String GeneroReferencia;
    public String paisReferencia;
    public String ciudadaniaReferencia;
    public String estadoCivilReferencia;

    //Parentesco con empleados    
    public String apellidosEmpleados;
    public String nombresEmpleados;
    public Date fechaEmpleado;
    public String paisEmpleado;

    //Datos Economicos
    public String actividadEconomica;
    public int ingresos;
    public int egresos;

    //Actividad Politica
    public String cargoPolitico;
    public Date fechaInicio;
    public Date fechaFin;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_nace() {
        return fecha_nace;
    }

    public void setFecha_nace(Date fecha_nace) {
        this.fecha_nace = fecha_nace;
    }

    public BeanClientesBusqueda() {
        objCliente = new Cliente();
    }

    /**
     * @return the objUsuario
     */
    public Cliente getObjCliente() {
        return objCliente;
    }

    /**
     * @param objCliente the objUsuario to set
     */
    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudadania() {
        return ciudadania;
    }

    public void setCiudadania(String ciudadania) {
        this.ciudadania = ciudadania;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getProvinciaResidencia() {
        return provinciaResidencia;
    }

    public void setProvinciaResidencia(String provinciaResidencia) {
        this.provinciaResidencia = provinciaResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    public String getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public String getCedulaReferencia() {
        return cedulaReferencia;
    }

    public void setCedulaReferencia(String cedulaReferencia) {
        this.cedulaReferencia = cedulaReferencia;
    }

    public String getApellidosReferencia() {
        return apellidosReferencia;
    }

    public void setApellidosReferencia(String apellidosReferencia) {
        this.apellidosReferencia = apellidosReferencia;
    }

    public String getNombresReferencia() {
        return nombresReferencia;
    }

    public void setNombresReferencia(String nombresReferencia) {
        this.nombresReferencia = nombresReferencia;
    }

    public String getGeneroReferencia() {
        return GeneroReferencia;
    }

    public void setGeneroReferencia(String GeneroReferencia) {
        this.GeneroReferencia = GeneroReferencia;
    }

    public String getPaisReferencia() {
        return paisReferencia;
    }

    public void setPaisReferencia(String paisReferencia) {
        this.paisReferencia = paisReferencia;
    }

    public String getCiudadaniaReferencia() {
        return ciudadaniaReferencia;
    }

    public void setCiudadaniaReferencia(String ciudadaniaReferencia) {
        this.ciudadaniaReferencia = ciudadaniaReferencia;
    }

    public String getEstadoCivilReferencia() {
        return estadoCivilReferencia;
    }

    public void setEstadoCivilReferencia(String estadoCivilReferencia) {
        this.estadoCivilReferencia = estadoCivilReferencia;
    }

    public String getApellidosEmpleados() {
        return apellidosEmpleados;
    }

    public void setApellidosEmpleados(String apellidosEmpleados) {
        this.apellidosEmpleados = apellidosEmpleados;
    }

    public String getNombresEmpleados() {
        return nombresEmpleados;
    }

    public void setNombresEmpleados(String nombresEmpleados) {
        this.nombresEmpleados = nombresEmpleados;
    }

    public Date getFechaEmpleado() {
        return fechaEmpleado;
    }

    public void setFechaEmpleado(Date fechaEmpleado) {
        this.fechaEmpleado = fechaEmpleado;
    }

    public String getPaisEmpleado() {
        return paisEmpleado;
    }

    public void setPaisEmpleado(String paisEmpleado) {
        this.paisEmpleado = paisEmpleado;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public String getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(String cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    private Cliente cliente;
    private Identificacion identificacion;
    private Profesion profesion;// otra profesion
    private ProfesionCliente profesionCliente;
    private NumeroTelefono numeroTelefono;
    private Referencia referenciaCliente;
    private CargoPolitico cargoPoliticoCliente;
    private ActividadEconomica actividadEconomicaCliente;
    private EgresoCliente egresoCliente;
    private IngresoCliente ingresoCliente;
    private Parentesco parentescoCliente;

    public String Busqueda(Integer cod) {
        String path;
        System.out.println("este codigo toma" + cod);
        
        setCliente(bean_cliente.buscarCliente(cod));
        setIdentificacion(bean_cliente.buscarClienteIndentificacion(cliente));
        setProfesionCliente(bean_cliente.buscarClienteProfesion(cliente));
        setNumeroTelefono(bean_cliente.buscarClienteTelefono(cliente));
        setReferenciaCliente(bean_cliente.buscarClienteReferencia(cliente));
        setCargoPoliticoCliente(bean_cliente.buscarClientePolitico(cliente));
        setActividadEconomicaCliente(bean_cliente.buscarClienteActividadEconomica(cliente));
        setEgresoCliente(bean_cliente.buscarClienteEgreso(cliente));
        setIngresoCliente(bean_cliente.buscarClienteIngreso(cliente));
        setParentescoCliente(bean_cliente.buscarParentesco(cliente));

        return path = "/verCliente?faces-redirect=true";

    }
    public String Busqueda2(Integer cod) {

        setCliente(bean_cliente.buscarCliente(cod));
        setIdentificacion(bean_cliente.buscarClienteIndentificacion(cliente));
        setProfesionCliente(bean_cliente.buscarClienteProfesion(cliente));
        setNumeroTelefono(bean_cliente.buscarClienteTelefono(cliente));
        setReferenciaCliente(bean_cliente.buscarClienteReferencia(cliente));
        setCargoPoliticoCliente(bean_cliente.buscarClientePolitico(cliente));
        setActividadEconomicaCliente(bean_cliente.buscarClienteActividadEconomica(cliente));
        setEgresoCliente(bean_cliente.buscarClienteEgreso(cliente));
        setIngresoCliente(bean_cliente.buscarClienteIngreso(cliente));
        setParentescoCliente(bean_cliente.buscarParentesco(cliente));
        
        System.out.println("CODIGO A MODIFICAR: " + cod);
        return "/modificar2?faces-redirect=true";
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the identificacion
     */
    public Identificacion getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the profesionCliente
     */
    public ProfesionCliente getProfesionCliente() {
        return profesionCliente;
    }

    /**
     * @param profesionCliente the profesionCliente to set
     */
    public void setProfesionCliente(ProfesionCliente profesionCliente) {
        this.profesionCliente = profesionCliente;
    }

    /**
     * @return the numeroTelefono
     */
    public NumeroTelefono getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(NumeroTelefono numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return the referenciaCliente
     */
    public Referencia getReferenciaCliente() {
        return referenciaCliente;
    }

    /**
     * @param referenciaCliente the referenciaCliente to set
     */
    public void setReferenciaCliente(Referencia referenciaCliente) {
        this.referenciaCliente = referenciaCliente;
    }

    /**
     * @return the cargoPoliticoCliente
     */
    public CargoPolitico getCargoPoliticoCliente() {
        return cargoPoliticoCliente;
}

    /**
     * @param cargoPoliticoCliente the cargoPoliticoCliente to set
     */
    public void setCargoPoliticoCliente(CargoPolitico cargoPoliticoCliente) {
        this.cargoPoliticoCliente = cargoPoliticoCliente;
    }

    /**
     * @return the actividadEconomicaCliente
     */
    public ActividadEconomica getActividadEconomicaCliente() {
        return actividadEconomicaCliente;
    }

    /**
     * @param actividadEconomicaCliente the actividadEconomicaCliente to set
     */
    public void setActividadEconomicaCliente(ActividadEconomica actividadEconomicaCliente) {
        this.actividadEconomicaCliente = actividadEconomicaCliente;
    }

    /**
     * @return the egresoCliente
     */
    public EgresoCliente getEgresoCliente() {
        return egresoCliente;
    }

    /**
     * @param egresoCliente the egresoCliente to set
     */
    public void setEgresoCliente(EgresoCliente egresoCliente) {
        this.egresoCliente = egresoCliente;
    }

    /**
     * @return the ingresoCliente
     */
    public IngresoCliente getIngresoCliente() {
        return ingresoCliente;
    }

    /**
     * @param ingresoCliente the ingresoCliente to set
     */
    public void setIngresoCliente(IngresoCliente ingresoCliente) {
        this.ingresoCliente = ingresoCliente;
    }

    /**
     * @return the parentescoCliente
     */
    public Parentesco getParentescoCliente() {
        return parentescoCliente;
    }

    /**
     * @param parentescoCliente the parentescoCliente to set
     */
    public void setParentescoCliente(Parentesco parentescoCliente) {
        this.parentescoCliente = parentescoCliente;
    }

}
