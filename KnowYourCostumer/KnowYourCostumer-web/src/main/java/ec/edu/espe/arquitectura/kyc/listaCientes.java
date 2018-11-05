/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kyc;

import ec.edu.espe.arquitectura.model.Cliente;
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
public class listaCientes {
    
    private ArrayList<Cliente> list = new ArrayList();    
    private ArrayList<Cliente> list1 = new ArrayList();

    
    public void iniciarDatos(){
            list.clear();
    }
    public ArrayList<Cliente> getList() {
        iniciarDatos();
        List<BigDecimal> listaCODIGO = new ArrayList<BigDecimal>();
        List<String> listaNOMBRE = new ArrayList<String>();     
        List<String> listaAPELLIDO = new ArrayList<String>();        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.arquitectura_KnowYourCostumer-web_war_1.0-SNAPSHOTPU");
        EntityManager em1 = factory.createEntityManager();        
        try {
            Query q_codigo = em1.createNativeQuery("SELECT cod_cliente FROM cliente ORDER BY cod_cliente ASC");
            listaCODIGO = q_codigo.getResultList();
            Query q_nombre = em1.createNativeQuery("SELECT nombres FROM cliente ORDER BY cod_cliente ASC");
            listaNOMBRE = q_nombre.getResultList();
            Query q_correo = em1.createNativeQuery("SELECT apellidos FROM cliente ORDER BY cod_cliente ASC");
            listaAPELLIDO = q_correo.getResultList();
        } catch (Exception ex) {
        }
        em1.close();
        factory.close();
        String listaCod = listaCODIGO.toString();
        String[] codigo = listaCod.split("\\[");
        String listaCod1 = codigo[1];
        String[] codigo1 = listaCod1.split("\\]");
        String listaCodFinal = codigo1[0];
        String[] codigoFinal = listaCodFinal.split(", ");
        for (int i = 0; i < listaNOMBRE.size(); i++) {
            list.add(new Cliente(Integer.parseInt(codigoFinal[i]), listaNOMBRE.get(i), listaAPELLIDO.get(i),null,null));
        }
        return list;
    }
    public void setList(ArrayList<Cliente> list) {
        this.list = list;
    }
    public ArrayList<Cliente> getList1() {        
        iniciarDatos();
        List<BigDecimal> listaCODIGO = new ArrayList<BigDecimal>();       
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.arquitectura_KnowYourCostumer-web_war_1.0-SNAPSHOTPU");
        EntityManager em1 = factory.createEntityManager();   
        try {
            Query q_codigo = em1.createNativeQuery("SELECT cod_cliente FROM cliente ORDER BY cod_cliente ASC");
            listaCODIGO = q_codigo.getResultList();
        } catch (Exception ex) {
        }
        em1.close();
        factory.close();
        String listaCod = listaCODIGO.toString();
        String[] codigo = listaCod.split("\\[");
        String listaCod1 = codigo[1];
        String[] codigo1 = listaCod1.split("\\]");
        String listaCodFinal = codigo1[0];
        String[] codigoFinal = listaCodFinal.split(", ");
        for (int i = 0; i < codigoFinal.length; i++) {
            list.add(new Cliente(Integer.parseInt(codigoFinal[i]), null, null,null,null));
        }
        return list;
    }
}