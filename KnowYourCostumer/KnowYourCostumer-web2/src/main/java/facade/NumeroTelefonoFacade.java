/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.NumeroTelefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.NumeroTelefono_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.TipoTelefono;

/**
 *
 * @author user
 */
@Stateless
public class NumeroTelefonoFacade extends AbstractFacade<NumeroTelefono> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NumeroTelefonoFacade() {
        super(NumeroTelefono.class);
    }

    public boolean isClienteEmpty(NumeroTelefono entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumeroTelefono> numeroTelefono = cq.from(NumeroTelefono.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numeroTelefono, entity), cb.isNotNull(numeroTelefono.get(NumeroTelefono_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(NumeroTelefono entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isCodTipoTelefonoEmpty(NumeroTelefono entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumeroTelefono> numeroTelefono = cq.from(NumeroTelefono.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numeroTelefono, entity), cb.isNotNull(numeroTelefono.get(NumeroTelefono_.codTipoTelefono)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoTelefono findCodTipoTelefono(NumeroTelefono entity) {
        return this.getMergedEntity(entity).getCodTipoTelefono();
    }
    
}
