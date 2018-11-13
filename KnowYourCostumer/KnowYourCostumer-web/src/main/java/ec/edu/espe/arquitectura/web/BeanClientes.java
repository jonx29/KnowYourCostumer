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
import ec.edu.espe.arquitectura.service.CrudService;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author User
 */
//@Named
@ManagedBean()
@SessionScoped
public class BeanClientes implements Serializable {
    //@EJB
    // Bean_loginLocal bean_login;

    @Inject
    CrudService bean_cliente;
    private Cliente objCliente;
    public String mensaje;

    //Datos Personales
    public String tipo_cedula;
    public String cedula;
    public String apellidos;
    public String nombres;
    public Date fecha_ingreso;
    public Date fecha_nace;
    public String profecion;
    public String Genero;
    public String pais;
    public String ciudadania;
    public String estadoCivil;

    //Direccion de Residencia
    public String paisResidencia;
    public String provinciaResidencia;
    public String ciudadResidencia;
    public String callePrincipal;
    public int numCasa;
    public String calleSecundaria;
    public String referencia;
    public int celular;
    public int domicilio;

    //Referencias
    public String tipoReferencia;
    public String cedulaReferencia;
    public String apellidosReferencia;
    public String nombresReferencia;
    public String GeneroReferencia;
    public String paisReferencia;
    public String ciudadaniaReferencia;
    public String estadoCivilReferencia;

    //Parentesco con empleados    
    public String parentesco;
    public String apellidosEmpleados;
    public String nombresEmpleados;
    public Date fechaEmpleado;
    public String paisEmpleado;

    //Datos Economicos
    public String actividadEconomica;
    public double ingresos = new Double(0);
    public double egresos = new Double(0);

    //Actividad Politica
    public String cargoPolitico;
    public Date fechaInicio;
    public Date fechaFin;

    
    
    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }

    
    public String getTipo_cedula() {
        return tipo_cedula;
    }

    public void setTipo_cedula(String tipo_cedula) {
        this.tipo_cedula = tipo_cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_nace() {
        return fecha_nace;
    }

    public void setFecha_nace(Date fecha_nace) {
        this.fecha_nace = fecha_nace;
    }

    public BeanClientes() {
        objCliente = new Cliente();
        ingresos = 0d;
        egresos = 0d;
        mensaje="";
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

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudadania() {
        return ciudadania;
    }

    public void setCiudadania(String ciudadania) {
        this.ciudadania = ciudadania;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getProvinciaResidencia() {
        return provinciaResidencia;
    }

    public void setProvinciaResidencia(String provinciaResidencia) {
        this.provinciaResidencia = provinciaResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    public String getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public String getCedulaReferencia() {
        return cedulaReferencia;
    }

    public void setCedulaReferencia(String cedulaReferencia) {
        this.cedulaReferencia = cedulaReferencia;
    }

    public String getApellidosReferencia() {
        return apellidosReferencia;
    }

    public void setApellidosReferencia(String apellidosReferencia) {
        this.apellidosReferencia = apellidosReferencia;
    }

    public String getNombresReferencia() {
        return nombresReferencia;
    }

    public void setNombresReferencia(String nombresReferencia) {
        this.nombresReferencia = nombresReferencia;
    }

    public String getGeneroReferencia() {
        return GeneroReferencia;
    }

    public void setGeneroReferencia(String GeneroReferencia) {
        this.GeneroReferencia = GeneroReferencia;
    }

    public String getPaisReferencia() {
        return paisReferencia;
    }

    public void setPaisReferencia(String paisReferencia) {
        this.paisReferencia = paisReferencia;
    }

    public String getCiudadaniaReferencia() {
        return ciudadaniaReferencia;
    }

    public void setCiudadaniaReferencia(String ciudadaniaReferencia) {
        this.ciudadaniaReferencia = ciudadaniaReferencia;
    }

    public String getEstadoCivilReferencia() {
        return estadoCivilReferencia;
    }

    public void setEstadoCivilReferencia(String estadoCivilReferencia) {
        this.estadoCivilReferencia = estadoCivilReferencia;
    }

    public String getApellidosEmpleados() {
        return apellidosEmpleados;
    }

    public void setApellidosEmpleados(String apellidosEmpleados) {
        this.apellidosEmpleados = apellidosEmpleados;
    }

    public String getNombresEmpleados() {
        return nombresEmpleados;
    }

    public void setNombresEmpleados(String nombresEmpleados) {
        this.nombresEmpleados = nombresEmpleados;
    }

    public Date getFechaEmpleado() {
        return fechaEmpleado;
    }

    public void setFechaEmpleado(Date fechaEmpleado) {
        this.fechaEmpleado = fechaEmpleado;
    }

    public String getPaisEmpleado() {
        return paisEmpleado;
    }

    public void setPaisEmpleado(String paisEmpleado) {
        this.paisEmpleado = paisEmpleado;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(String cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String eliminar() {
        if (bean_cliente.eliminar(objCliente.codigo()) == 1) {
            return "eliminacion";
        } else {
            mensaje = "No se pudo realizar la eliminacion";
            return null;
        }
    }

    public String insertar() throws ParseException {
        if ("RUC".equals(tipo_cedula)) {
            if (validacionRUC(cedula)) {

            } else {
                mensaje = "No es un RUC correcto";
                return null;
            }
        } else {
            if ("Cedula de ciudadania".equals(tipo_cedula)) {
                if (validacionCedula(cedula)) {
                    if ((bean_cliente.ingresar(apellidos, nombres, fecha_nace, fecha_ingreso, Genero, estadoCivil, profecion, cedula, pais, tipo_cedula) == 1)
                            && (bean_cliente.ingresarRes(paisResidencia, ciudadResidencia, provinciaResidencia, callePrincipal, calleSecundaria,
                                    numCasa, referencia, celular, domicilio) == 1)
                            && (bean_cliente.ingresarEconomicos(actividadEconomica, ingresos, egresos) == 1)
                            && (bean_cliente.ingresarPolitica(cargoPolitico, fechaInicio, fechaFin) == 1)
                            && (bean_cliente.ingresarParentesco(nombresEmpleados, apellidosEmpleados, fechaEmpleado, paisEmpleado, parentesco) == 1)) {
                        limpiarCampos();
                        mensaje = "Inserción de Datos correctamente";
                        return "insercion";
                    } else {
                        mensaje = "No se pudo realizar la inserción de los datos";
                        return null;
                    }
                } else {
                    mensaje = "No se pudo realizar la inserción, cédula no existente";
                    return null;
                }
            } else {
                mensaje = "Opcion no valida";
                return null;
            }
        }
        return mensaje;
    }

    public boolean validacionCedula(String cedula) {
        boolean resp_dato = false;
        int num_provincias = 24;
        if (cedula.length() == 10) {
            char[] caracteres = new char[cedula.length()];
            for (int i = 0; i < cedula.length(); i++) {
                caracteres[i] = (char) cedula.charAt(i);
                if (!Character.isDigit(caracteres[i])) {
                    return resp_dato;
                }
            }
            //verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
            int prov = Integer.parseInt(cedula.substring(0, 2));
            if (!((prov > 0) && (prov <= num_provincias))) {
                //addError("La cédula ingresada no es válida");
                System.out.println("Error: cedula ingresada mal");
                return resp_dato;
            }
            //verifica que el último dígito de la cédula sea válido
            int[] d = new int[10];
            //Asignamos el string a un array
            for (int i = 0; i < d.length; i++) {
                d[i] = Integer.parseInt(cedula.charAt(i) + "");
            }
            int imp = 0;
            int par = 0;
            //sumamos los duplos de posición impar
            for (int i = 0; i < d.length; i += 2) {
                d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
                imp += d[i];
            }
            //sumamos los digitos de posición par
            for (int i = 1; i < (d.length - 1); i += 2) {
                par += d[i];
            }
            //Sumamos los dos resultados
            int suma = imp + par;
            //Restamos de la decena superior
            int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
                    + "0") - suma;
            //Si es diez el décimo dígito es cero     
            d10 = (d10 == 10) ? 0 : d10;
            //si el décimo dígito calculado es igual al digitado la cédula es correcta
            if (d10 == d[9]) {
                resp_dato = true;
                return resp_dato;
            } else {
                //addError("La cédula ingresada no es válida");
                return resp_dato;
            }
        } else {
            return resp_dato;
        }
    }
    private static final int NUM_PROVINCIAS = 24;
    private static int[] coeficientes = {4, 3, 2, 7, 6, 5, 4, 3, 2};
    private static int constante = 11;

    public Boolean validacionRUC(String ruc) {
        boolean resp_dato = false;
        final int prov = Integer.parseInt(ruc.substring(0, 2));
        if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
            resp_dato = false;
        }
        int[] d = new int[10];
        int suma = 0;
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(ruc.charAt(i) + "");
        }
        for (int i = 0; i < d.length - 1; i++) {
            d[i] = d[i] * coeficientes[i];
            suma += d[i];
        }
        int aux, resp;
        aux = suma % constante;
        resp = constante - aux;
        resp = (aux == 0) ? 0 : resp;
        if (resp == d[9]) {
            resp_dato = true;
        } else {
            resp_dato = false;
        }
        return resp_dato;
    }

    public void limpiarCampos() {
        cedula = "";
        apellidos = "";
        nombres = "";
        profecion = "";
        Genero = "";
        pais = "";
        ciudadania = "";
        estadoCivil = "";

        //Direccion de Residencia
        paisResidencia = "";
        provinciaResidencia = "";
        ciudadResidencia = "";
        callePrincipal = "";
        numCasa = 0;
        calleSecundaria = "";
        referencia = "";
        celular = 0;
        domicilio = 0;

        //Referencias
        tipoReferencia = "";
        cedulaReferencia = "";
        apellidosReferencia = "";
        nombresReferencia = "";
        GeneroReferencia = "";
        paisReferencia = "";
        ciudadaniaReferencia = "";
        estadoCivilReferencia = "";

        //Parentesco con empleados    
        apellidosEmpleados = "";
        nombresEmpleados = "";
        paisEmpleado = "";

        //Datos Economicos
        actividadEconomica = "";
        ingresos = 0;
        egresos = 0;

        //Actividad Politica
        cargoPolitico = "";
    }

}
