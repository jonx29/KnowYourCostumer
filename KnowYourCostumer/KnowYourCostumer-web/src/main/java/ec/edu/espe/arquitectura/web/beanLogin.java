/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.espe.arquitectura.Bean_loginLocal;

/**
 *
 * @author User
 */
@ManagedBean()
@SessionScoped
public class beanLogin {

    @EJB
    Bean_loginLocal bean_login;

    String usuario;
    String contrasenia;
    String mensaje;

    public beanLogin() {

    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String ingresar(){
        if (bean_login.Usuario(usuario, contrasenia).equals("1")) {
            //is_pantalla = String.valueOf(bean_permisos.InsertarUsuarioActivo(ls_usuario));
            //mensaje = "Usuario y/o Contrasenia son correctos";
            usuario="";
            contrasenia="";
            return "menu";
        } else {
            mensaje = "Usuario y/o Contrasenia Incorrectos";
            return null;
        }
    }
}