/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoReferencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoReferencia_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Referencia;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoReferenciaFacade extends AbstractFacade<TipoReferencia> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReferenciaFacade() {
        super(TipoReferencia.class);
    }

    public boolean isReferenciaListEmpty(TipoReferencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoReferencia> tipoReferencia = cq.from(TipoReferencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoReferencia, entity), cb.isNotEmpty(tipoReferencia.get(TipoReferencia_.referenciaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Referencia> findReferenciaList(TipoReferencia entity) {
        TipoReferencia mergedEntity = this.getMergedEntity(entity);
        List<Referencia> referenciaList = mergedEntity.getReferenciaList();
        referenciaList.size();
        return referenciaList;
    }
    
}
