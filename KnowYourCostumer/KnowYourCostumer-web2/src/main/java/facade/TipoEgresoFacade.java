/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoEgreso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoEgreso_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.EgresoCliente;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoEgresoFacade extends AbstractFacade<TipoEgreso> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEgresoFacade() {
        super(TipoEgreso.class);
    }

    public boolean isEgresoClienteListEmpty(TipoEgreso entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoEgreso> tipoEgreso = cq.from(TipoEgreso.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoEgreso, entity), cb.isNotEmpty(tipoEgreso.get(TipoEgreso_.egresoClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<EgresoCliente> findEgresoClienteList(TipoEgreso entity) {
        TipoEgreso mergedEntity = this.getMergedEntity(entity);
        List<EgresoCliente> egresoClienteList = mergedEntity.getEgresoClienteList();
        egresoClienteList.size();
        return egresoClienteList;
    }
    
}
