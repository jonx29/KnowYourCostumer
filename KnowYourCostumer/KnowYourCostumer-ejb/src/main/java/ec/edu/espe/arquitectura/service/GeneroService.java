/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.GeneroFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class GeneroService {

    @EJB GeneroFacade generoFacade;

    public GeneroFacade getGeneroFacade() {
        return generoFacade;
    }

    public void setGeneroFacade(GeneroFacade generoFacade) {
        this.generoFacade = generoFacade;
    }
    
    
}
