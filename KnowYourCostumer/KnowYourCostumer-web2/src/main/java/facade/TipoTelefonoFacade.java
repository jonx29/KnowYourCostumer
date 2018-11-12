/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoTelefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoTelefono_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.NumeroTelefono;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoTelefonoFacade extends AbstractFacade<TipoTelefono> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTelefonoFacade() {
        super(TipoTelefono.class);
    }

    public boolean isNumeroTelefonoListEmpty(TipoTelefono entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoTelefono> tipoTelefono = cq.from(TipoTelefono.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoTelefono, entity), cb.isNotEmpty(tipoTelefono.get(TipoTelefono_.numeroTelefonoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NumeroTelefono> findNumeroTelefonoList(TipoTelefono entity) {
        TipoTelefono mergedEntity = this.getMergedEntity(entity);
        List<NumeroTelefono> numeroTelefonoList = mergedEntity.getNumeroTelefonoList();
        numeroTelefonoList.size();
        return numeroTelefonoList;
    }
    
}
