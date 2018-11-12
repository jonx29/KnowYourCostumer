/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoIngreso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoIngreso_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.IngresoCliente;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoIngresoFacade extends AbstractFacade<TipoIngreso> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIngresoFacade() {
        super(TipoIngreso.class);
    }

    public boolean isIngresoClienteListEmpty(TipoIngreso entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoIngreso> tipoIngreso = cq.from(TipoIngreso.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoIngreso, entity), cb.isNotEmpty(tipoIngreso.get(TipoIngreso_.ingresoClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<IngresoCliente> findIngresoClienteList(TipoIngreso entity) {
        TipoIngreso mergedEntity = this.getMergedEntity(entity);
        List<IngresoCliente> ingresoClienteList = mergedEntity.getIngresoClienteList();
        ingresoClienteList.size();
        return ingresoClienteList;
    }
    
}
