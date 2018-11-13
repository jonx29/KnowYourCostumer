/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.PaisFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class PaisService {

    @EJB
    private PaisFacade paisFacade;

    public PaisFacade getPaisFacade() {
        return paisFacade;
    }

    public void setPaisFacade(PaisFacade paisFacade) {
        this.paisFacade = paisFacade;
    }
    
    
}
