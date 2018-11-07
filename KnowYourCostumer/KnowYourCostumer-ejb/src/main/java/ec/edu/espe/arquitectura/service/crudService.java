/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ClienteFacade;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jonathan
 */
@Stateless
@LocalBean
public class crudService {
    @EJB
    private ClienteFacade clienteFacade;

    public int eliminar(Integer codCliente) {
       return clienteFacade.eliminarRegistro(codCliente);        
    }
    
    public int ingresar(String apellidos, String nombres, Date nace, Date ingresa){
        return clienteFacade.ingresarRegistro(apellidos, nombres, nace, ingresa);
    }
}