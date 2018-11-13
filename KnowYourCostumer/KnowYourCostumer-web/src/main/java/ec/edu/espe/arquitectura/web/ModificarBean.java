/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.service.crudService;
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
    private crudService CS;
    
    private List<Cliente> clientes;

    private Cliente cliente;

    private Cliente clienteSel;

    @PostConstruct
    public void init() {
        //this.clientes = this.CS.getClienteFacade().findAll();
        this.cliente = new Cliente();
    }

    public List<Cliente> getclientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
