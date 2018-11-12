/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Cuenta_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.TipoCuenta;

/**
 *
 * @author user
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    public boolean isCodClienteEmpty(Cuenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuenta> cuenta = cq.from(Cuenta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuenta, entity), cb.isNotNull(cuenta.get(Cuenta_.codCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCodCliente(Cuenta entity) {
        return this.getMergedEntity(entity).getCodCliente();
    }

    public boolean isCodTipoCuentaEmpty(Cuenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuenta> cuenta = cq.from(Cuenta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuenta, entity), cb.isNotNull(cuenta.get(Cuenta_.codTipoCuenta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoCuenta findCodTipoCuenta(Cuenta entity) {
        return this.getMergedEntity(entity).getCodTipoCuenta();
    }
    
}
