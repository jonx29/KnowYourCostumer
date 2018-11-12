/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Ciudad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Calle;
import dao.CargoPolitico;
import dao.Provincia;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public boolean isCalleListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.calleList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Calle> findCalleList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Calle> calleList = mergedEntity.getCalleList();
        calleList.size();
        return calleList;
    }

    public boolean isCargoPoliticoListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.cargoPoliticoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CargoPolitico> findCargoPoliticoList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<CargoPolitico> cargoPoliticoList = mergedEntity.getCargoPoliticoList();
        cargoPoliticoList.size();
        return cargoPoliticoList;
    }

    public boolean isCodProvinciaEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotNull(ciudad.get(Ciudad_.codProvincia)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Provincia findCodProvincia(Ciudad entity) {
        return this.getMergedEntity(entity).getCodProvincia();
    }
    
}
