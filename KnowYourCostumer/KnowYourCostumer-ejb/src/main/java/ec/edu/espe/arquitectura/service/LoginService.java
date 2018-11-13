/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author jeffe
 */
@Stateless
@LocalBean
public class LoginService {

    //Atributos

    @EJB
    private UsuarioFacade usuarioFacade;

    public String usuario(String usu, String contra) {
       return usuarioFacade.Usuario(usu, contra);
        
    }

}
