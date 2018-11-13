/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kyc;

import ec.edu.espe.arquitectura.model.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author JONATHAN
 */
@ManagedBean()
@SessionScoped

public class ListaUsuario {
    
    private ArrayList<Usuario> list = new ArrayList();
    
    public void iniciarDatos(){
            list.clear();
    }
    public ArrayList<Usuario> getList() {
        iniciarDatos();
        List<BigDecimal> listaCODIGO = new ArrayList<BigDecimal>();
        List<String> listaNOMBRE = new ArrayList<String>();     
        List<String> listaCORREO = new ArrayList<String>();
        List<String> listaCLAVE = new ArrayList<String>();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.arquitectura_KnowYourCostumer-web_war_1.0-SNAPSHOTPU");
        EntityManager em1 = factory.createEntityManager();
        
        try {
            Query q_codigo = em1.createNativeQuery("SELECT cod_usuario FROM usuario ORDER BY cod_usuario ASC");
            listaCODIGO = q_codigo.getResultList();
            Query q_nombre = em1.createNativeQuery("SELECT nombre FROM usuario ORDER BY cod_usuario ASC");
            listaNOMBRE = q_nombre.getResultList();
            Query q_correo = em1.createNativeQuery("SELECT correo FROM usuario ORDER BY cod_usuario ASC");
            listaCORREO = q_correo.getResultList();
            Query q_clave = em1.createNativeQuery("SELECT clave FROM usuario ORDER BY cod_usuario ASC");
            listaCLAVE = q_clave.getResultList();
        } catch (Exception ex) {
        }
        em1.close();
        factory.close();
        String listaCod = listaCODIGO.toString();
        String[] codigo = listaCod.split("\\[");
        String listaCod1 = codigo[1];
        String[] codigo1 = listaCod1.split("\\]");
        String listaCodFinal = codigo1[0];
        String[] codigoFinal = listaCodFinal.split(",");
        for (int i = 0; i < listaNOMBRE.size(); i++) {
            //arr_nombres[i] = new AutorJsf(codigoFinal[i], listaNOMBRE.get(i), listaCLAVE.get(i));
            list.add(new Usuario(Integer.parseInt(codigoFinal[i]), listaNOMBRE.get(i), listaCORREO.get(i), listaCLAVE.get(i)));
        }
        return list;
    }

    public void setList(ArrayList<Usuario> list) {
        this.list = list;
    }
    
}
