/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CargoPolitico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.CargoPolitico_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Ciudad;
import dao.Cliente;
import dao.TipoCargoPolitico;

/**
 *
 * @author user
 */
@Stateless
public class CargoPoliticoFacade extends AbstractFacade<CargoPolitico> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoPoliticoFacade() {
        super(CargoPolitico.class);
    }

    public boolean isCiudadEmpty(CargoPolitico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CargoPolitico> cargoPolitico = cq.from(CargoPolitico.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cargoPolitico, entity), cb.isNotNull(cargoPolitico.get(CargoPolitico_.ciudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudad(CargoPolitico entity) {
        return this.getMergedEntity(entity).getCiudad();
    }

    public boolean isClienteEmpty(CargoPolitico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CargoPolitico> cargoPolitico = cq.from(CargoPolitico.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cargoPolitico, entity), cb.isNotNull(cargoPolitico.get(CargoPolitico_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(CargoPolitico entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isTipoCargoPoliticoEmpty(CargoPolitico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CargoPolitico> cargoPolitico = cq.from(CargoPolitico.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cargoPolitico, entity), cb.isNotNull(cargoPolitico.get(CargoPolitico_.tipoCargoPolitico)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoCargoPolitico findTipoCargoPolitico(CargoPolitico entity) {
        return this.getMergedEntity(entity).getTipoCargoPolitico();
    }
    
}
