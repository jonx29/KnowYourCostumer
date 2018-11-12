/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoCuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoCuenta_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cuenta;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoCuentaFacade extends AbstractFacade<TipoCuenta> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCuentaFacade() {
        super(TipoCuenta.class);
    }

    public boolean isCuentaListEmpty(TipoCuenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoCuenta> tipoCuenta = cq.from(TipoCuenta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoCuenta, entity), cb.isNotEmpty(tipoCuenta.get(TipoCuenta_.cuentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuenta> findCuentaList(TipoCuenta entity) {
        TipoCuenta mergedEntity = this.getMergedEntity(entity);
        List<Cuenta> cuentaList = mergedEntity.getCuentaList();
        cuentaList.size();
        return cuentaList;
    }
    
}
