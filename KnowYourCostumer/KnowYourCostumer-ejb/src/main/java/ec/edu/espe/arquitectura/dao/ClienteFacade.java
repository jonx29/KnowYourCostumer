/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cliente;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_KnowYourCostumer-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public int eliminarRegistro(Integer codigo) {
        int retorno = 0;
        try {
            Query query1 = em.createNativeQuery("Delete from nacionalidad where cod_cliente = " + codigo);
            query1.executeUpdate();
            Query query2 = em.createNativeQuery("Delete from identificacion where cod_cliente = " + codigo);
            query2.executeUpdate();
            Query query3 = em.createNativeQuery("Delete from contacto where cod_cliente = " + codigo);
            query3.executeUpdate();
            Query query4 = em.createNativeQuery("Delete from egreso_cliente where cod_cliente = " + codigo);
            query4.executeUpdate();
            Query query5 = em.createNativeQuery("Delete from cargo_politico where cod_cliente = " + codigo);
            query5.executeUpdate();
            Query query6 = em.createNativeQuery("Delete from profesion_cliente where cod_cliente = " + codigo);
            query6.executeUpdate();
            Query query7 = em.createNativeQuery("Delete from ingreso_cliente where cod_cliente = " + codigo);
            query7.executeUpdate();
            Query query8 = em.createNativeQuery("Delete from referencia where cod_cliente = " + codigo);
            query8.executeUpdate();
            Query query9 = em.createNativeQuery("Delete from parentesco where cod_cliente = " + codigo);
            query9.executeUpdate();
            Query query10 = em.createNativeQuery("Delete from actividad_economica where cod_cliente = " + codigo);
            query10.executeUpdate();
            Query query11 = em.createNativeQuery("Delete from cuenta where cod_cliente = " + codigo);
            query11.executeUpdate();
            Query query12 = em.createNativeQuery("Delete from numero_telefono where cod_cliente = " + codigo);
            query12.executeUpdate();

            Query query = em.createNativeQuery("Delete from cliente where cod_cliente = " + codigo);
            query.executeUpdate();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
        }
        return retorno;
    }

    public int maxCodigo() {
        int valorMaximo = 0;
        List<BigDecimal> listaMaxima = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT MAX(cod_cliente)+1 FROM cliente");
        listaMaxima = q_maximo.getResultList();
        valorMaximo = Integer.parseInt(listaMaxima.get(0).toString());
        return valorMaximo;
    }

    public int maxCodigoProfesion() {
        int valorMaximo = 0;
        List<BigDecimal> listaMaxima = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT MAX(cod_profesion)+1 FROM profesion");
        listaMaxima = q_maximo.getResultList();
        valorMaximo = Integer.parseInt(listaMaxima.get(0).toString());
        return valorMaximo;
    }

    public static java.sql.Time SparseToTime(String hora) {
        int h, m, s;
        h = Integer.parseInt(hora.charAt(0) + "" + hora.charAt(1));
        m = Integer.parseInt(hora.charAt(3) + "" + hora.charAt(4));
        s = Integer.parseInt(hora.charAt(6) + "" + hora.charAt(7));
        return (new java.sql.Time(h, m, s));
    }

    public int genero(String genero) {
        int generoFinal = 0;
        List<BigDecimal> listaGenero = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT cod_genero FROM genero where descripcion='" + genero + "'");
        listaGenero = q_maximo.getResultList();
        generoFinal = Integer.parseInt(listaGenero.get(0).toString());
        return generoFinal;
    }

    public int estadoCivil(String estado) {
        int estadoCivilFinal = 0;
        List<BigDecimal> listaEstado = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT cod_estado_civil FROM estado_civil where descripcion='" + estado + "'");
        listaEstado = q_maximo.getResultList();
        estadoCivilFinal = Integer.parseInt(listaEstado.get(0).toString());
        return estadoCivilFinal;
    }

    public int ingresarCliente(String apellidos, String nombres, Date nace, Date registro, String genero1, String estado1, String profesion) {
        int retorno = 0;
        //try {
        //PROFESION:
        Query query1 = em.createNativeQuery("INSERT INTO profesion(cod_profesion, descripcion) "
                + "VALUES (" + maxCodigoProfesion() + ",'" + profesion + "')");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("INSERT INTO profesion_cliente(cod_profesion_cliente, cod_cliente, cod_profesion) "
                + "VALUES ((SELECT MAX(cod_profesion_cliente)+1 FROM profesion_cliente),1,(SELECT MAX(cod_profesion) FROM profesion))");
        query2.executeUpdate();

        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Query query = em.createNativeQuery("INSERT INTO cliente(cod_cliente, cod__direccion, cod_estado_civil, "
                + "cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento, fecha_registro, hora_registro) "
                + "VALUES (" + maxCodigo() + ", 1, " + estadoCivil(estado1) + "," + genero(genero1) + ", 1, 1, '" + nombres + "', '" + apellidos + "', '" + nace + "', '" + registro + "', '" + sdf.format(hoy) + "')");
        query.executeUpdate();

        Query query20 = em.createNativeQuery("UPDATE profesion_cliente SET cod_cliente= (SELECT MAX(cod_cliente) FROM cliente) where cod_profesion_cliente=(SELECT MAX(cod_profesion_cliente) FROM profesion_cliente)");
        query20.executeUpdate();
        
        retorno = 1;
        /*} catch (Exception ex) {
         retorno = 0;
         }*/
        return retorno;
    }

    public Cliente busqueda(Integer codCliente) {

        Cliente cliente = null;

        try {
            Query q = em.createNativeQuery("SELECT * FROM cliente WHERE cod_cliente='" + codCliente + "'");
            List li = q.getResultList();

            if (li.size() >= 1) {

                for (Object lista : li) {
                    Object[] clientes = (Object[]) (lista);
                    int codigo = (int) clientes[0];
                    int direccion = (int) clientes[1];
                    int estadoCivil = (int) clientes[2];
                    int genero = (int) clientes[3];
                    int personeria = (int) clientes[4];
                    int pais = (int) clientes[5];
                    String nombres = clientes[6].toString();
                    String apellidos = clientes[7].toString();
                    Date fechaNac = (Date) clientes[8];
                    Date fechaRegis = (Date) clientes[9];
                    Time tiempo = (Time) clientes[10];
                    cliente = new Cliente(codCliente, nombres, apellidos, fechaRegis, fechaRegis);

                }
            }
        } catch (Exception ex) {

        }

        return cliente;
    }

}
