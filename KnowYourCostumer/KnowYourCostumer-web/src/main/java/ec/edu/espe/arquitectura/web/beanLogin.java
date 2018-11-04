/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.service.loginService;

/**
 *
 * @author User
 */
@ManagedBean()
@SessionScoped
public class beanLogin {

    //@EJB
    // Bean_loginLocal bean_login;
    @EJB
    loginService bean_login;
    private Usuario objUsuario = new Usuario();
    public String mensaje;

    public beanLogin() {

    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public String ingresar() {
        if (bean_login.usuario(objUsuario.getCorreo(), objUsuario.getClave()).equals("1")) {
            return "menu";
        } else {
            mensaje = "Usuario y/o Contrasenia Incorrectos";
            return null;
        }
    }

    /**
     * @return the objUsuario
     */
    public Usuario getObjUsuario() {
        return objUsuario;
    }

    /**
     * @param objUsuario the objUsuario to set
     */
    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
}
