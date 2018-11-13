/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.EstadoCivilFacade;
import ec.edu.espe.arquitectura.model.EstadoCivil;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class EstadoCivilService {

    @EJB
    private EstadoCivilFacade estadoCivilFacade;

    public EstadoCivilFacade getEstadoCivilFacade() {
        return estadoCivilFacade;
    }

    public void setEstadoCivilFacade(EstadoCivilFacade estadoCivilFacade) {
        this.estadoCivilFacade = estadoCivilFacade;
    }

    
    
    
}
