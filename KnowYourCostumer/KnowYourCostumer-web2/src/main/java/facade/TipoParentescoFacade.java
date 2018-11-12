/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoParentesco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoParentesco_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Parentesco;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoParentescoFacade extends AbstractFacade<TipoParentesco> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoParentescoFacade() {
        super(TipoParentesco.class);
    }

    public boolean isParentescoListEmpty(TipoParentesco entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoParentesco> tipoParentesco = cq.from(TipoParentesco.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoParentesco, entity), cb.isNotEmpty(tipoParentesco.get(TipoParentesco_.parentescoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Parentesco> findParentescoList(TipoParentesco entity) {
        TipoParentesco mergedEntity = this.getMergedEntity(entity);
        List<Parentesco> parentescoList = mergedEntity.getParentescoList();
        parentescoList.size();
        return parentescoList;
    }
    
}
