/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ClienteFacade;
import ec.edu.espe.arquitectura.model.Cliente;
import java.sql.Time;
import java.util.Date;
import java.util.List;
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

    public int ingresar(String apellidos, String nombres, Date nace, Date ingresa, String genero1, String estado1, String profesion) {
        return clienteFacade.ingresarCliente(apellidos, nombres, nace, ingresa, genero1, estado1, profesion);
    }

    public Cliente buscarCliente(Integer codCliente) {
        System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busqueda(codCliente);

    }
}
