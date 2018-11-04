/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateful
public class Bean_login implements Bean_loginLocal {

    @Override
        public String Usuario(String usu, String contra) {
        String val = "0";
        List<String> usuario = new ArrayList<String>();
        List<String> contrasenia = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.arquitectura_KnowYourCostumer-ejb_ejb_1.0-SNAPSHOTPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT correo FROM usuario WHERE correo='" + usu + "'");
            Query q2 = em1.createNativeQuery("SELECT clave FROM usuario WHERE correo='" + usu + "'");
            usuario = q.getResultList();
            contrasenia = q2.getResultList();
            if (usu.equals(usuario.get(0)) && contra.equals(contrasenia.get(0))) {
                val = "1";
            } else {
                val = "0";
            }
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
            val = "0";
        }
        em1.close();
        factory.close();
        return val;
    }
}
