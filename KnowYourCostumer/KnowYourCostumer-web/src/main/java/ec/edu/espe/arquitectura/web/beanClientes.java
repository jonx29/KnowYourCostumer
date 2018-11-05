/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import ec.edu.espe.arquitectura.model.Cliente;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.espe.arquitectura.service.crudService;
import ec.edu.espe.arquitectura.kyc.listaCientes;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author User
 */
@ManagedBean()
@SessionScoped
public class beanClientes {
     //@EJB
    // Bean_loginLocal bean_login;
    @EJB
    crudService bean_cliente_eliminar;
    private Cliente objCliente;
    public String mensaje;
    public List codigo;
    public listaCientes obj;
    
    public beanClientes() {
        objCliente = new Cliente();
    }

    public List getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {        
        this.codigo = obj.getList1();
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
        
    public String eliminar() {
        if (bean_cliente_eliminar.eliminar(objCliente.codigo())== 1) {
            return "eliminacion";
        } else {
            mensaje = "Usuario y/o Contrasenia Incorrectos";
            return null;
        }
    }

}
