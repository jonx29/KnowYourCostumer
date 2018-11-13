/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.TipoIdentificacionFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class TipoIdentificacionService {

    @EJB
    private TipoIdentificacionFacade tipoIdentificacionFacade;

    public TipoIdentificacionFacade getTipoIdentificacionFacade() {
        return tipoIdentificacionFacade;
    }

    public void setTipoIdentificacionFacade(TipoIdentificacionFacade tipoIdentificacionFacade) {
        this.tipoIdentificacionFacade = tipoIdentificacionFacade;
    }
    
    
}
