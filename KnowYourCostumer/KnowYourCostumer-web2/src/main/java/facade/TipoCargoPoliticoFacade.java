/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoCargoPolitico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoCargoPolitico_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.CargoPolitico;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoCargoPoliticoFacade extends AbstractFacade<TipoCargoPolitico> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCargoPoliticoFacade() {
        super(TipoCargoPolitico.class);
    }

    public boolean isCargoPoliticoListEmpty(TipoCargoPolitico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoCargoPolitico> tipoCargoPolitico = cq.from(TipoCargoPolitico.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoCargoPolitico, entity), cb.isNotEmpty(tipoCargoPolitico.get(TipoCargoPolitico_.cargoPoliticoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CargoPolitico> findCargoPoliticoList(TipoCargoPolitico entity) {
        TipoCargoPolitico mergedEntity = this.getMergedEntity(entity);
        List<CargoPolitico> cargoPoliticoList = mergedEntity.getCargoPoliticoList();
        cargoPoliticoList.size();
        return cargoPoliticoList;
    }
    
}
