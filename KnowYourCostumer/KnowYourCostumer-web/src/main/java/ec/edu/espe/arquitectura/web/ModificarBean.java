/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.model.EstadoCivil;
import ec.edu.espe.arquitectura.model.Genero;
import ec.edu.espe.arquitectura.model.Pais;
import ec.edu.espe.arquitectura.model.Profesion;
import ec.edu.espe.arquitectura.model.TipoIdentificacion;
import ec.edu.espe.arquitectura.service.CrudService;
import ec.edu.espe.arquitectura.service.EstadoCivilService;
import ec.edu.espe.arquitectura.service.GeneroService;
import ec.edu.espe.arquitectura.service.PaisService;
import ec.edu.espe.arquitectura.service.ProfesionService;
import ec.edu.espe.arquitectura.service.TipoIdentificacionService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */

@ManagedBean()
@ViewScoped
public class ModificarBean {
    
    @Inject
    private CrudService CS;
    @Inject
    private TipoIdentificacionService tipoIdentificacionService;
    @Inject
    private GeneroService generoService;
    @Inject
    private ProfesionService profesionService;
    @Inject
    private PaisService paisService;
    @Inject
    private EstadoCivilService estadoCivilService;
    
    private List<Cliente> clientes;
    private List<TipoIdentificacion> tiposIdentificacion;
    private List<Genero> generoList;
    private List<Profesion> profesionList;
    private List<Pais> paisList;
    private List<EstadoCivil> estadoCivilList;

    public List<EstadoCivil> getEstadoCivilList() {
        return estadoCivilList;
    }

    public void setEstadoCivilList(List<EstadoCivil> estadoCivilList) {
        this.estadoCivilList = estadoCivilList;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Profesion> getProfesionList() {
        return profesionList;
    }

    public void setProfesionList(List<Profesion> profesionList) {
        this.profesionList = profesionList;
    }

    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }

    @PostConstruct
    public void init() {
        this.clientes = this.CS.getClienteFacade().findAll();
        this.tiposIdentificacion = tipoIdentificacionService.getTipoIdentificacionFacade().findAll();
        this.generoList = generoService.getGeneroFacade().findAll();
        this.profesionList = profesionService.getProfesionFacade().findAll();
        this.paisList = paisService.getPaisFacade().findAll();
        this.estadoCivilList = estadoCivilService.getEstadoCivilFacade().findAll();
    }

    public List<Cliente> getclientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<TipoIdentificacion> getTiposIdentificacion() {
        return tiposIdentificacion;
    }

    public void setTiposIdentificacion(List<TipoIdentificacion> tiposIdentificacion) {
        this.tiposIdentificacion = tiposIdentificacion;
    }
    
}

