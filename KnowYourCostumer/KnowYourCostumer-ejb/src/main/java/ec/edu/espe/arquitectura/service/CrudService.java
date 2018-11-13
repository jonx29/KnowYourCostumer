/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ClienteFacade;
import ec.edu.espe.arquitectura.model.ActividadEconomica;
import ec.edu.espe.arquitectura.model.CargoPolitico;
import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.model.EgresoCliente;
import ec.edu.espe.arquitectura.model.Identificacion;
import ec.edu.espe.arquitectura.model.IngresoCliente;
import ec.edu.espe.arquitectura.model.NumeroTelefono;
import ec.edu.espe.arquitectura.model.Parentesco;
import ec.edu.espe.arquitectura.model.ProfesionCliente;
import ec.edu.espe.arquitectura.model.Referencia;
import java.sql.Time;
import java.text.ParseException;
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
public class CrudService {

    @EJB
    private ClienteFacade clienteFacade;

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public int eliminar(Integer codCliente) {
        return clienteFacade.eliminarRegistro(codCliente);
    }

    public int ingresar(String apellidos, String nombres, Date nace, Date ingresa, String genero1, String estado1, String profesion, String cedula, String pais, String tipoIdef) throws ParseException {
        return clienteFacade.ingresarCliente(apellidos, nombres, nace, ingresa, genero1, estado1, profesion, cedula, pais, tipoIdef);
    }

    public int ingresarRes(String pais, String ciudad, String provincia, String calleP, String calleS, int casa, String referencia, int celular, int domicilio) {
        return clienteFacade.ingresarResidencia(pais, ciudad, provincia, calleP, calleS, casa, referencia, celular, domicilio);
    }
    
    public int ingresarEconomicos(String actividad, double ingresos, double egresos) {
        return clienteFacade.ingresarDatosEconomicos(actividad, ingresos, egresos);
    }
    
    public int ingresarPolitica(String cargo, Date inicio, Date Fin) {
        return clienteFacade.ingresarActividadPolitica(cargo, inicio, Fin);
    }
    
    public int ingresarParentesco(String nombre, String apellido, Date nace, String pais, String parentesco1) throws ParseException {
        return clienteFacade.ingresarParentescoEmpleados(nombre, apellido, nace, pais, parentesco1);
    }
    
    public Cliente buscarCliente(Integer codCliente) {
        System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busqueda(codCliente);

    }

      public Identificacion buscarClienteIndentificacion(Cliente obj) {
       // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaIndentificacion(obj);

    }

         public ProfesionCliente buscarClienteProfesion(Cliente obj) {
       // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaProfesion(obj);

    }

                 public NumeroTelefono buscarClienteTelefono(Cliente obj) {
       // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaTelefono(obj);

    }

                                public Referencia buscarClienteReferencia(Cliente obj) {
       // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaReferencia(obj);

    }

    public CargoPolitico buscarClientePolitico(Cliente obj) {
        // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaCargaPolitica(obj);

    }

    public ActividadEconomica buscarClienteActividadEconomica(Cliente obj) {
        // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaActividadEconomica(obj);

    }
                                
    public EgresoCliente buscarClienteEgreso(Cliente obj) {
        // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaEgreso(obj);

}

    public IngresoCliente buscarClienteIngreso(Cliente obj) {
        // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaIngreso(obj);

    }
     public Parentesco buscarParentesco(Cliente obj) {
        // System.out.println("nuevooooooo" + codCliente);
        return clienteFacade.busquedaParentesco(obj);

    }
//        public Identificacion buscarParentesco1(Cliente obj) {
//        // System.out.printlnC("nuevooooooo" + codCliente);
//        return clienteFacade.busquedaParentesco(obj);
//
//    }
}

