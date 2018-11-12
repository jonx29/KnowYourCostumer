/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Pais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Pais_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.Provincia;
import dao.Identificacion;
import dao.Cliente;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    public boolean isClienteListEmpty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }

    public boolean isProvinciaListEmpty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.provinciaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Provincia> findProvinciaList(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        List<Provincia> provinciaList = mergedEntity.getProvinciaList();
        provinciaList.size();
        return provinciaList;
    }

    public boolean isIdentificacionListEmpty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.identificacionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Identificacion> findIdentificacionList(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        List<Identificacion> identificacionList = mergedEntity.getIdentificacionList();
        identificacionList.size();
        return identificacionList;
    }

    public boolean isClienteList1Empty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.clienteList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList1(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList1 = mergedEntity.getClienteList1();
        clienteList1.size();
        return clienteList1;
    }
    
}
