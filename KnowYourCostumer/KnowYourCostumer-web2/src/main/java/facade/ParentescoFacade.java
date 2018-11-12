/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Parentesco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Parentesco_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.Cliente;
import dao.TipoParentesco;

/**
 *
 * @author user
 */
@Stateless
public class ParentescoFacade extends AbstractFacade<Parentesco> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParentescoFacade() {
        super(Parentesco.class);
    }

    public boolean isClienteEmpty(Parentesco entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Parentesco> parentesco = cq.from(Parentesco.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(parentesco, entity), cb.isNotNull(parentesco.get(Parentesco_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(Parentesco entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isCliente1Empty(Parentesco entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Parentesco> parentesco = cq.from(Parentesco.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(parentesco, entity), cb.isNotNull(parentesco.get(Parentesco_.cliente1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente1(Parentesco entity) {
        return this.getMergedEntity(entity).getCliente1();
    }

    public boolean isCodTipoParentescoEmpty(Parentesco entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Parentesco> parentesco = cq.from(Parentesco.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(parentesco, entity), cb.isNotNull(parentesco.get(Parentesco_.codTipoParentesco)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoParentesco findCodTipoParentesco(Parentesco entity) {
        return this.getMergedEntity(entity).getCodTipoParentesco();
    }
    
}
