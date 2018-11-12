/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EgresoCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.EgresoCliente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.TipoEgreso;

/**
 *
 * @author user
 */
@Stateless
public class EgresoClienteFacade extends AbstractFacade<EgresoCliente> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EgresoClienteFacade() {
        super(EgresoCliente.class);
    }

    public boolean isClienteEmpty(EgresoCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EgresoCliente> egresoCliente = cq.from(EgresoCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(egresoCliente, entity), cb.isNotNull(egresoCliente.get(EgresoCliente_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(EgresoCliente entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isTipoEgresoEmpty(EgresoCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EgresoCliente> egresoCliente = cq.from(EgresoCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(egresoCliente, entity), cb.isNotNull(egresoCliente.get(EgresoCliente_.tipoEgreso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoEgreso findTipoEgreso(EgresoCliente entity) {
        return this.getMergedEntity(entity).getTipoEgreso();
    }
    
}
