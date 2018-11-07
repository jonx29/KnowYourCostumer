/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cliente;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

    public int ingresarRegistro(String apellidos, String nombres, Date nace, Date registro) {
        int retorno = 0;
        //try {
        Query query = em.createNativeQuery("INSERT INTO cliente(cod_cliente, cod__direccion, cod_estado_civil, "
                + "cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento, fecha_registro, hora_registro) "
                + "VALUES (" + maxCodigo() + ", 1, 1, 1, 1, 1, '" + nombres + "', '" + apellidos + "', '" + nace + "', '" + registro + "', '1:00:00')");
        query.executeUpdate();
        retorno = 1;
        /*} catch (Exception ex) {
         retorno = 0;
         }*/
        return retorno;
    }

    public Cliente busqueda(Integer codCliente) {

        Cliente cliente;
 
        System.out.println("este es el utimo");

        try {
            System.out.println("estoy en try");
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.codCliente = :codCliente");
            query.setParameter("codCliente", codCliente);
            cliente = (Cliente) query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR" + e);
            cliente = null;
        }

        return cliente;

    }

}
